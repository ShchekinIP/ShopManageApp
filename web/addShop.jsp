<%@ page import="Entity.ShopEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<h1 style="text-align: center">Управление магазинами</h1>
<h2 class="list-header">Добавить новый магазин</h2>
<div style="text-align: center;">
    <%
        ShopEntity shop = (ShopEntity) request.getAttribute("shop");
        {
    %>
<form class="add-table" action="addShop" method="POST">
    <input type="text" name="name" placeholder="Введите имя" title="Введите имя" value="<%=shop != null ? shop.getNameShop() : ""%>">
    <input type="text" name="address" placeholder="Введите адресс" title="Введите адресс" value="<%=shop != null ? shop.getAdressShop() : ""%>">
    <input type="text" name="type" placeholder="Введите тип" title="Введите тип" value="<%=shop != null ? shop.getTypeShop() : ""%>">
    <input type="number" name="capital" placeholder="Введите бюджет" title="Введите бюджет" value="<%=shop != null ? shop.getCapitalShop() : ""%>">
    <button type="submit" name="action" value="add" class="add-button"> Добавить/Изменить </button>
</form>
    <%
        }
    %>
</div>
</body>
</html>