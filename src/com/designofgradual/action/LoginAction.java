package com.designofgradual.action;

import javax.annotation.Resource;

import com.designofgradual.dao.UserDao;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseAction;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{

	private User user;
	private String code;
	private String username;
	private String userpasswd;
	private UserDao userDao;

	/**
	 * 
	 * Todo：登陆
	 * @author Evan
	 * Date：2014-4-4
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		//密码加密，调用BaseAction中方法
		userpasswd = EncoderPwdByMd5(userpasswd);
			try{
				user = this.userDao.queryUser(username, userpasswd);
				if(user.equals(null)){
					this.getRequest().put("userinfo", "false");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				this.getRequest().put("login_info", "false");
				return "exception";
			}
			if(user.getUserright().equals("1")) {
				//系统管理员				
				this.getSession().put("cur_user", this.user.getUsername());
				return "backindex";
			}else if(user.getUserright().equals("2")) {
				//版主			
				this.getSession().put("cur_user", this.user.getUsername());
				return "user_plate";
			}else if(user.getUserright().equals("3")) {
				//普通用户	
				this.getSession().put("cur_user", this.user.getUsername());
				return "user_info";
			}else {
				//有错误时返回
				return "error";
			}
	}
	
	
	
    //getter and stter	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}