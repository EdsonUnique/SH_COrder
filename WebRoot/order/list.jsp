<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单详情</title>
</head>
<body style="text-align: center;">
	<h3>订单内容</h3>
	<a href="${pageContext.request.contextPath }/order/addUI.jsp?customer_id=<s:property value='%{customer_id}'/>">添加订单</a>
	<table width="70%" frame="border" border="1" align="center">
		<tr>
			<td>订单号</td>
			<td>下单时间</td>
			<td>订单项</td>
			<td>操作</td>
		</tr>
		<s:iterator value="orders" var="order">
			<tr>
				<td><s:property value="%{#order.id}"/></td>
				<td><s:property value="%{#order.odate}"/></td>
				<td><s:property value="%{#order.items}"/></td>
				<td>
					<a href="${pageContext.request.contextPath }/Order/Order_updateUI?id=<s:property value='%{#order.id}'/>&customer_id=<s:property value='%{customer_id}'/>">修改</a>
					<a href="${pageContext.request.contextPath }/Order/Order_delete?id=<s:property value='%{#order.id}'/>&customer_id=<s:property value='%{customer_id}'/>">删除</a>
				</td>
			</tr>
		</s:iterator>
		
	</table>
	&nbsp;&nbsp;<input type="button" value="返回"  onclick="javascript:location.href='${pageContext.request.contextPath }/Customer/Customer_list'">
	
		<s:actionmessage/>
</body>
</html>