package com.designofgradual.dao;

import java.util.List;

import com.designofgradual.pojo.Item;

public interface ItemDao {
	/**
	 * 
	 * Todo���������
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public String createItem(Item item,String owner);
	/**
	 * 
	 * TODO��ɾ�����
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean deleteItem(String itemname);/**
	 * 
	 * Todo�����°����Ϣ
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItem(String itemname);
	/**
	 * 
	 * Todo�����°�飨more��
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public boolean updataItemMore(Item item);
	/**
	 * 
	 * Todo���������
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public Item retrieveItemMore(String itemname);
	/**
	 * 
	 * Todo���������а��
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem();
	/**
	 * 
	 * Todo������
	 * @author Evan
	 * Date��2014-4-7
	 * @param item
	 * @return
	 */
	public List<String> retrieveItem_name();
	
	
}
