package com.designofgradual.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.designofgradual.dao.PostDao;
import com.designofgradual.pojo.Item;
import com.designofgradual.pojo.Post;
import com.designofgradual.util.BaseDaoImpl;
@Component("postDAO")
public class PostDaoImpl extends BaseDaoImpl implements PostDao {

	private String sql;
	private Item item;
	private List list;
	
	/**
	 * 
	 * Todo：存储帖子
	 * @author Evan
	 * Date：2014-4-10
	 * @param post
	 * @return
	 * @throws Exception
	 * @see com.designofgradual.dao.PostDao#addpost(com.designofgradual.pojo.Post)
	 */
	public int addpost(Post post) throws Exception {
		sql = "from Item item where item.itemname = '"+post.getItem().getItemname()+"'";
		System.out.println("sql = "+ sql);
		try {
			item = (Item) this.getHibernateTemplate().find(sql).get(0);
			System.out.println("item = " + item);
			post.setItem(item);
			post.setPstate("0");
			try {
				this.getHibernateTemplate().save(post);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public List<String> viewAllPost(int postid, int pageindex, int pagesize)
			throws Exception {
		return null;
	}

	public Post viewPostById(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrievePost_verify(int pageindex, int pagenum)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieve_postsize(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieve_postsize() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateflag(int postid, int flag) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> viewByflag(int pageindex, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> index_viewByflag(int pageindex, int pagesize,
			String itemname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String managementpost() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> managementallpost(int pageindex, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String create_post_nick(String postid, String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete_post(String postid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrieve_post_left(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> create_user_item(int postid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrieve_item_post(int pageindex, int pagesize,
			int itemid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrieve_item_postSize(int itemid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrievePostByclick() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> retrievePostByreply() {
		// TODO Auto-generated method stub
		return null;
	}

}
