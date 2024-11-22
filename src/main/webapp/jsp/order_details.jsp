<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Order details</title>
</head>
<body>
    <h1> Book ordered</h1>
    <h3>Order details:</h3>
  <div style="color: purple">
    ${orderDetails}
   </div>

    <div class="form-container">
        <form action="/order" method="POST">
            <label for="status">Confirm order</label>
            <select name="status" id="status">
                <option value="1">Complete order</option>
                <option value="2">Cancel order</option>
            </select>

            <input type="submit" value="submit">
    </div>
</body>
</html>