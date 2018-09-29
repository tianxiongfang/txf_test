package com.jd.api.model;

import java.io.Serializable;

public class CodeMQMsgModel implements Serializable {
	private String emailAddr;
	private String code;

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
