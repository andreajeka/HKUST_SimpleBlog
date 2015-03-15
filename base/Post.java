package base;
import java.util.Date;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Class;

public class Post implements Comparable<Post>, Serializable {
	private Date date;
	private String content;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content) {
		this.date = date;
		this.content = content;
	}
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return the content of the blog
	 */
	public String getContent() {
		//TODO
		return content;
	}
	
	public void setContent(String content) {
		//TODO
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override 
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		String output = getDate() + newline + getContent();
		return output;
	}
	
	@Override
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	**/ 
	public boolean equals(Object o) {
		// Should it be equal compared to itself?
		if (o == this) return true;
		
		// What if object is null?
		if (o == null) return false;
		
		// Are they the same class?
		// You can get the class of object o
		Class temp = o.getClass();
		Post aPost = new Post();
		if (temp != this.getClass()) {
			//You can transfer object o to POST
		    aPost = (Post) o;
			if (aPost.getContent() == this.getContent() 
					&& aPost.getDate() == this.getDate()) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		// TODO
		// Give hashcode a unique value
		// You can use the hashcode of your attributes
		int dHashCode= date.hashCode();
		int cHashCode= content.hashCode();
		hashCode = dHashCode * cHashCode;
		return hashCode;
	}
	
	/**
	 * Check whether this post contains some keyword
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword) {
		// TODO
		if (content.contains(keyword))
			return true;
		else 
			return false;
	}

	@Override
	public int compareTo(Post p) {
		if (date.compareTo(p.getDate()) > 0) return 1;
		else if (date.compareTo(p.getDate()) < 0) return -1;
		else return 0;
	}
	
}
