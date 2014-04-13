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

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "dofg_1")
public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String userpasswd;
	private String useremail;
	private String userright;
	private String sysmesg;
	private String name;
	private String sex;
	private String brithday;
	private String tel;
	private String img;
	private String address;
	private Set<Item> items = new HashSet<Item>(0);
	private Set<Replay> replaies = new HashSet<Replay>(0);
	private Set<Post> posts = new HashSet<Post>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String userpasswd, String useremail) {
		this.username = username;
		this.userpasswd = userpasswd;
		this.useremail = useremail;
	}

	/** full constructor */
	public User(String username, String userpasswd, String useremail,
			String userright, String sysmesg, String name, String sex,
			String brithday, String tel, String img, String address,
			Set<Item> items, Set<Replay> replaies, Set<Post> posts) {
		this.username = username;
		this.userpasswd = userpasswd;
		this.useremail = useremail;
		this.userright = userright;
		this.sysmesg = sysmesg;
		this.name = name;
		this.sex = sex;
		this.brithday = brithday;
		this.tel = tel;
		this.img = img;
		this.address = address;
		this.items = items;
		this.replaies = replaies;
		this.posts = posts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username", nullable = false, length = 8)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "userpasswd", nullable = false)
	public String getUserpasswd() {
		return this.userpasswd;
	}

	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}

	@Column(name = "useremail", nullable = false)
	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Column(name = "userright", length = 8)
	public String getUserright() {
		return this.userright;
	}

	public void setUserright(String userright) {
		this.userright = userright;
	}

	@Column(name = "sysmesg", length = 65535)
	public String getSysmesg() {
		return this.sysmesg;
	}

	public void setSysmesg(String sysmesg) {
		this.sysmesg = sysmesg;
	}

	@Column(name = "name", length = 31)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 5)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "brithday", length = 31)
	public String getBrithday() {
		return this.brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	@Column(name = "tel", length = 15)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "img", length = 31)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "address", length = 31)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Replay> getReplaies() {
		return this.replaies;
	}

	public void setReplaies(Set<Replay> replaies) {
		this.replaies = replaies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}