package jhctpj.common;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class load {
	public static void main(String[] args) {
		
		
		try {
			
			Properties prop = new Properties();
			
			FileInputStream fis = new FileInputStream("driver.xml");
			
			prop.loadFromXML(fis);
			

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String userName = prop.getProperty("userName");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			System.out.println(conn); 
			
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
