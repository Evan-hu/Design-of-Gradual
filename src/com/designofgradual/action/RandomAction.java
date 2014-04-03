package com.designofgradual.action;

import java.io.ByteArrayInputStream;

import com.designofgradual.util.BaseAction;
import com.designofgradual.util.RandomNum;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class RandomAction extends BaseAction{
	
	private ByteArrayInputStream inputStream;      
	
	public String execute() throws Exception{      
		RandomNum rdnu=RandomNum.Instance();      
		this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片      
		//ActionContext.getContext().getSession().put("sessionCode", rdnu.getString());//取得随机字符串放入HttpSession      
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
