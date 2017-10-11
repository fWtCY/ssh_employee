<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">编辑员工</td>
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
 <s:form id="addForm"  method="post" action="department_update" namespace="/" theme="simple">
<table style="font-size::16px">
<s:hidden  name="did" value="%{model.did}"></s:hidden>
<tr>
  <td>编号</td>
  <td><s:textfield name="eno" value="%{model.eno}"></s:textfield></td>
</tr>
<tr>
  <td>名字</td>
  <td><s:textfield name="dname" value="%{model.ename}"></s:textfield></td>
</tr>
<tr>
  <td>性别</td>
  <td><s:radio list="{'男','女'}" value="%{model.sex}" name="sex"></s:radio></td>
</tr>
<tr>
  <td>出生日期</td>
  <td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"></td>
</tr>
<tr>
  <td>入职日期</td>
  <td><input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>"></td>
</tr>
<tr>
  <td>所属部门</td>
  <td><s:select value="%{department.did}" listKey="did"  listValue="dname" headerValue="-----请选择-----" list="list" name="department.did"></s:select></td>
</tr>
<tr>
  <td>账号</td>
  <td><s:textfield name="username" value="%{model.username}"></s:textfield></td>
</tr>
<tr>
  <td>密码</td>
  <td><s:password name="password" value="%{model.password}"></s:password></td>
</tr>
</table>
</s:form>
</body>
</html>