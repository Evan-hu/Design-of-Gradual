package com.designofgradual.service;

import com.designofgradual.pojo.User;

public interface UserService {
	
	/**
	 * 
	 * @param username
	 * @param userpasswd
	 * @return
	 * @throws Exception
	 */
	public User squeryUser(String username, String userpasswd) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int saddUser(User user) throws Exception;
	
	/**
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean svalidateName(String username) throws Exception;
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User sfindUserByName(String userName) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean supdateUserInfo(User user,int userId) throws Exception;

}
