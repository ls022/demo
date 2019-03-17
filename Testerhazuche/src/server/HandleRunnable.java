package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class HandleRunnable implements Runnable {
	private Socket socket;
	private BufferedReader brSocket;//方便读取一行
	private PrintWriter pwSocket;//方便写一行
	
	public HandleRunnable(Socket socket) {
		init(socket);
	}
	
	private void init(Socket socket){
		this.socket = socket;
		try {
			brSocket = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			//写后自动flush
			pwSocket = new PrintWriter(
					socket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void run() {		
		try {
			//1.先读请求,固定的
			String request = brSocket.readLine();
			//2.处理,根据请求不同,要做不同的处理
			String response = dispatchRequest(request);
			//3.返回响应
			pwSocket.println(response);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//4.关闭资源
			close();
		}		
	}
	
	/**
	 * 处理请求
	 * @param request:请求
	 * @return  响应
	 */
	public abstract String dispatchRequest(String request);
	
	private void close(){
		if(brSocket!=null){
			try {
				brSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pwSocket!=null){
			pwSocket.close();
		}
		
		if(socket!=null){
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
