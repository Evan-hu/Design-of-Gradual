package com.designofgradual.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "item", catalog = "dofg")
public class Item implements java.io.Serializable {

	// Fields

	private Integer itemid;
	private String itemname;
	private String itemchart;
	private Set<Post> posts = new HashSet<Post>(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(Integer itemid, String itemname) {
		this.itemid = itemid;
		this.itemname = itemname;
	}

	/** full constructor */
	public Item(Integer itemid, String itemname, String itemchart,
			Set<Post> posts) {
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemchart = itemchart;
		this.posts = posts;
	}

	// Property accessors
	@Id
	@Column(name = "itemid", unique = true, nullable = false)
	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
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

}