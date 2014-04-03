package com.designofgradual.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "post", catalog = "dofg")
public class Post implements java.io.Serializable {

	// Fields

	private Integer postid;
	private User user;
	private Item item;
	private Integer replynum;
	private String headline;
	private String content;
	private Date posttime;
	private Integer clicknum;
	private String postname;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** minimal constructor */
	public Post(Integer postid, User user, Item item, String headline,
			String content, Date posttime) {
		this.postid = postid;
		this.user = user;
		this.item = item;
		this.headline = headline;
		this.content = content;
		this.posttime = posttime;
	}

	/** full constructor */
	public Post(Integer postid, User user, Item item, Integer replynum,
			String headline, String content, Date posttime, Integer clicknum,
			String postname, Set<Reply> replies) {
		this.postid = postid;
		this.user = user;
		this.item = item;
		this.replynum = replynum;
		this.headline = headline;
		this.content = content;
		this.posttime = posttime;
		this.clicknum = clicknum;
		this.postname = postname;
		this.replies = replies;
	}

	// Property accessors
	@Id
	@Column(name = "postid", unique = true, nullable = false)
	public Integer getPostid() {
		return this.postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writer", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item", nullable = false)
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "replynum")
	public Integer getReplynum() {
		return this.replynum;
	}

	public void setReplynum(Integer replynum) {
		this.replynum = replynum;
	}

	@Column(name = "headline", nullable = false, length = 60)
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "posttime", nullable = false, length = 10)
	public Date getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	@Column(name = "clicknum")
	public Integer getClicknum() {
		return this.clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	@Column(name = "postname", length = 30)
	public String getPostname() {
		return this.postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}