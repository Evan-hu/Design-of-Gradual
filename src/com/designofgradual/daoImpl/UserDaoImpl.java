package com.designofgradual.daoImpl;


import org.springframework.stereotype.Component;

import com.designofgradual.dao.UserDao;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseDaoImpl;

@Component("userDAO")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	/**
	 * 
	 * Todo£ºlogin
	 * @author Evan
	 * Date£º2014-3-10
	 * @param username
	 * @param userpasswd
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.UserDao#queryUser(java.lang.String, java.lang.String)
	 */
	public User queryUser(String username, String userpasswd) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" Dao fro");
		String queryString = "from User user where user.username='"+username+ "'" + " and user.userpasswd='"+userpasswd+"'"; 
		try {
			User user = (User)getHibernateTemplate().find(queryString).get(0);
			this.getHibernateTemplate().saveOrUpdate(user);
			return (User)getHibernateTemplate().find(queryString).get(0);
		} catch (Exception e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 
	 * Todo£ºregister
	 * @author Evan
	 * Date£º2014-3-10
	 * @param user
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.UserDao#addUser(com.designofgradual.pojo.User)
	 */
	public int addUser(User user) throws Exception {
		int num;
		try {
			num = (Integer) getHibernateTemplate().save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		return (num+1);
	}
	
	/**
	 * 
	 * Todo£ºValidate user name 
	 * @author Evan
	 * Date£º2014-3-10
	 * @param username
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.UserDao#validateName(java.lang.String)
	 */
	public boolean validateName(String username) throws Exception {
		try {
			String queryString = "from User where userName = '"+username+"'";
			User user = (User)getHibernateTemplate().find(queryString).get(0);
			if(!(user.getUsername()).equals(null)){
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	/**
	 * 
	 * Todo£ºCheck e-mail
	 * @author Evan
	 * Date£º2014-4-2
	 * @param mail
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.UserDao#validatemail(java.lang.String)
	 */
	public boolean validatemail(String mail) throws Exception {
		try {
			String queryString = "from User where useremail = '"+mail+"'";
			User user = (User)getHibernateTemplate().find(queryString).get(0);
			if(!(user.getUseremail()).equals(null)){
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	
	public User findUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * Todo£ºUpdata User info
	 * @author Evan
	 * Date£º2014-3-10
	 * @param user
	 * @param userId
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.UserDao#updateUserInfo(com.designofgradual.pojo.User, int)
	 */
	public boolean updateUserInfo(User user, int userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
