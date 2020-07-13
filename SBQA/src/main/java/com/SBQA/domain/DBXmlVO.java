package com.SBQA.domain;

import java.util.Date;

public class DBXmlVO {
	
	private int bno;
	private String xml;
	private Date regDate;
	private String issueId;
	private String arap;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getArap() {
		return arap;
	}
	public void setArap(String arap) {
		this.arap = arap;
	}
	
	

}
