package com.xym;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.comm.*;

public class SimpleRead implements Runnable, SerialPortEventListener {
	static CommPortIdentifier portId;
	static Enumeration portList;

	InputStream inputStream;
	SerialPort serialPort;
	Thread readThread;
	BufferedWriter bufferedWriter;

	public static void main(String[] args) {

		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portId.getName().equals("COM3")) {
					// if (portId.getName().equals("/dev/term/a")) {
					SimpleRead reader = new SimpleRead();
				}
			}
		}
	}

	public SimpleRead() {
		try {
			serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
		} catch (PortInUseException e) {
			e.printStackTrace();
		}
		try {
			inputStream = serialPort.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			serialPort.addEventListener(this);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
		serialPort.notifyOnDataAvailable(true);
		try {
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		}

		// 打开来电显示功能
		try {
			serialPort.getOutputStream().write("AT+VCID=1".getBytes());
			serialPort.getOutputStream().write(13);// 回车
			System.out.println("Write:AT+VCID=1");

		} catch (IOException e) {
			e.printStackTrace();
		}

		readThread = new Thread(this);
		readThread.start();
	}

	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[50];

			try {
				while (inputStream.available() > 0) {
					int numBytes = inputStream.read(readBuffer);
				}
				// System.out.print(new String(readBuffer));
				handleCallerNo(new String(readBuffer));
			} catch (IOException e) {
			}
			break;
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 */
	private String handleCallerNo(String str) throws IOException {
		String date, time, no;
		if (str == null || str.trim().isEmpty())
			return null;
		/*
		 * DATE = 0727 TIME = 1744 NMBR = 13578899365
		 */
		if (str.contains("NMBR")) {
			date = str.subSequence(str.indexOf("DATE") + 7,
					str.indexOf("DATE") + 11).toString();
			time = str.subSequence(str.indexOf("TIME") + 7,
					str.indexOf("TIME") + 11).toString();
			no = str.subSequence(str.indexOf("NMBR") + 7, str.length())
					.toString().trim();
			System.out.println(date + "," + time + "," + no);

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
					"g:\\callerLog.csv", true));
			bufferedWriter.write(date + "," + time + "," + no);
			bufferedWriter.newLine();

			new TranslucentFrame().showMsgOnRightCorner("来电", "<h1>" + no
					+ "</h1>");

			bufferedWriter.close();
		}

		return null;
	}
}
