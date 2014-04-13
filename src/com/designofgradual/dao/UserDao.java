package com.designofgradual.dao;

import com.designofgradual.pojo.User;

public interface UserDao {
	/**
	 * 
	 * @param username
	 * @param userpasswd
	 * @return
	 * @throws Exception
	 */
	public User queryUser(String username, String userpasswd) throws Exception;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception;
	/**
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean validateName(String username) throws Exception;
	/**
	 * 
	 * Todo：TODO
	 * @author Evan
	 * Date��2014-4-2
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public boolean validatemail(String mail) throws Exception;
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User findUserByName(String userName) throws Exception;
	/**
	 * 
	  * updateUserInfo  
	  * 
	  * @param user
	  * @return
	  * @throws Exception 
	  * @return boolean 
	  * @author Evan 
	 */
	public boolean updateUserInfo(User user,int userId) throws Exception;
}
