<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <title>显示登录信息</title>
  </head>
  <body>
  <s:debug/>
	当前登录用户是<s:property value="username"/><br>
	当前用户登陆密码是<s:property value="password"/>
  </body>
</html>
