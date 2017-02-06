package com.xym;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(new URL( ClassLoader.getSystemResource(""),"resources/Animated-More/01.gif"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean existFile(String file) {
		return new File(file).exists();
	}

	public static boolean checkFilePathValidity(String filePath) {
		File file = new File(filePath);
		if (!file.exists())
			return true;
		if (file.isDirectory())
			return false;
		if (file.isFile()) {
			return true;
		}

		return false;
	}

	public static String readFileByLines(String fileName) {

		StringBuffer sb = new StringBuffer();

		BufferedReader reader = null;
		try {
			FileInputStream fInputStream = new FileInputStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(
					fInputStream, FileUtil.getCodeString(fileName));
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				sb.append(tempString).append("\n");

				// System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 判断文件的编码格式
	 * 
	 * @param fileName
	 *            :file
	 * @return 文件编码格式
	 * @throws Exception
	 */
	public static String getCodeString(String fileName) {
		BufferedInputStream bin = null;
		int p = 0;
		try {
			bin = new BufferedInputStream(new FileInputStream(fileName));
			p = (bin.read() << 8) + bin.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code = null;

		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}

		return code;
	}
}
