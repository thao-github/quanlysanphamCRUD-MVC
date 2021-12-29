<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 27/12/2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit model.Product</title>
</head>
<body>
<a href="/product"> Back to Product List</a>
<form method="post">
    <input type="text" name="id" placeholder="id" value="${requestScope["product"].getId()}"/>
    <input type="text" name="name" placeholder="name" value="${requestScope["product"].getName()}"/>
    <input type="text" name="idCategory" placeholder="idCategory" value="${requestScope["product"].getIdCategory()}"/>
    <input type="text" name="price" placeholder="price" value="${requestScope["product"].getPrice()}"/>
    <input type="text" name="description" placeholder="description" value="${requestScope["product"].getDescription()}"/>
    <input type="text" name="producer" placeholder="producer" value="${requestScope["product"].getProducer()}"/>
    <input type="text" name="image" placeholder="image" value="${requestScope["product"].getImage()}"/>
    <input type="submit" value="Edit"/>
</form>
</body>
</html>
