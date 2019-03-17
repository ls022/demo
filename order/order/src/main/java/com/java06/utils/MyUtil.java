package com.java06.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.Map.Entry;

/**
 * 常用工具类
 * 
 * @author 瞬间移动
 *
 */
public class MyUtil {

	/**
	 * 生成唯一标识：UUID
	 */
	public static String getJavaUUID() {
		return UUID.randomUUID().toString();
	}

	public static String getFileType(String filename) {
		if (filename.endsWith(".jpg") || filename.endsWith(".jepg")) {
			return ".jpg";
		} else if (filename.endsWith(".png") || filename.endsWith(".PNG")) {
			return ".png";
		} else {
			return "application/octet-stream";
		}
	}

	/**
	 * 获取短信验证码
	 * 
	 * @return
	 */
	public static String getSmsCode() {
		return (int) ((Math.random() * 9 + 1) * 1000) + "";
	}

	/**
	 * Map拼接url
	 * 
	 * @param data
	 * @return
	 */
	public static String toQueryString(Map<?, ?> data) {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			queryString.append(pair.getValue() + "&");
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}

	/**
	 * 特殊字符串转换成int数组
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @param spt
	 *            间隔符
	 * @return
	 */
	public static int[] StringToInt(String str, String spt) {
		String[] strs = str.split(spt);
		int[] is = new int[strs.length];
		for (int i = 0; i < is.length; i++) {
			is[i] = Integer.parseInt(strs[i]);
		}
		return is;
	}

	/**
	 * 获取系统当前时间
	 */
	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 返回系统当前时间的date对象
	 * 
	 * @return
	 */
	public static Date getNowDate() {
		return new Date();
	}

	/**
	 * 将Sting类型转为date类型
	 * 
	 * @param str
	 *            待转换的字符
	 * @param date
	 *            时间类型，如：yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static Date getString(String str, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(date);
		return sdf.parse(str);
	}

	/**
	 * 将date类型转为String类型
	 * 
	 * @param date
	 *            时间
	 * @param type
	 *            格式
	 * @return
	 */
	public static String dateFormat(Date date, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return sdf.format(date);
	}

	/**
	 * 获取当前系统时间String类型
	 * 
	 * @return
	 */
	public static String nowDate() {
		return dateFormat(getNowDate(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getTime() {
		return String.valueOf(new Date().getTime());
	}

	/**
	 * 读取配置文件
	 * 
	 * @param in
	 * @param key
	 * @return
	 */
	public static String getProp(InputStream in, String key) {

		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	// /**
	// * 获取当前登录用户实体
	// * @param request
	// * @return
	// */
	// public static UserModel getUserLogin(HttpServletRequest request){
	// return (UserModel) request.getSession().getAttribute(
	// "userLogin");
	// }

	public static void main(String[] args) {
		InputStream in = Object.class.getResourceAsStream("/db.properties");
		String initPwd = MyUtil.getProp(in, "init.pwd");
		System.out.println(initPwd);
		System.out.println(MyUtil.nowDate());
		System.out.println(getSmsCode());
		System.out.println(getJavaUUID());
		System.out.println(now());
		System.out.println(getTime());
	}
}
