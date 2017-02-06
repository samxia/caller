package com.xym.broadcast;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow; 

import com.xym.Regedit;

public class JFrameBroadCast extends JFrame implements ActionListener {
	static BroadCastReceive broadCastReceive = null;
	Thread thread_receive=null;
	JCheckBox checkBox_send;
	JCheckBox checkBox_receive;

	public void startReceiveBroadCast() {
		if (broadCastReceive != null)
			return;

		if (new Regedit().isReceiveBroadCast()) {
			broadCastReceive = new BroadCastReceive();
			thread_receive=new Thread(broadCastReceive);
			thread_receive.start();
		}

	}

	public void stopReceiveBroadCast() {
		if (broadCastReceive != null && thread_receive!=null) {
			thread_receive.interrupt();
			broadCastReceive.exit = true;
			broadCastReceive = null;
			
		}

	}

	public void paint() {
		Container container = this.getContentPane();

		JPanel panel = new JPanel();
		checkBox_send = new JCheckBox("以广播形式发送来电显示内容");
		checkBox_send.addActionListener(this);
		checkBox_send.setActionCommand("send");
		checkBox_send.setSelected(new Regedit().isSendBroadCast());

		checkBox_receive = new JCheckBox("允许接收显示来电内容的广播");
		checkBox_receive.addActionListener(this);
		checkBox_receive.setActionCommand("receive");
		checkBox_receive.setSelected(new Regedit().isReceiveBroadCast());

		panel.add(checkBox_send);
		panel.add(checkBox_receive);

		container.add(panel);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setTitle("广播设置");
		this.setSize(300, 100);
		this.setAlwaysOnTop(true);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "send":
			new Regedit().setSendBroadCast(checkBox_send.isSelected());
			break;
		case "receive":
			new Regedit().setReceiveBroadCast(this.checkBox_receive
					.isSelected());
			if (checkBox_receive.isSelected()) {
				// if no start, then start receive
				if (this.broadCastReceive == null) {
					this.startReceiveBroadCast();
				}
			} else {
				this.stopReceiveBroadCast();
			}
			break;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JFrameBroadCast().paint();

	}
}
