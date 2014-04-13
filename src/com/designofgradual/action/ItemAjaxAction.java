package com.designofgradual.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.designofgradual.dao.ItemDao;
import com.designofgradual.pojo.Item;
import com.designofgradual.util.BaseAction;

@SuppressWarnings("serial")
public class ItemAjaxAction extends BaseAction {

	private ItemDao itemDao;
	private JSONObject json;
	private JSONArray jarray;

	@SuppressWarnings("rawtypes")
	private List list;
	private Item item;
	private String itemname;
	private String owner;
	private String result;

	public String execute() throws Exception {

		return super.execute();
	}

	/**
	 * 
	 * Todo：创建 Item
	 * @author Evan
	 * Date：2014-4-8
	 * @return
	 */
	public String createItem() {
		System.out.println("itemname = " + getItemname() + " --|-- "
				+ "owner = " + getOwner());
		if (this.getItemname() != null) {
			item = new Item();
			item.setItemname(itemname);
			try {
				this.itemDao.createItem(item,owner);
				list = this.itemDao.retrieveItem();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			return ERROR;
		}
		jarray = configJson(list);
		result = jarray.toString();
		System.out.println("result = " + result);
		return SUCCESS;
	}
	
	/**
	 * 
	 * Todo：Json Array
	 * @author Evan
	 * Date：2014-4-8
	 * @param list
	 * @return
	 */
	public JSONArray configJson(List list) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[] { "" });
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		return jsonArray;
	}

	// getter and setter method
	public ItemDao getItemDao() {
		return itemDao;
	}

	@Resource
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public JSONArray getJarray() {
		return jarray;
	}

	public void setJarray(JSONArray jarray) {
		this.jarray = jarray;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
