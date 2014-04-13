package com.designofgradual.action;

import java.io.ByteArrayInputStream;

import com.designofgradual.util.BaseAction;
import com.designofgradual.util.RandomNum;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class RandomAction extends BaseAction{
	
	private ByteArrayInputStream inputStream;      
	
	/**
	 * 
	 * Todo：产生验证码
	 * @author Evan
	 * Date：2014-4-8
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{      
		RandomNum rdnu=RandomNum.Instance();      
		this.setInputStream(rdnu.getImage());   
		//ActionContext.getContext().getSession().put("sessionCode", rdnu.getString());//
		this.getSession().put("sessionCode", rdnu.getString());
		return SUCCESS;      
	} 
	
	public void setInputStream(ByteArrayInputStream inputStream) {      
		this.inputStream = inputStream;      
	} 
	
	public ByteArrayInputStream getInputStream() {      
		return inputStream;      
	} 
}
