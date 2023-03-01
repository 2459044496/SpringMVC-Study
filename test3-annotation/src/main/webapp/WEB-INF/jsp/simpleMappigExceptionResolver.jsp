<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XX异常</title>
</head>
<body>
<h1>XX异常</h1>
<br>
<%-- 打印异常到页面上 --%>
<% Exception ex = (Exception)request.getAttribute("ex"); %>
<br>
<div><%=ex.getMessage()%></div>
<% ex.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>
