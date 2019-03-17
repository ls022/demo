package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void start(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			while(true){
				Socket socket = serverSocket.accept();
				//
				/*Thread thread = new Thread(new HandleRunnable());
				thread.start();*/
				System.out.println("�������"+socket.getInetAddress().getHostAddress()+"���������ӣ�");
				new Thread(new ServerDispatchRequest(socket)).start();
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
