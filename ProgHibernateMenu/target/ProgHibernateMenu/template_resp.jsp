<%  %><%--
  Created by IntelliJ IDEA.
  User: safordog
  Date: 06.10.18
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/styles/styles.css"/>
    <title>MENU</title>
</head>
<body>
    <fieldset>
        <div id="logo">
            <u>MENU INTERFACE</u>
        </div>
        <div id="content">
        <br><% if (request.getAttribute("addedDishMessage") != null) {%>
                <%= request.getAttribute("addedDishMessage") %>
           <% } %>
            <% if (request.getAttribute("menuByPriceMessage") != null) {%>
            <%= request.getAttribute("menuByPriceMessage") %>
            <% } %>
            <% if (request.getAttribute("menuMessage") != null) {%>
            <%= request.getAttribute("menuMessage") %>
            <% } %>
            <% if (request.getAttribute("discountMenuMessage") != null) {%>
            <%= request.getAttribute("discountMenuMessage") %>
            <% } %>
            <% if (request.getAttribute("limitMenuMessage") != null) {%>
            <%= request.getAttribute("limitMenuMessage") %>
            <% } %>
        </div>
    </fieldset>
</body>
</html>
