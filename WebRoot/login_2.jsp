<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录界面</title>
	<s:head />
  </head>
  <body>
    登陆界面 <br>
	<s:actionerror/>
	<s:form  action="reg">
    <s:textfield name="username" key="username" label="用户名" errorposition="buttom"/><br>
    <s:password name="password" key="password" label="密码"  errorposition="buttom"/><br>
    <s:submit value="提交"/>
    </s:form>
  </body>
</html>