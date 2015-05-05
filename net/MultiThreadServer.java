package net;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;

	
	public static void main(String[] args) throws Exception {
		int count = 0;
		ServerSocket serverSocket = new ServerSocket(PORT);
		while (true) {
			Socket clientSocket = serverSocket.accept();
			count++;
			Thread newThread = new Thread(new ThreadHandler(clientSocket, count));
			newThread.start();
		}
	}

}
