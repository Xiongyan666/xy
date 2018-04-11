package ch1;
import java.util.*;
import com.opensymphony.xwork2.*;
public class Login_2 extends ActionSupport{
private String username;
private String password;
public String getUsername(){
	return username;
}
public void setUsername(String username){
	this.username=username;
}
public String getPassword(){
	return password;
}
public void setPassword(String password){
	this.password=password;
}
public String execute() throws Exception{
	return SUCCESS;
}
public void validate(){
	if(username==null||username.trim().equals("")){
		addFieldError("username",getText("username.empty"));
	}
	if(password==null||password.trim().equals("")){
		addFieldError("password",getText("password.empty"));
	}
}
}
