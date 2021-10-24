
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h3>Hello, ${userName}!</h3>
        <p><a href="ShoppingList?action=logout">Log Out</a></p>
        <h2>List</h2>
        <form action="" method="POST">
            <label>Add Item: </label>
            <input type="text" name="itemEntered">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">           
        </form>
        
        <form action="" method="POST">
            <ul>
                <c:forEach items="${items}" var="itemName">
                    <input type="radio" name="itemName" value="${itemName}">${itemName}
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
