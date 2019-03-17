package server;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Util {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/**
	 * ��ȡһ�����������ͷ�ַ���
	 * @param request   �����ַ���
	 * @return 
	 */
	public static String getHeader(String request){
		String[] array = request.split("\\?");
		return array[0];
	}
	/**
	 * ��ȡ����Ĳ�����Map , key:String ,value:String
	 * @param request
	 * @return  ������Map����
	 */
	public static Map<String, String> getParams(String request){
		Map<String , String> paramMap = new HashMap<>();
		//��ʽdemo�� header?param1=value1&param2=value2
		String [ ] array = request.split("\\?");
		if(array.length == 2){
			String [ ] paramsArray = array[1].split("&");
			if(paramsArray.length > 0){
				for(String params : paramsArray){
					String [] p = params.split("=");
					paramMap.put(p[0], p[1]);
				}
			}
		}
		return paramMap;
	}
	
	/*public static Map<String ,String> getParamse(String request){
		
	}*/
}
