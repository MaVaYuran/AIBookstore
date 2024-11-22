<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Order details</title>
</head>
<body>
    <h2> Book ordered</h2>
    <h3>Order details:</h3>
  <div style="color: purple">
    <p>ID:  ${order.id}</p>
    <p>Book title: ${order.book.title}</p>
    <p>Book price: ${order.book.price}</p>
    <p>Time: ${order.openingTimestamp}</p>
    <p>Status: ${order.status}</p>
  </div>

    <div class="form-container">
        <form action="/complete" method="POST">
           <input type="number" hidden name="id" value="${order.id}">
           <input type="submit" name="complete" value="Complete">
        </form>
        <form action="/cancel" method="GET">
           <input type="number" hidden name="id" value="${order.id}">
           <input type="submit" name="cancel" value="Cancel">
        </form>
    </div>
</body>
</html>