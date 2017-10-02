<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${model.id==null?'添加':'修改'}订单</title>
</head>
<body style="text-align: center;">
	<h3>${model.id==null?'添加':'修改'}订单</h3>
	
	<form action="${pageContext.request.contextPath }${model.id==null?'/Order/Order_add':'/Order/Order_update'}" method="post">
		<input type="hidden" name="id" value="${model.id}">
		<input type="hidden" name="customer_id" value="<%=request.getParameter("customer_id")%>">
		商品项：<input type="text" name="items" value="<s:property value="%{model.items}"/>"/><br>
		下单时间：<input type="text" name="odate" value="<s:property value="%{model.odate}"/>"/><br/>
		<input type="submit" value="${model.id==null?'添加':'修改'}"/>
		&nbsp;&nbsp;<input type="button" value="返回"  onclick="javascript:location.href='${pageContext.request.contextPath }/Order/Order_list?customer_id=<%=request.getParameter("customer_id")%>'">
		
	</form>

</body>
</html>