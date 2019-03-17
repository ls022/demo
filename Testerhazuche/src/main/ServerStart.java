package main;

import server.Server;

/**
 * 服务器入口
 * @author 
 *
 */
public class ServerStart {
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}



