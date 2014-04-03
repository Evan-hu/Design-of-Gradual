package com.designofgradual.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.designofgradual.dao.UserDao;
import com.designofgradual.pojo.User;
import com.designofgradual.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	/**
	 * 
	 * Todo£ºLogin
	 * @author Evan
	 * Date£º2014-3-10
	 * @param username
	 * @param userpasswd
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.service.UserService#squeryUser(java.lang.String, java.lang.String)
	 */
	public User squeryUser(String username, String userpasswd) throws Exception {
		System.out.println(" service fro");
		User user = this.userDao.queryUser(username, userpasswd);
		System.out.println(" service beh");
		return user;
	}
	
	/**
	 * 
	 * Todo£ºRegister
	 * @author Evan
	 * Date£º2014-3-10
	 * @param user
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.service.UserService#saddUser(com.designofgradual.pojo.User)
	 */
	public int saddUser(User user) throws Exception {
		System.out.println(" service fro");
		int i;
		try {
			i = this.userDao.addUser(user);
			if(i <= 0){
				System.out.println(" service fro");
				return i;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}

	public boolean svalidateName(String username) throws Exception {
		try {
			if(userDao.validateName(username)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public User sfindUserByName(String userName) throws Exception {
		
		return null;
	}

	public boolean supdateUserInfo(User user, int userId) throws Exception {
		
		return false;
	}
	
	//get and set method;
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
