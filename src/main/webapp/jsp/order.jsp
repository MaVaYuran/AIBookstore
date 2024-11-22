<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Bookstore</title>
</head>
<body>
  <h1> Our books</h1>
    <table border=1 style="color: blue">
     <tr>
        <th>Title</th>
        <th>Price</th>
     </tr>
     <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.price}</td>
        </tr>
     </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/order" method="POST">
        <label for="title">Enter book title: </label>
        <input type="text" id="title" name="title">
        <input type="submit" value="Order book">
    </form>
    <c:if test="${not empty error}">
        <div style="color:red">${error}</div>
    </c:if>
</body>
</html>