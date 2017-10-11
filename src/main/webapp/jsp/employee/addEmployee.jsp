<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">添加员工</td>
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
 <s:form id="addForm"  method="post" action="employee_add.action" namespace="/" theme="simple">
<table style="font-size::16px">
<tr>
	<td>姓名:</td>
	<td><s:textfield name="ename"></s:textfield></td>
	<td>性别:</td>
	<td><s:radio list="{'男','女'}" name="sex"></s:radio></td>
</tr>
<tr>
	<td>用户名:</td>
	<td><s:textfield name="username"></s:textfield></td>
	<td>密码:</td>
	<td><s:textfield name="password"></s:textfield> </td>
</tr>
<tr>
	<td width="10%">出生日期:</td>
	<td width="20%"><s:textfield name="birthday"></s:textfield></td>
	<td width="8%">入职时间</td>
	<td width="62%"><s:textfield name="joinDate"></s:textfield> </td>
</tr>
<tr>
	<td width="10%">所属部门</td>
	<td width="20%"><s:select  listKey="did"  listValue="dname" headerValue="-----请选择-----" list="list" name="department.did"></s:select></td>
	<td width="8%">编号</td>
	<td width="62%"><s:textfield name="eno"></s:textfield></td>
</tr>
</table>
</s:form>
</body>
</html>