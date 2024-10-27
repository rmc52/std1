package jhctpj.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class jdbctemplate {
	

	private static Connection conn = null;

	
	public static Connection getConnection() {
		
		try {
			
		
			if(conn != null && !conn.isClosed()) {
				return conn;
			}
		
			Properties prop = new Properties();
		
			
			String filePath = "driver.xml";
			
			prop.loadFromXML(new FileInputStream(filePath));
			
	
			Class.forName(prop.getProperty("driver"));
			
			String url = prop.getProperty("url");
			
			String userName = prop.getProperty("userName");
			
			String password = prop.getProperty("password");
			
			conn = DriverManager.getConnection(url, userName, password);
			
			
			conn.setAutoCommit(false);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
	

	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	

	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void close(Statement stmt) {
		
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
