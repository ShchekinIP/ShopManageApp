<%@ page import="Entity.ShopEntity" %>
<%@ page import="Entity.ShipmentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<h1 style="text-align: center">Управление поставками</h1>
<h2 class="list-header">Добавить поставку</h2>
<div style="text-align: center;">
    <%
        ShipmentEntity shipmentEntity = (ShipmentEntity) request.getAttribute("shipment");
        {
    %>
    <form class="add-table" action="addShipment" method="POST">
        <input type="text" name="nameShipment" placeholder="Введите название" title="Введите название" value="<%=shipmentEntity != null ? shipmentEntity.getNameShipment() : ""%>">
        <input type="text" name="typeShipment" placeholder="Введите тип" title="Введите тип" value="<%=shipmentEntity != null ? shipmentEntity.getTypeShipment() : ""%>">
        <input type="text" name="adressShipment" placeholder="Введите адрес" title="Введите адрес" value="<%=shipmentEntity != null ? shipmentEntity.getAdressShipment() : ""%>">
        <input type="date" class="datapicker" name="dateShipment" id= "dateShipment" value="<%=shipmentEntity != null ? shipmentEntity.getDateShipment() : "Введите дату"%>">
        <input type="number" name="productCount" placeholder="Введите кол-во товара" title="Введите кол-во товара" value="<%=shipmentEntity != null ? shipmentEntity.getProductCount() : ""%>">
        <button type="submit" name="action" value="add" class="add-button"> Добавить/Изменить </button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>