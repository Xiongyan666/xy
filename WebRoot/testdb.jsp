<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page session="false" %>
<html>
	<head>
		<title></title>
		<%
		out.print("test begin");
		DataSource ds=null;
		try{
		InitialContext ctx=new InitialContext();//拦截数据库
		ds=(DataSource)ctx.lookup("java:comp/env/jdbc/bbs");
		Connection conn=ds.getConnection();
		Statement stmt=conn.createStatement();//这里的数据库前文提及的Data soure url配置包含的数据库
		String strSql="select *from bbsdb";
		ResultSet rs=stmt.executeQuery(strSql);
		while(rs.next()){
		out.println("标题"+rs.getString("title"));}
		out.print("test over!");}
		catch(SQLException ex){
		out.print("出现例外，信息是:"+ex.getMessage());
		ex.printStackTrace();
		} %>
	</head>
</html>