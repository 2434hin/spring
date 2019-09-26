package kr.or.ddit.user.model;

public class User {
	
	private String userId;
	private String pass;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + "]";
	}
	
}
