<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

</style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666">员工管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/employee_addUI.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
<tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="pageBean">
<tr>
<td align="center"><s:property value="#pageBean.eno"/></td>
<td align="center"><s:property value="#pageBean.ename"/></td>
<td align="center"><s:property value="#pageBean.sex"/></td>
<td align="center"><s:date name="#pageBean.birthday" format="yyyy-MM-dd"/></td>
<td align="center"><s:date name="#pageBean.joinDate" format="yyyy-MM-dd"/></td>
<td align="center"><s:property value="#pageBean.department.dname"/></td>
<td align="center"><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#pageBean.eid"/>"><img src="${pageContext.request.contextPath}/images/编辑.png"></a></a></td>
<td align="center"><a href="${pageContext.request.contextPath}/employee_delect.action?eid=<s:property value="#pageBean.eid"/>">删除</a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
   <apan>
       <a href="employee_findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="employee_findAll?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       <a href="employee_findAll?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="employee_findAll?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </span>
</td>
</tr>
</table>
</body>
</html>