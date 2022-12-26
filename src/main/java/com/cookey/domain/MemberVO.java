package com.cookey.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private Date regdate;
	private int chkadm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getChkadm() {
		return chkadm;
	}
	public void setChkadm(int chkadm) {
		this.chkadm = chkadm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getchkadm() {
		return chkadm;
	}
	public void setchkadm(int chkadm) {
		this.chkadm = chkadm;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", regdate=" + regdate + ", chkadm=" + chkadm
				+ "]";
	}
	


}
