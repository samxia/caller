package com.xym.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xym.CallerService;
import com.xym.TranslucentFrame;

public class BroadCastReceive implements Runnable {

	int port = 9618;
	InetAddress group;
	MulticastSocket socket; // socket sends and receives the packet.
	DatagramPacket packet;
	static boolean exit = false;
	byte[] buf = new byte[1024];// If the message is longer than the packet's
								// length, the message is truncated.

	public BroadCastReceive() {
		try {
			socket = new MulticastSocket(port);
			// A multicast group is specified by a class D IP address
			// and by a standard UDP port number.
			// Class D IP addresses are in the range 224.0.0.0 to
			// 239.255.255.255, inclusive.
			// The address 224.0.0.0 is reserved and should not be used.
			group = InetAddress.getByName("233.0.0.0");
			socket.joinGroup(group);
			packet = new DatagramPacket(buf, buf.length);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				socket.receive(packet);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String remoteIp = packet.getAddress().getHostAddress();
			String localIp = getLocalIp();
			//如果是本地广播，则不显示
			if (!remoteIp.equals(localIp)) {
				// String message=new String(buf);
				String message = new String(packet.getData(), 0,
						packet.getLength());// very important	// !!
				// System.out.println("received:" + message);
				handleReceivedData(message);
			}
			if (exit) {
				break;
			}
		}
	}

	public String getLocalIp() {
		String localIp = null;
		try {
			localIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return localIp;
	}

	public void handleReceivedData(String str) {

		// show right corner window
		new TranslucentFrame().showMsgOnRightCorner("来电", str);

		// record log
		try {
			new CallerService().recordLog(new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:sss").format(new Date()) + ":" + str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BroadCastReceive br = new BroadCastReceive();
		br.run();

	}

}
