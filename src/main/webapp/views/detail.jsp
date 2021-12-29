<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 28/12/2021
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
    <style>
        th, td {
            padding: 5px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
        <h3>Product detail</h3>
    <a href="/product">Back to Product List</a>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
        <th>Image</th>

        <tr>
            <td>${requestScope["product"].getId()}</td>
            <td>${requestScope["product"].getName()}</td>
            <td>${requestScope["product"].getPrice()}</td>
            <td>${requestScope["product"].getDescription()}</td>
            <td>${requestScope["product"].getProducer()}</td>
            <td><img src="${requestScope["product"].getImage()}" alt="Image" }></td>
        </tr>

</table>
</body>
</html>
