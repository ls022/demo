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
	 * ���������������,��������,��ȡ��Ӧ
	 * 
	 * @param request
	 *            Ҫ���͵�����
	 * @return �������˷��ص���Ӧ
	 */
	public String sendRequest(String request) {
		String response = null;
		// 1. ��������
		connect();
		//  2.�����������������д��
		pwSocket.println(request);
		//  3.��ȡ�������˷��ص���Ӧ
		try {
			response = brSocket.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.�ͷ���Դ
		close();
		//���صõ�����Ӧ
		return response;
	}

	// ���������������,��ȡ��,д����
	private void connect() {
		try {
			// ��������˽�������
			socket = new Socket("localhost", 6000);
			// ��ȡ��
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
