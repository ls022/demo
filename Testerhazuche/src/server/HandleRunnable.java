package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class HandleRunnable implements Runnable {
	private Socket socket;
	private BufferedReader brSocket;//�����ȡһ��
	private PrintWriter pwSocket;//����дһ��
	
	public HandleRunnable(Socket socket) {
		init(socket);
	}
	
	private void init(Socket socket){
		this.socket = socket;
		try {
			brSocket = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			//д���Զ�flush
			pwSocket = new PrintWriter(
					socket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void run() {		
		try {
			//1.�ȶ�����,�̶���
			String request = brSocket.readLine();
			//2.����,��������ͬ,Ҫ����ͬ�Ĵ���
			String response = dispatchRequest(request);
			//3.������Ӧ
			pwSocket.println(response);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//4.�ر���Դ
			close();
		}		
	}
	
	/**
	 * ��������
	 * @param request:����
	 * @return  ��Ӧ
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
