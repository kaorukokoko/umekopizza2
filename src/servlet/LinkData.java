package servlet;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String title;
     
    @Persistent
    private String url;
     
    @Persistent
    private String comment;
     
    @Persistent
    //@PrimaryKey
    private Date datetime;
    
    private String date;
    
    private String userid;
    
    public LinkData(){
    	
    }
 
    public LinkData(String title, String url, String comment, String datetime) {
        super();
        this.title = title;
        this.url = url;
        this.comment = comment;
        //this.datetime = datetime;
        this.date = datetime;
    }
    
    public LinkData(String title, String url, String comment, String datetime,String userid) {
        super();
        this.title = title;
        this.url = url;
        this.comment = comment;
        //this.datetime = datetime;
        this.date = datetime;
        this.userid = userid;
    }
    
    public LinkData(String userid){
		super();
		this.userid = userid;
	}
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    public String getDatetime() {
        return date;
    }
 
    public void setDatetime(String datetime) {
        //this.datetime = datetime;
        //String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this.datetime);
        //date = str;
    	this.date = datetime;
    }
    
    public String getUserid(){
		return userid;
	}
	
	public void setUserid(String userid){
		this.userid = userid;
	}
}