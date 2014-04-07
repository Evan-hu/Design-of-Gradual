package com.designofgradual.pojo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "post", catalog = "dofg_1")
public class Post implements java.io.Serializable {

	// Fields

	private Integer postid;
	private User user;
	private String pitem;
	private String ptitle;
	private String pcontent;
	private Date ptime;
	private String pstate;
	private Integer pclicknum;
	private Integer preplay;
	private Set<Replay> replaies = new HashSet<Replay>(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** minimal constructor */
	public Post(User user, String pitem, String ptitle, String pcontent,
			Date ptime, String pstate) {
		this.user = user;
		this.pitem = pitem;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.ptime = ptime;
		this.pstate = pstate;
	}

	/** full constructor */
	public Post(User user, String pitem, String ptitle, String pcontent,
			Date ptime, String pstate, Integer pclicknum, Integer preplay,
			Set<Replay> replaies) {
		this.user = user;
		this.pitem = pitem;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.ptime = ptime;
		this.pstate = pstate;
		this.pclicknum = pclicknum;
		this.preplay = preplay;
		this.replaies = replaies;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "postid", unique = true, nullable = false)
	public Integer getPostid() {
		return this.postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pwriter", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "pitem", nullable = false, length = 11)
	public String getPitem() {
		return this.pitem;
	}

	public void setPitem(String pitem) {
		this.pitem = pitem;
	}

	@Column(name = "ptitle", nullable = false)
	public String getPtitle() {
		return this.ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	@Column(name = "pcontent", nullable = false, length = 65535)
	public String getPcontent() {
		return this.pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ptime", nullable = false, length = 10)
	public Date getPtime() {
		return this.ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	@Column(name = "pstate", nullable = false, length = 8)
	public String getPstate() {
		return this.pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	@Column(name = "pclicknum")
	public Integer getPclicknum() {
		return this.pclicknum;
	}

	public void setPclicknum(Integer pclicknum) {
		this.pclicknum = pclicknum;
	}

	@Column(name = "preplay")
	public Integer getPreplay() {
		return this.preplay;
	}

	public void setPreplay(Integer preplay) {
		this.preplay = preplay;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Replay> getReplaies() {
		return this.replaies;
	}

	public void setReplaies(Set<Replay> replaies) {
		this.replaies = replaies;
	}

}