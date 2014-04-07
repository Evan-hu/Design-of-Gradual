package com.designofgradual.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.designofgradual.dao.ItemDao;
import com.designofgradual.pojo.Item;
import com.designofgradual.util.BaseDaoImpl;

@Component("ItemDao")
public class ItemDaoImpl extends BaseDaoImpl implements ItemDao{

	public String createItem(Item item) {
		// TODO Auto-generated method stub
		return null;
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

	public List<String> retrieveItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrieveItem_name() {
		// TODO Auto-generated method stub
		return null;
	}

	public String createItem(Item item, String owner) {
		// TODO Auto-generated method stub
		return null;
	}

}
