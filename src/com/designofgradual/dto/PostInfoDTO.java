package com.designofgradual.dto;

public class PostInfoDTO {
	
	private String headline;
	private String replynum;
	private String posttime;
	private String flag;
	private String postid;
	
	//数据传输层
	public PostInfoDTO(String headline, String replynum, String posttime,
			String flag, String postid) {
		this.headline = headline;
		this.replynum = replynum;
		this.posttime = posttime;
		this.flag = flag;
		this.postid = postid;
	}

	public PostInfoDTO(){	}
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getReplynum() {
		return replynum;
	}
	public void setReplynum(String replynum) {
		this.replynum = replynum;
	}
	public String getPosttime() {
		return posttime;
	}
	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
}
