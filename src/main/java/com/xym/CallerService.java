package com.xym;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

public class CallerService implements Runnable, CallerServiceInterface {
	static Logger log = Logger.getLogger(CallerService.class);

	InputStream inputStream;
	String localNo;
	String recordPath = null;
	String lastRecord;
	CallerServiceInterface service=null;
	/**
	 * @param args
	 * @throws IOException
	 * @throws NoSuchPortException
	 */
	public static void main(String[] args) throws IOException {
		CallerServiceInterface cs = new CallerService();
		String msg = "86109613 来电:<h1>" + "898989899" + "</h1>" + "林业局";
		//cs.sendBroadCast(msg);

	}

	public CallerService() {
		service=new CallerService_rxtx();
	}

	public CallerService(String port, String localNo, String recordPath) {
		service=new CallerService_rxtx(port,localNo,recordPath);
		
	}

//called
	public String checkSerialPortAvaliable(String comPort) {
		return service.checkSerialPortAvaliable(comPort);
	}
//called
	public List<String> getSerialPorts() {
		return service.getSerialPorts();

	}
	@Override
	public void recordLog(String str) throws IOException {
		service.recordLog(str);
		
	}
	@Override
	public void run() {
		service.run();
	}

	
}
