<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 27/12/2021
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td {
            border: 1px solid black;
            padding: 5px 5px
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<h3><a href="/product?action=create">Create New Product</a></h3>
<h3><a href="/product?action=search">Search Product</a></h3>
<table>
    <th>#</th>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Description</th>
    <th>Image</th>

    <c:forEach items="${productList}" var="product" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.name}</td>
            <td>${product.idCategory}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><a href="/product?action=detail&&id=${product.id}"><img src="${product.image}" alt="Image" width="150px"
                                                                        height="300px"></a></td>
            <td><a href="/product?action=edit&&id=${product.id}">Edit</a></td>
            <td><a href="/product?action=delete&&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
