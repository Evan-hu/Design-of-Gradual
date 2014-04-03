package com.designofgradual.action;

import javax.annotation.Resource;

import com.designofgradual.dao.UserDao;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseAction;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{

	private User user;
	private String username;
	private String userpasswd;
	private UserDao userDao;

	public String execute() throws Exception{
		//密码加密，调用BaseAction中方法
		userpasswd = EncoderPwdByMd5(userpasswd);
			try{
				user = this.userDao.queryUser(username, userpasswd);
				if(user.equals(null)){
					this.getRequest().put("userinfo", "false");
				}
			}catch (Exception e) {
				//have false return index.jsp
				System.out.println(e.getMessage());
				this.getRequest().put("login_info", "false");
				return "login_index";
			}
			this.getSession().put("cur_user",this.user.getUsername());
			//此处应该加以分级管理
			/**
			    System.out.println("user_point = " + user.getPoint()+ "---" + this.getSession().get("user_point"));
				if(user.getUsertype().equals("管理员")){
				return "backindex"; 
			}
				分为三层：
						系统管理员，版主，一般用户。
			*/
			return "user_info";
	}
	
	
	
    //getter and stter	
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
