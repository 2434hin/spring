package kr.or.ddit.test.ioc;

public class DbProperty {

	private String driver; 
	private String url;
	private String user;
	private String pass;
	
	public DbProperty() {}
	
	public DbProperty(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
