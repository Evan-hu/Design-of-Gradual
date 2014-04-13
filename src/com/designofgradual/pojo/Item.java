package com.designofgradual.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "item", catalog = "dofg_1")
public class Item implements java.io.Serializable {

	// Fields

	private Integer itemid;
	private User user;
	private String itemname;
	private String itemchart;
	private Set<Post> posts = new HashSet<Post>(0);
	private Set<Replay> replaies = new HashSet<Replay>(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(User user, String itemname) {
		this.user = user;
		this.itemname = itemname;
	}

	/** full constructor */
	public Item(User user, String itemname, String itemchart, Set<Post> posts,
			Set<Replay> replaies) {
		this.user = user;
		this.itemname = itemname;
		this.itemchart = itemchart;
		this.posts = posts;
		this.replaies = replaies;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "itemid", unique = true, nullable = false)
	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemuser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "itemname", nullable = false)
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "itemchart")
	public String getItemchart() {
		return this.itemchart;
	}

	public void setItemchart(String itemchart) {
		this.itemchart = itemchart;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
	public Set<Replay> getReplaies() {
		return this.replaies;
	}

	public void setReplaies(Set<Replay> replaies) {
		this.replaies = replaies;
	}

}