package com.SBQA.domain;

public class ApiVO {
	private String MessageId;
	private String Signal;
	private String RequestTime;
	private String SendComRegno;
	private String AuthCode;
	private String SbId;
	private String ExpirationDateCode;
	private String ExpirationDate;
	
	public String getMessageId() {
		return MessageId;
	}
	public void setMessageId(String messageId) {
		this.MessageId = messageId;
	}
	public String getSignal() {
		return Signal;
	}
	public void setSignal(String signal) {
		this.Signal = signal;
	}
	public String getRequestTime() {
		return RequestTime;
	}
	public void setRequestTime(String requestTime) {
		this.RequestTime = requestTime;
	}
	public String getSendComRegno() {
		return SendComRegno;
	}
	public void setSendComRegno(String sendComRegno) {
		this.SendComRegno = sendComRegno;
	}
	public String getAuthCode() {
		return AuthCode;
	}
	public void setAuthCode(String authCode) {
		this.AuthCode = authCode;
	}
	public String getSbId() {
		return SbId;
	}
	public void setSbId(String sbId) {
		this.SbId = sbId;
	}
	public String getExpirationDateCode() {
		return ExpirationDateCode;
	}
	public void setExpirationDateCode(String expirationDateCode) {
		this.ExpirationDateCode = expirationDateCode;
	}
	public String getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.ExpirationDate = expirationDate;
	}

	
}
