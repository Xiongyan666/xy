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
		InitialContext ctx=new InitialContext();//�������ݿ�
		ds=(DataSource)ctx.lookup("java:comp/env/jdbc/bbs");
		Connection conn=ds.getConnection();
		Statement stmt=conn.createStatement();//��������ݿ�ǰ���ἰ��Data soure url���ð��������ݿ�
		String strSql="select *from bbsdb";
		ResultSet rs=stmt.executeQuery(strSql);
		while(rs.next()){
		out.println("����"+rs.getString("title"));}
		out.print("test over!");}
		catch(SQLException ex){
		out.print("�������⣬��Ϣ��:"+ex.getMessage());
		ex.printStackTrace();
		} %>
	</head>
</html>