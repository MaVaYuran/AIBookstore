<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Order details</title>
</head>
<body>
    <h2> Order cancelled</h2>
    <h3>Order details:</h3>
  <div style="color: purple">
    <p>ID:  ${order.id}</p>
    <p>Book title: ${order.book.title}</p>
    <p>Book price: ${order.book.price}</p>
    <p>Time: ${order.closingTimestamp}</p>
    <p>Status: ${order.status}</p>
  </div>
    <a href="${pageContext.request.contextPath}/order" class="back-link">Go back!</a>
</body>
</html>

