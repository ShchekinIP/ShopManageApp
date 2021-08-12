<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.ShipmentEntity" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<ul>
    <li><a href="shop">Магазин</a></li>
    <li><a href="incomes">Доходы</a></li>
    <li><a href="workers">Работники</a></li>
    <li><a href="outlays">Расходы</a></li>
</ul>
<h1 style="text-align: center">Управление поставками</h1>

<h2 class="list-header">Список поставок</h2>
<a class="nav-menu-a" href="addShipment" style="margin-left:120px;">Добавить поставку</a>
<div class="table-header">
    <div class="column">Номер поставки</div>
    <div class="column">Название</div>
    <div class="column">Тип</div>
    <div class="column">Адрес</div>
    <div class="column">Дата</div>
    <div class="column">Кол-во товара</div>
    <div class="column"></div>
</div>
<%
    List<ShipmentEntity> shipments = (List<ShipmentEntity>) request.getAttribute("shipments");
    for (ShipmentEntity shipmentEntity : shipments) {
%>
<form id="shipments" class="table-list" action="shipments" method="POST">
    <div class="column"><input type="text" name="idShipment" value="<%=shipmentEntity.getIdShipment()%>"
                               title="<%=shipmentEntity.getIdShipment()%>" readonly></div>
    <div class="column"><input type="text" name="nameShipment" value="<%=shipmentEntity.getNameShipment()%>"
                               title="<%=shipmentEntity.getNameShipment()%>"></div>
    <div class="column"><input type="text" name="typeShipment" value="<%=shipmentEntity.getTypeShipment()%>"
                               title="<%=shipmentEntity.getTypeShipment()%>"></div>
    <div class="column"><input type="text" name="adressShipment" value="<%=shipmentEntity.getAdressShipment()%>"
                               title="<%=shipmentEntity.getAdressShipment()%>"></div>
    <div class="column"><input type="text" name="dateShipment" value="<%=shipmentEntity.getDateShipment()%>"
                               title="<%=shipmentEntity.getDateShipment()%>"></div>
    <div class="column"><input type="number" name="productCount" value="<%=shipmentEntity.getProductCount()%>"
                               title="<%=shipmentEntity.getProductCount()%>"></div>
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
