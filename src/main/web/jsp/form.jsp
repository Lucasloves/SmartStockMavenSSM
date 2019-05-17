<%--
  Created by IntelliJ IDEA.
  User: 74534
  Date: 2019/5/9
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="${ctx}/orders/m1" method="get">
    <input type="submit" value="提交">
</form>

<form action="${ctx}/orders/m4" method="get">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="提交">
</form>

</body>
</html>
