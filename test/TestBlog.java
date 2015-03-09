package test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;

public class TestBlog {

	/**
	 * Get user's input
	 * @return
	 */
	public String getInput() {
		String line = "";
		System.out.print("Enter the prompt:");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")) {
			// String prompt has already stores the input, now deal with it!
			if (prompt.startsWith("list")){
				myblog.list();
			}
			else if (prompt.startsWith("post")) {
				String[] content = prompt.split(" ", 2);
				Date date = new Date();
				Post post = new Post(date,content[1]);
				myblog.post(post);
			}
			else if(prompt.startsWith("delete")) {
				String[] content = prompt.split(" ");
				int index = Integer.parseInt(content[1]);
				myblog.delete(index);
			}
		}
	}

}
