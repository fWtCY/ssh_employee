<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<td align="center" style="font-size:24px; color:#666"> 部门管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/department_addUI.action">增加</a></td>
</tr>
</table>
<br/>
<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
   		<th width="450">部门名称</th>
   		<th  width="225">编辑</th>
   		<th width="225"> 
   </tr>
</thead>
<tbody>
<s:iterator value="list" var="pageBean" >
<tr>
<td align="center"><s:property value="#pageBean.dname"/></td>
<td align="center"><a href="${pageContext.request.contextPath}/department_edit?did=<s:property value="#pageBean.did"/>"><img src="${pageContext.request.contextPath}/images/编辑.png"></a></td>
<td align="center"><a href="${pageContext.request.contextPath}/department_delete?did=<s:property value="#pageBean.did"/>">删除</a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/></span>
   <apan>
      	<s:if test="totalPage!=1"> 
       <a href="${pageContext.request.contextPath}/department_findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/department_findAll?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currpage!=totalPage"> 
       <a href="${pageContext.request.contextPath}/department_findAll?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/department_findAll?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>