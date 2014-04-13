package com.designofgradual.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.designofgradual.dao.ItemDao;
import com.designofgradual.dao.PostDao;
import com.designofgradual.dto.PostInfoDTO;
import com.designofgradual.pojo.Item;
import com.designofgradual.pojo.Post;
import com.designofgradual.pojo.User;
import com.designofgradual.util.BaseAction;

@SuppressWarnings("serial")
@Component("postAction")
@Scope("prototype")
public class PostAction extends BaseAction{
	//属性
	private String posttitle;
	private String postcontent;
	private String itemname;
	private String userId;
	private String userName;
	private int postid;
	private List<String> postlist;
	private List<String> itemist;
	//实体类
	private Post post;
	private User user;
	private Item item;
	//DAO
	private PostDao postdao;
	private ItemDao itemdao;
	
//	分页需要用的
	private int pagesize;
	private int pageindex;
	private int flag;
	private String secondLine;
	private String itemid;
	private String pageindex_item;

	/**
	 * 
	 * Todo：发表帖子
	 * 
	 * @author Evan Date：2014-4-10
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
			int index = 1, i = 0;
			int item_index  = new Integer(itemname);
			Object[] objects = null;
			List list = (List) this.getSession().get("itemNames");
			Iterator iterator = list.iterator();
			while (iterator.hasNext()){
				objects = (Object[]) iterator.next();
				if(item_index == index){
					break;
				}
				index++;
			}
			itemname = objects[1].toString();//获取当前的itemname
			try{
			//設置Post的值
			user = new User();
			user.setUserid(Integer.parseInt(userId));
			item = new Item();
			item.setItemname(this.getItemname());
			post = new Post();
			post.setItem(item);
			post.setPcontent(postcontent);
			post.setPtitle(posttitle);
			post.setUser(user);
			Date date = new Date();
			System.out.println("date = " + date);
			post.setPtime(date);
			post.setPclicknum(0);
			post.setPreplay(0);
			if(postdao.addpost(post) <= 0){
				System.out.println("----------------开始发帖啦----------------");
				 return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;//发帖失败，返回用户界面
		}
		this.getRequest().put("post_list", switchObject(this.postdao.viewAllPost(Integer.parseInt(userId),1,10)));
		this.getRequest().put("psotsize", this.postdao.retrieve_postsize(Integer.parseInt(userId)));
		this.getRequest().put("cur_page", "1");
		return "user_info";
	}

	/**
	 * 
	 * Todo：浏览当前用户的发帖
	 * @author Evan Date：2014-4-10
	 * @return
	 * @throws Exception
	 */
	public String viewPost() throws Exception {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List switchObject(List list){	
		
		return null;
	}

	
//	getter and setter method
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public List<String> getPostlist() {
		return postlist;
	}
	public void setPostlist(List<String> postlist) {
		this.postlist = postlist;
	}
	public List<String> getItemist() {
		return itemist;
	}
	public void setItemist(List<String> itemist) {
		this.itemist = itemist;
	}
	public PostDao getPostdao() {
		return postdao;
	}
	@Resource
	public void setPostdao(PostDao postdao) {
		this.postdao = postdao;
	}
	public ItemDao getItemdao() {
		return itemdao;
	}
	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getSecondLine() {
		return secondLine;
	}
	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getPageindex_item() {
		return pageindex_item;
	}
	public void setPageindex_item(String pageindex_item) {
		this.pageindex_item = pageindex_item;
	}
}
