package caller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.comm.CommPortIdentifier;

public class PortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PortTest().getSerialPorts();

	}
	public List<String> getSerialPorts() {
		Enumeration portList = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier portId;
		List<String> list = new ArrayList<String>();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			System.out.println(portId.getName()+"-"+portId.getPortType());
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				list.add(portId.getName());
				/*
				 * if (portId.getName().equals("COM1")) { // if
				 * (portId.getName().equals("/dev/term/a")) { }
				 */

			}
		}
		return list;
}}
