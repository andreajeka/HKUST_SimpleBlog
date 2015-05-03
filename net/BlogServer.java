package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args) {
		try (
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + 
					PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
