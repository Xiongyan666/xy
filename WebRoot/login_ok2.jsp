<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录成功</title>
	<s:head />
  </head>
  <body>
    欢迎<s:property value="username"/>,登陆成功！！
	<h2><s:text name="username"/></h2>
	<h2><s:text name="password"/></h2>
  </body>
</html>



<!-- native2ascii globalMessage.properties globalMessage_zh_CN.properties -->