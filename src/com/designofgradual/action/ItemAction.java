package com.designofgradual.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.designofgradual.dao.ItemDao;
import com.designofgradual.util.BaseAction;

@SuppressWarnings("serial")
@Component("itemAction")
@Scope("prototype")
public class ItemAction extends BaseAction {

	private ItemDao itemDao;

	public String execute() throws Exception {
		return super.execute();
	}

	// 返回item 序列
	public String retrieveItem_name() {
		try {
			this.getSession().put("itemNames", this.itemDao.retrieveItem_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "item_name";
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	@Resource
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
