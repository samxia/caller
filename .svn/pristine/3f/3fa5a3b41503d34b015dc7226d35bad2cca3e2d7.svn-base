package com.xym.env;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.xym.bossed.ws.client.KehuWebServiceClient;

public class CheckEnvironment {
	static Logger log = Logger.getLogger(CheckEnvironment.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		log.debug(new CheckEnvironment().checkWebService());
		/*
		 * String firstArg = null; if (args.length > 0) { firstArg = args[0];
		 * switch (firstArg) { case "-help": StringBuffer sb=new StringBuffer();
		 * sb.append("选项:").append("\n"); sb.append("	-help 显示帮助").append("\n");
		 * sb.append("	-check 检测运行环境"); System.out.println(sb.toString());
		 * break; case "-check": new CheckEnvironment(); break; } return; }
		 */

	}

	public CheckEnvironment() {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("请选择要测试的项目：\n"); String item = sc.nextLine();
		 * 
		 * System.out.println(item);
		 */
	}

	public boolean checkPorts() {

		return false;
	}

	public boolean checkRightCornerFrame() {

		return false;
	}

	public boolean checkBroadcastSend() {
		return false;
	}

	public boolean checkBroadcastReceive() {
		return false;
	}

	public boolean checkHandleComingCall() {
		return false;
	}

	public String checkWebService() {
		return new KehuWebServiceClient().getKehuNameByKehuTelNo("13578899365");
	}

}
