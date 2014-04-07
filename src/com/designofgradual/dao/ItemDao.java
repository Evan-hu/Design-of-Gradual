package com.designofgradual.dao;

import java.util.List;

import com.designofgradual.pojo.Item;

public interface ItemDao {
	/**
	 * 
	 * Todo£º´´½¨°å¿é
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public String createItem(Item item,String owner);
	/**
	 * 
	 * TODO£ºÉ¾³ý°å¿é
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public boolean deleteItem(String itemname);/**
	 * 
	 * Todo£º¸üÐÂ°å¿éÐÅÏ¢
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItem(String itemname);
	/**
	 * 
	 * Todo£º¸üÐÂ°å¿é£¨more£©
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItemMore(Item item);
	/**
	 * 
	 * Todo£º¼ìË÷°å¿é
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public Item retrieveItemMore(String itemname);
	/**
	 * 
	 * Todo£º¼ìË÷ËùÓÐ°å¿é
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem();
	/**
	 * 
	 * Todo£º¼ìË÷
	 * @author Evan
	 * Date£º2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem_name();
	
	
}
