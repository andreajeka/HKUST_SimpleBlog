package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable {

	private BufferedReader reader;
	PrintWriter out;
	private Socket socket;
	private boolean running = true;
	private int count; 
	
	public ThreadHandler (Socket socket, int count) {
		try {
			this.socket = socket;
			this.count = count;
			InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(isReader);
		} catch (Exception ex) {
			ex.printStackTrace(); 
		}
	}
	
	@Override
	public void run() {
		String message;
		try {
			while ((message = reader.readLine()) != null) {
				if (message.equals("visitor")) {
					out.println(count);
				} else if (message.equals("quit")) {
					running = false;
				} else {
					out.println(message);
				}
				out.flush();
				if (!running) break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
