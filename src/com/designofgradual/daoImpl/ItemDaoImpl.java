package com.designofgradual.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.designofgradual.dao.ItemDao;
import com.designofgradual.pojo.Item;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseDaoImpl;

@Component("ItemDao")
public class ItemDaoImpl extends BaseDaoImpl implements ItemDao {

	private String sql;
	@SuppressWarnings({ "unused", "rawtypes" })
	private List list;

	@SuppressWarnings("unchecked")
	public List<String> retrieveItem() {
		sql = "select item.itemname,item.user.username from Item item";
		try {
			return this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String createItem(Item item, String owner) {
		System.out.println("------Are you Ok !-------");
		sql = "from User where username='" + owner + "'";
		User user = null;
		try {
			user = (User) getHibernateTemplate().find(sql).get(0);
			if (user != null) {
				item.setUser(user);
				System.out.println("---------" + user.getUsername()
						+ "----------");
				item.setItemchart("0");
				this.getHibernateTemplate().save(item);
				list = this.retrieveItem();
			} else {
				return "error";
			}
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return "success";
	}

	public boolean deleteItem(String itemname) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updataItem(String itemname) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updataItemMore(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Item retrieveItemMore(String itemname) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<String> retrieveItem_name() {
		sql = "select item.itemid,item.itemname from Item item";
		try {
			return this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
