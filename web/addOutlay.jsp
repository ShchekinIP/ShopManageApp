<%@ page import="Entity.ShopEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.OutlayEntity" %>
<%@ page import="Entity.ShipmentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Income</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
    <script src="script.js" defer></script>
</head>
<body>
<h1 style="text-align: center">Управление расходами</h1>
<h2 class="list-header">Добавить расход</h2>
<div style="text-align: center;">
    <%
        OutlayEntity outlay = (OutlayEntity) request.getAttribute("outlay");
        {
    %>
    <form class="add-table" action="addOutlay" method="POST">
        <input type="date" class="datapicker" name="date" id="date" value="<%=outlay != null ? outlay.getDateOutlay() : "Введите дату"%>">

        <span>Выберете магазин:</span>
        <select name="shop_id" title="Выбрать магазин">
            <%
                List<ShopEntity> shops = (List<ShopEntity>) request.getAttribute("shops");
                for (ShopEntity shopEntity : shops) {
                    if (outlay != null && shopEntity.getIdShop() == outlay.getShopEntity().getIdShop()) {
            %>
                <option value="<%=Integer.toString(shopEntity.getIdShop())%>" selected>
                    <%=Integer.toString(shopEntity.getIdShop())%>
                </option>
            <%
                } else {
            %>
                <option value="<%=Integer.toString(shopEntity.getIdShop())%>">
                    <%=Integer.toString(shopEntity.getIdShop())%>
                </option>
            <%
                    }
                }
            %>
        </select>

        <span>Выберете поставку:</span>
        <select name="shipment_id" title="Выбрать поставку" >
            <%
                List<ShipmentEntity> shipments = (List<ShipmentEntity>) request.getAttribute("shipments");
                for (ShipmentEntity shipmentEntity : shipments) {
                    if (outlay != null && shipmentEntity.getIdShipment() == outlay.getShipmentEntity().getIdShipment()) {
            %>
                <option value="<%=Integer.toString(shipmentEntity.getIdShipment())%>" selected>
                    <%=Integer.toString(shipmentEntity.getIdShipment())%>
                </option>
            <%
                } else {
            %>
                <option value="<%=Integer.toString(shipmentEntity.getIdShipment())%>">
                    <%=Integer.toString(shipmentEntity.getIdShipment())%>
                </option>
            <%
                    }
                }
            %>
        </select>

        <input type="text" name="sum" placeholder="Введите сумму" title="Введите сумму" value="<%=outlay != null ? outlay.getSumOutlay() : ""%>">

        <button type="submit" name="action" value="add" class="add-button"> Добавить/Изменить </button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>