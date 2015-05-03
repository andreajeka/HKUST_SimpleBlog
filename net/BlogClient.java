package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args) {
		try (
				Socket socket = new Socket(IP, PORT);
			    PrintWriter out = new PrintWriter(socket.getOutputStream(), 
			                 true);
			    BufferedReader in = new BufferedReader(new InputStreamReader(
			                socket.getInputStream()));
			    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			) {
				String userInput;
				while((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					out.flush();
				}
			} catch (UnknownHostException e) {
				System.err.println("Unknown host");
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for the connection");
				System.exit(1);
			}
	}
}
