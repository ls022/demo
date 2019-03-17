package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private BufferedReader brSocket;
	private PrintWriter pwSocket;
	/**
	 * 与服务器建立连接,发送请求,获取响应
	 * 
	 * @param request
	 *            要发送的请求
	 * @return 服务器端返回的响应
	 */
	public String sendRequest(String request) {
		String response = null;
		// 1. 建立连接
		connect();
		//  2.发送请求给服务器（写）
		pwSocket.println(request);
		//  3.读取服务器端返回的响应
		try {
			response = brSocket.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.释放资源
		close();
		//返回得到的响应
		return response;
	}

	// 与服务器建立连接,获取读,写的流
	private void connect() {
		try {
			// 与服务器端建立连接
			socket = new Socket("localhost", 6000);
			// 获取流
			brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pwSocket = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void close() {
		if (brSocket != null) {
			try {
				brSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pwSocket != null) {
			pwSocket.close();
		}

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
