package com.designofgradual.dao;

import java.util.List;

import com.designofgradual.pojo.Item;

public interface ItemDao {
	/**
	 * 
	 * Todo：创建item
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public String createItem(Item item,String owner);
	/**
	 * 
	 * TODO：删除
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean deleteItem(String itemname);
	/**
	 * 
	 * Todo：更新
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItem(String itemname);
	/**
	 * 
	 * Todo：更新more
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItemMore(Item item);
	/**
	 * 
	 * Todo：检索item
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public Item retrieveItemMore(String itemname);
	/**
	 * 
	 * Todo：检索item
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem();
	/**
	 * 
	 * Todo：检索（使用名字）
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem_name();
	
	
}
