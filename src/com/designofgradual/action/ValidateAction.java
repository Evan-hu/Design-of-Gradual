package com.designofgradual.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.servlet.HttpServletBean;

import net.sf.json.JSONObject;

import com.designofgradual.dao.UserDao;
import com.designofgradual.util.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class ValidateAction extends BaseAction{
	private String userName;
	private String tip;
	private String result;
	private String code;
	private String mail;
	private UserDao userDao;

	/**
	 * 
	 * Todo��Validate username
	 * @author Evan
	 * Date��2014-3-30
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public String execute() throws Exception{
		try {
			if (userDao.validateName(userName)) {
				setTip("�û�����"+ userName +"������");
			} else {
				setTip("�û�����"+ userName +"����");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JSONObject json = new JSONObject();
		json.put("tip",tip);
		this.response(json);
		return SUCCESS;
	}
	/**
	 * 
	 * Todo��������֤
	 * @author Evan
	 * Date��2014-4-2
	 * @return
	 * @throws Exception
	 */
	public String valMail() throws Exception {
		try {
			if (userDao.validatemail(mail)) {
				setTip("���䲻����");
			} else {
				setTip("�������");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		JSONObject json = new JSONObject();
		json.put("tip",tip);
		this.response(json);
		return SUCCESS;
	}
	/**
	 * 
	 * Todo������֤�����֤
	 * @author Evan
	 * Date��2014-3-30
	 * @return
	 * @throws Exception
	 */
	public String validateCode() throws Exception{
		String sessionCode = (String) ActionContext.getContext().getSession().get("sessionCode");
		System.out.println("sessionCode = " + sessionCode);
		System.out.println("code = " + getCode());
		if(sessionCode.equals(this.getCode())){
			this.setTip("��֤����ȷ");
		}else {
			this.setTip("��֤�����");
		}
		JSONObject json = new JSONObject();
		json.put("tip", tip);
		this.response(json);
		return SUCCESS;
	}
	
    
	
	private void response(Object message){
		try {	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(message);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
