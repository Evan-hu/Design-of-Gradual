package com.designofgradual.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import sun.misc.BASE64Encoder;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	
	@SuppressWarnings("unused")
	private final long serialVersionUID = -5074036324583807017L;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	
	
	//MD5 加密部分
	public String EncoderPwdByMd5(String str) throws NoSuchAlgorithmException, 
	UnsupportedEncodingException { 
		MessageDigest md5 = MessageDigest.getInstance("MD5"); 
		BASE64Encoder base64en = new BASE64Encoder(); 
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8"))); 
		return newstr; 
	}
	
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
		
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
		
	}
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public Map<String, Object> getApplication() {
		return application;
	}
}
