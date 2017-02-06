package com.xym;

import java.io.IOException;
import java.util.List;

public interface CallerServiceInterface {

	public abstract String checkSerialPortAvaliable(String comPort);

	public abstract List<String> getSerialPorts();

	public abstract void run();

	public void recordLog(String str) throws IOException;
}