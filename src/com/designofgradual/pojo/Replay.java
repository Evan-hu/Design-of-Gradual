package com.designofgradual.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Replay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "replay", catalog = "dofg_1")
public class Replay implements java.io.Serializable {

	// Fields

	private Integer replayid;
	private User user;
	private Post post;
	private Item item;
	private String rcontent;
	private String rtime;

	// Constructors

	/** default constructor */
	public Replay() {
	}

	/** full constructor */
	public Replay(User user, Post post, Item item, String rcontent, String rtime) {
		this.user = user;
		this.post = post;
		this.item = item;
		this.rcontent = rcontent;
		this.rtime = rtime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "replayid", unique = true, nullable = false)
	public Integer getReplayid() {
		return this.replayid;
	}

	public void setReplayid(Integer replayid) {
		this.replayid = replayid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replaier", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replayto", nullable = false)
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemto", nullable = false)
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "rcontent", nullable = false, length = 65535)
	public String getRcontent() {
		return this.rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	@Column(name = "rtime", nullable = false, length = 31)
	public String getRtime() {
		return this.rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

}