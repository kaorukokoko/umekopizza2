package servlet;

import java.net.URL;
import javax.jdo.annotations.*;

public class UserName {
	private String userid;
	
	public UserName(String userid){
		super();
		this.userid = userid;
	}
	
	public String getUserid(){
		return userid;
	}
	
	public void setUserid(String userid){
		this.userid = userid;
	}

}
