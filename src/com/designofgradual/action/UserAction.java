package com.designofgradual.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.designofgradual.dao.UserDao;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseAction;


@SuppressWarnings("serial")
@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction{

	private User user;
	private String username;
	private String userpasswd;
	private String email;
	private UserDao userDao;

	/**
	 * 
	 * Todo：Register
	 * @author Evan
	 * Date：2014-3-9
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception
	{
		userpasswd = EncoderPwdByMd5(userpasswd);//MD5 加密
		System.out.println("userpasswd = " + userpasswd);
		user = new User();
		user.setUsername(username);
		user.setUserpasswd(userpasswd);
		user.setUseremail(email);
		user.setUserright("3");//默认设置为普通用户
//		user.setImg("");//默认设置用户头像
		
		if(userDao.addUser(user) <= 0){
			return "register_index";
		}else{
			this.getSession().put("cur_user", this.username);
			return "user_info";
		}
	}
	
	/**
	 * 
	 * Todo：TODO
	 * @author Evan
	 * Date：2014-3-9
	 * @return
	 * @throws Exception
	 */
	public String UserInfo() throws Exception{
	
		return SUCCESS;
	}
	
	// get and set method;
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
