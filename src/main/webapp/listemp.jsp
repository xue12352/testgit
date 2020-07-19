<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<table border="1">
    <tr>
        <td>
            员工编号
        </td>
        <td>
            员工姓名
        </td>
        <td>
            员工年龄
        </td>
        <td>
            员工部门
        </td>
    </tr>

    <c:forEach items="${emps}" var="i">
        <tr>
            <td>${i.oid}</td>
            <td>${i.ename}</td>
            <td>${i.age}</td>
            <td>${i.deptid}</td>
        </tr>
    </c:forEach>
</table>
<c:choose>
    <c:when test="${pageInfo.isFirstPage=='true'}">
        <a>上一页</a>
    </c:when>
    <c:otherwise>
        <a href="empcontroller/listemp?current=${current-1}">上一页</a>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${pageInfo.isLastPage=='true'}">
        <a>下一页</a>
    </c:when>
    <c:otherwise>
        <a href="empcontroller/listemp?current=${current+1}">下一页</a>
    </c:otherwise>
</c:choose>
</body>
</html>