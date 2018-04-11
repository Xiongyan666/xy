<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录界面</title>
	<s:head />
  </head>
  <body>
    <s:iterator value="data.datas" var="student" status="st">
 <tr align="center">
  <td>
   <s:property value="#student.id" />
  </td>
  <td>
   <s:property value="#student.name" />
  </td>
  <td>
   <s:date name="#student.birth" fomart="yyyy/MM/dd hh:mm:ss"/>
  </td>
 </tr>
</s:iterator>
  </body>
</html>