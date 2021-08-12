<%@ page import="Entity.ShopEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<ul>
    <li><a href="incomes">Доходы</a></li>
    <li><a href="shipments">Поставки</a></li>
    <li><a href="workers">Работники</a></li>
    <li><a href="outlays">Расходы</a></li>
</ul>
<h1 style="text-align: center">Управление магазинами</h1>
<h2 class="list-header">Список магазинов</h2>
<a class="nav-menu-a" href="addShop" style="margin-left:120px;">Добавить магазин</a>
<div class="table-header">
    <div class="column">Номер</div>
    <div class="column">Название</div>
    <div class="column">Адрес</div>
    <div class="column">Тип</div>
    <div class="column">Бюджет</div>
    <div class="column"></div>
</div>
<%
    List<ShopEntity> shops = (List<ShopEntity>) request.getAttribute("shops");
    for (ShopEntity shopEntity : shops) {
%>
<form id="shops" class="table-list" action="shop" method="POST">
    <div class="column"><input type="text" name="id" value="<%=shopEntity.getIdShop()%>"
                               title="<%=shopEntity.getIdShop()%>" readonly></div>
    <div class="column"><input type="text" name="name" value="<%=shopEntity.getNameShop()%>"
                               title="<%=shopEntity.getNameShop()%>"></div>
    <div class="column"><input type="text" name="address" value="<%=shopEntity.getAdressShop()%>"
                               title="<%=shopEntity.getAdressShop()%>"></div>
    <div class="column"><input type="text" name="type" value="<%=shopEntity.getTypeShop()%>"
                               title="<%=shopEntity.getTypeShop()%>"></div>
    <div class="column"><input type="number" name="capital" value="<%=shopEntity.getCapitalShop()%>"
                               title="<%=shopEntity.getCapitalShop()%>"></div>
    <div class="column">
        <button type="submit" name="action" value="edit">
            Изменить
        </button>
        <button type="submit" name="action" value="delete">
            Удалить
        </button>
    </div>
</form>
<%
    }
%>
</body>
</html>
