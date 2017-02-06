package com.xym;

public class CallerBean {
	private String comPort;
	private String date;
	private String time;
	private String comingPhoneNo;
	private String localPhoneNo;
	private String localPhoneMemo;
	private String status;
	private String comingContactInfo;
	private boolean autoStart;
	private String autoStartPort;
	private boolean active;

	private String recordFilePath;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAutoStart() {
		return autoStart;
	}

	public void setAutoStart(boolean autoStart) {
		this.autoStart = autoStart;
	}

	public String getAutoStartPort() {
		return autoStartPort;
	}

	public void setAutoStartPort(String autoStartPort) {
		this.autoStartPort = autoStartPort;
	}

	public String getRecordFilePath() {
		return recordFilePath;
	}

	public void setRecordFilePath(String recordFilePath) {
		this.recordFilePath = recordFilePath;
	}

	public String getComPort() {
		return comPort;
	}

	public void setComPort(String comPort) {
		this.comPort = comPort;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComingPhoneNo() {
		return comingPhoneNo;
	}

	public void setComingPhoneNo(String comingPhoneNo) {
		this.comingPhoneNo = comingPhoneNo;
	}

	public String getLocalPhoneNo() {
		return localPhoneNo;
	}

	public void setLocalPhoneNo(String localPhoneNo) {
		this.localPhoneNo = localPhoneNo;
	}

	public String getLocalPhoneMemo() {
		return localPhoneMemo;
	}

	public void setLocalPhoneMemo(String localPhoneMemo) {
		this.localPhoneMemo = localPhoneMemo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComingContactInfo() {
		return comingContactInfo;
	}

	public void setComingContactInfo(String comingContactInfo) {
		this.comingContactInfo = comingContactInfo;
	}

}
