package base;

public class User implements Comparable<User> {
	private int userID;
	private String userName;
	private String userEmail;
	
	public User(int userID, String userName, String userEmail ) {
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	public int getUserID () {
		return userID;
	}
	
	public String getuserName() {
		return userName;
	}
	
	public String getuserEmail() {
		return userEmail;
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	**/
	public String toString() {
		String s = "User [userId=" + getUserID() + ", userName=" + getuserName() + ", userEmail=" + getuserEmail() +"]";
		return s;
		
	}
	
	@Override
	public int compareTo(User u) {
		if (userID > u.getUserID() ) return 1;
		if (userID < u.getUserID()) return -1;
		else return 0;
	}
	
}
