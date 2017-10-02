<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户管理页面</title>
</head>
<body style="text-align: center;">
	<h2>客户管理</h2>
	<br>
	<a href="${pageContext.request.contextPath }/customer/addUI.jsp">添加用户</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="返回"  onclick="javascript:location.href='${pageContext.request.contextPath }/index.jsp'">
		<table width="70%" frame="border" border="1" align="center">
			<tr>
				<td>用户姓名</td>
				<td>地址</td>
				<td>手机号</td>
				<td>
					订单
				</td>
				<td>
					操作
				</td>
			</tr>
			
			<s:iterator value="customers" var="customer">
			<tr>
				<td>
					<s:property value="%{#customer.cname}"/>
				</td>
				<td>
					<s:property value="%{#customer.addr}"/>
				</td>
				<td>
					<s:property value="%{#customer.cellphone}"/>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/Order/Order_list?customer_id=<s:property value='%{#customer.id}'/>">订单详情</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/Customer/Customer_delete?c_id=<s:property value='%{#customer.id}'/>">删除</a>
					<a href="${pageContext.request.contextPath }/Customer/Customer_updateUI?c_id=<s:property value='%{#customer.id}'/>">修改</a>
				</td>
			</tr>
			
			</s:iterator>
		
		
		</table>
		<s:actionmessage theme="simple"/>
	
	
	
</body>
</html>