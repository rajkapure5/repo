package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	FileInputStream file;
	Properties property1;
	
	public Utils() throws IOException{
				try {
					file=new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\latestpractice\\src\\main\\java\\property\\property.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		property1=new Properties();
				property1.load(file);
			
		
	}
	public String getUrl() {
		String url1=property1.getProperty("url");
		System.out.println(url1);
		return url1;
	}
	public String getUsername() {
		String user=property1.getProperty("username");
		System.out.println(user);
		return user;
	}
	public String getPassword() {
		String password=property1.getProperty("pwd");
		System.out.println(password);
		return password;
	
}
	public String verifylogin() {
	String verify=property1.getProperty("verifyloginurl");
	System.out.println(verify);
		return verify;
	}
	
}
