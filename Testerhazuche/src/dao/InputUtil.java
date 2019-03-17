package dao;

import java.util.Scanner;

public class InputUtil {

	private static Scanner input = new Scanner(System.in);
	
	public static String next(){
		return input.next();
	}
	
	public static int nextInt(){
		try{
		return input.nextInt();
		}catch(Exception e){
			return 10;
		}
	}
}
