package com.designofgradual.dao;

import java.util.List;

import com.designofgradual.pojo.Post;

public interface PostDao {
	//添加Post
	public int addpost( Post post) throws Exception;
	//查看所有的Post
	public List<String> viewAllPost(int postid,int pageindex, int pagesize) throws Exception;
	//根据用户的id查询Post
	public Post viewPostById(int userId) throws Exception;
	//分页
	public List<String> retrievePost_verify(int pageindex, int pagenum) throws Exception; 
	
	public String retrieve_postsize(int userId);
	
	public String retrieve_postsize();
	
	public boolean updateflag(int postid, int flag) throws Exception;
	
	public List<String> viewByflag(int pageindex,int pagesize) throws Exception;

	public List<String> index_viewByflag(int pageindex,int pagesize, String itemname) throws Exception;

	public String managementpost() throws Exception;
	
	public List<String> managementallpost(int pageindex,int pagesize) throws Exception;
	
	public String create_post_nick(String postid,String nickname);
	
	public String delete_post(String postid);

	public List<String> retrieve_post_left(int pageindex,int pagesize);
	
	public List<String> create_user_item(int postid) throws Exception;
	
	public List<String> retrieve_item_post(int pageindex,int pagesize,int itemid);
	
	public List<String> retrieve_item_postSize(int itemid);

	
	public List<String> retrievePostByclick();

	public List<String> retrievePostByreply();
}
