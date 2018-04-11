package ch1;
import java.sql.*;

import javax.activation.DataSource;
import javax.naming.NamingException;
public class DbConn {
private static DataSource ds=null;
private static Connection conn=null;
public static Connection getConn_jdbc(){
	try{
		String url="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="123456";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn=DriverManager.getConnection(url,username,password);
		return conn;
	}catch(Exception e){
		System.err.print("数据库连接异常:"+e.getMessage());
		return null;
	}
	
}
public void CloseConn(){
	try{
		conn.close();
	}catch(Exception e){
		System.err.print("数据库连接关闭异常:"+e.getMessage());
	}
}
public static void main(String[] a)throws NullPointerException{
	Connection conn;
	DbConn dc=new DbConn();
	conn=dc.getConn_jdbc();
	try {
		
		Statement stmt=conn.createStatement();
		String strSql="select *from bbsdb";
		ResultSet rs=stmt.executeQuery(strSql);
		while(rs.next()){
			System.out.print("标题"+rs.getString("title"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		dc.CloseConn();
	}
}
}
