package com.SBQA.domain;

import java.util.Date;

public class SBQAVO {
	
/*
 * CREATE TABLE tbl_log(
bno INT NOT NULL AUTO_INCREMENT,
conversation_id VARCHAR(35) NOT NULL,
message_id VARCHAR(50) NOT NULL,
issue_id VARCHAR(24) NOT NULL,
regDate TIMESTAMP NOT NULL DEFAULT NOW(),
original_xml BLOB,
PRIMARY KEY(bno)SBQASBQASBQASBQAtbl_log
);
*/
	
	private int bno;
	private String conversation_id;
	private String message_id;
	private String issue_id;
	private Date regDate;
	private String original_xml;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getConversation_id() {
		return conversation_id;
	}
	public void setConversation_id(String conversation_id) {
		this.conversation_id = conversation_id;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getOriginal_xml() {
		return original_xml;
	}
	public void setOriginal_xml(String original_xml) {
		this.original_xml = original_xml;
	}

}
