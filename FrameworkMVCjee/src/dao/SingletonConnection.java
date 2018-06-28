package dao;

import  java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	

	public  static   Connection connection=null;
	private static  String Db="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/db_catal";
	private static  String user="root";
	private static  String pass="";
	private static  String unicode="";

private static Connection connect(){
	
	try {
		Class.forName (Db);
		connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return connection;
	}

public static Connection getConn()
{
	if(connection == null) connect();
	return connection;
}
	
	
//	private static Connection connection;
//	static {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cata","root","");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static Connection getConnection() {
//		return connection;
//		}
//	

}
