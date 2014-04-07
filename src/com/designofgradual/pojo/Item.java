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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "item", catalog = "dofg_1")
public class Item implements java.io.Serializable {

	// Fields

	private Integer itemid;
	private String itemname;
	private String itemchart;
	private Set<Replay> replaies = new HashSet<Replay>(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String itemname) {
		this.itemname = itemname;
	}

	/** full constructor */
	public Item(String itemname, String itemchart, Set<Replay> replaies) {
		this.itemname = itemname;
		this.itemchart = itemchart;
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
	public Set<Replay> getReplaies() {
		return this.replaies;
	}

	public void setReplaies(Set<Replay> replaies) {
		this.replaies = replaies;
	}

}