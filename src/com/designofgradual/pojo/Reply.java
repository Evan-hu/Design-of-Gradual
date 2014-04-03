package com.designofgradual.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "reply", catalog = "dofg")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer replypostid;
	private User user;
	private Post post;
	private String replycontent;
	private Date replytime;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Integer replypostid) {
		this.replypostid = replypostid;
	}

	/** full constructor */
	public Reply(Integer replypostid, User user, Post post,
			String replycontent, Date replytime) {
		this.replypostid = replypostid;
		this.user = user;
		this.post = post;
		this.replycontent = replycontent;
		this.replytime = replytime;
	}

	// Property accessors
	@Id
	@Column(name = "replypostid", unique = true, nullable = false)
	public Integer getReplypostid() {
		return this.replypostid;
	}

	public void setReplypostid(Integer replypostid) {
		this.replypostid = replypostid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replyer")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replyto")
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Column(name = "replycontent", length = 120)
	public String getReplycontent() {
		return this.replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "replytime", length = 10)
	public Date getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

}