<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">添加部门</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('addForm').submit()">确定</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">取消 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <s:form id="addForm"  method="post" action="department_add" namespace="/" theme="simple">
<table style="font-size::16px">
<tr>
  <td>部门名称</td>
  <td><s:textfield name="dname"></s:textfield></td>
</tr>
<tr>
  <td>描述</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea cols="50" rows="5" name="ddesc"></s:textarea>
  </td>
</tr>
</table>
</s:form>
</body>
</html>