<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${model.id==null?'添加':'修改'}客户</title>
</head>
<body style="text-align: center;">
	<h3>${model.id==null?'添加':'修改'}客户</h3>
	<form action="${pageContext.request.contextPath }${model.id==null?'/Customer/Customer_add' : '/Customer/Customer_update'}" method="post">
		<input type="hidden" name="id" value="<s:property value='%{model.id}'/>"/>
		用户名：<input type="text" name="cname" value="<s:property value='%{model.cname}'/>"/><s:fielderror fieldName="cname"/><br/>
		地址：<input type="text" name="addr" value="<s:property value='%{model.addr}'/>"/><s:fielderror fieldName="addr"/><br/>
		手机号码：<input type="text" name="cellphone" value="<s:property value='%{model.cellphone}'/>"/><s:fielderror fieldName="cellphone"/><br/>
		<input type="submit" value="${model.id==null?'添加':'修改'}"/>
		&nbsp;&nbsp;<input type="button" value="返回"  onclick="javascript:location.href='${pageContext.request.contextPath }/Customer/Customer_list'">
		
	</form>

</body>
</html>