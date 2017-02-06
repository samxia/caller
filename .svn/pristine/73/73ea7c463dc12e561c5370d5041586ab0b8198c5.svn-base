package com.xym;

import java.util.List;
import java.util.prefs.Preferences;

public class Regedit {
	Preferences pre = Preferences.systemRoot().node("/caller");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Regedit r = new Regedit();
		System.out.println(r.isReceiveBroadCast());
	}

	public void setSendBroadCast(boolean b) {
		this.write("sendBroadCast", b ? "1" : "0");
	}

	public void setReceiveBroadCast(boolean b) {
		this.write("receiveBroadCast", b ? "1" : "0");
	}

	public boolean isSendBroadCast() {
		String str = this.read("sendBroadCast");
		if (str == null || str.trim().isEmpty()) {
			this.setSendBroadCast(true);
			return true;
		}
		return (str.equals("1")) ? true : false;
	}

	public boolean isReceiveBroadCast() {
		String str = this.read("receiveBroadCast");
		if (str == null || str.trim().isEmpty()) {
			this.setReceiveBroadCast(true);
			return true;
		}
		return (str.equals("1")) ? true : false;
	}

	public String getRecordFilePath() {
		return this.read("recordPath");
	}

	public void setRecordFilePath(String path) {
		this.write("recordPath", path);
	}

	public String getPhoneNoBySerialPort(String port) {
		return this.read(port);
	}

	public void setPhoneNoAndSerialPort(String port, String no) {
		this.write(port, no);
	}

	public String[] getAutoStartSerialPorts() {
		// return this.read("autoStartSerialPort");
		String ports = this.read("autoStartSerialPort");
		if (ports.trim().isEmpty())
			return null;
		return ports.split(",");
	}

	public boolean isAutoStartPort(String port) {
		String[] ports = this.getAutoStartSerialPorts();
		if (ports == null)
			return false;
		for (int i = 0; i < ports.length; i++) {
			if (ports[i].trim().equals(port)) {
				return true;
			}
		}
		return false;
	}

	public void setAutoStartSerialPort(String port) {
		// if has existed this port,just return.
		if (this.isAutoStartPort(port)) {
			return;
		}
		String port_ori = this.read("autoStartSerialPort");
		if (port_ori.trim().isEmpty()) {
			port_ori = port;
		} else {
			port_ori = port_ori + "," + port;
		}
		this.write("autoStartSerialPort", port_ori);
	}

	public void removeAutoStartSerialPort(String port) {
		String[] ports = this.getAutoStartSerialPorts();
		StringBuffer sb = new StringBuffer();
		if (!this.isAutoStartPort(port))
			return;

		// clear
		this.write("autoStartSerialPort", "");
		// and write again one by one
		for (int i = 0; i < ports.length; i++) {
			if (!port.equals(ports[i].trim())) {
				this.setAutoStartSerialPort(ports[i]);
			}
		}
	}

	public void write(String key, String value) {

		pre.put(key.toLowerCase(), value);
	}

	public String read(String key) {
		return pre.get(key.toLowerCase(), "");
	}
}
