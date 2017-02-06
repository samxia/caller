package com.xym.broadcast;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class BroadCastSend extends Thread {
	String message = "coming no:88888";
	int port = 9618;
	InetAddress iaddress;// û����ʼ��������ֻ����������Ϊ��ʼ��new����ʱҪ�׳��쳣�����ڳ�Ա�����������﷨ͨ����ġ�
	MulticastSocket socket;

	// �ڹ��췽���г�ʼ����Ա����
	public BroadCastSend(String msg) {
		this.message = msg;
		try {
			// A multicast group is specified by a class D IP address
			// and by a standard UDP port number.
			// Class D IP addresses are in the range 224.0.0.0 to
			// 239.255.255.255, inclusive.
			// The address 224.0.0.0 is reserved and should not be used.
			iaddress = InetAddress.getByName("233.0.0.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			socket.joinGroup(iaddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	// ��򵥵ķ���Ҳ���ǽ���һ���߳�������
	public void run() {
		byte[] data = message.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, iaddress,
				port);
		// System.out.println(weather);
		System.out.println(new String(data));
		try {
			socket.send(packet);
			//sleep(3000);// �߳�����3��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			socket.close();
		}
	}

	public static void main(String[] args) {
		BroadCastSend bc = new BroadCastSend(new Date() + "coming no:666666");
		bc.start();
	}
}
