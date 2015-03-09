package base;
import java.util.Date;

public class FriendsPost extends Post {
	private User friend;
	
	public FriendsPost(Date date, String content, User user) {
		super(date, content);
		this.friend = user;
		
	}
	
	private String getInfoFromSuper() {
		return super.toString();
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	**/
	public String toString() {
		//TODO
		String newline = System.lineSeparator();
		String s = friend.toString() + newline;
		String t = getInfoFromSuper();
		return s + t;
		
	}
	
}
