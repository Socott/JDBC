package entity;

import java.io.Serializable;

public class Softpool implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 98124920251535085L;
	private String title;
	private String username;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Softpool [title=" + title + ", username=" + username + "]";
	}
	
}
