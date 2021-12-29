<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 29/12/2021
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
    <style>
        th, td{
            padding: 5px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>Product detail</h3>
<a href="/product">Back to Product List</a>
<table>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
    <th>Description</th>
    <th>Producer</th>
    <th>Image</th>
    <c:forEach items="${searchList}" var="product" varStatus="loop">
    <tr>
        <td>${product.getId()}</td>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getProducer()}</td>
        <td><img src="${product.getImage()}" alt="Image" width="150px" height="300px"></td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
