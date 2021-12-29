<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 27/12/2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<form method="post">
    <label>Id: </label>
<input type="text" name="id" placeholder="id"/><br>
    <label>Name: </label>
<input type="text" name="name" placeholder="name"/><br>
    <label>Category: </label>
    <select name="idCategory" >
    <c:forEach items="${categories}" var="c">
        <option value="${c.getId()}"> ${c.getName()}</option>
    </c:forEach>
    </select><br>
    <label>Price: </label>
<input type="text" name="price" placeholder="price"/><br>
    <label>Description: </label>
<input type="text" name="description" placeholder="description"/><br>
    <label>Producer: </label>
<input type="text" name="producer" placeholder="producer"/><br>
    <label>Image: </label>
<input type="text" name="image" placeholder="image"/><br>
<input type="submit" value="Create"/>
</form>
</body>
</html>
