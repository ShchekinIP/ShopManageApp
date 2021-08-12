<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.OutlayEntity" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<ul>
    <li><a href="shop">Магазин</a></li>
    <li><a href="workers">Работники</a></li>
    <li><a href="incomes">Доходы</a></li>
    <li><a href="shipments">Поставки</a></li>
</ul>
<h1 style="text-align: center">Управление расходами</h1>

<h2 class="list-header">Список расходов</h2>
<a class="nav-menu-a" href="addOutlay" style="margin-left:120px;">Добавить расход</a>
<div class="table-header">
    <div class="column">Номер</div>
    <div class="column">Дата</div>
    <div class="column">Магазин</div>
    <div class="column">Поставка</div>
    <div class="column">Сумма</div>
    <div class="column"></div>
</div>
<%
    List<OutlayEntity> outlays = (List<OutlayEntity>) request.getAttribute("outlays");
    for (OutlayEntity outlay : outlays) {
%>
<form id="outlays" class="table-list" action="outlays" method="POST">
    <div class="column"><input type="text" name="id" value="<%=outlay.getIdOutlay()%>"
                               title="<%=outlay.getIdOutlay()%>" readonly></div>
    <div class="column"><input type="text" name="date" value="<%=outlay.getDateOutlay()%>"
                               title="<%=outlay.getDateOutlay()%>"></div>
    <div class="column"><input type="text" name="shop_id" value="<%=outlay.getShopEntity().getIdShop()%>"
                               title="<%=outlay.getShopEntity().getIdShop()%>"></div>
    <div class="column"><input type="text" name="shipment_id" value="<%=outlay.getShipmentEntity().getIdShipment()%>"
                               title="<%=outlay.getShipmentEntity().getIdShipment()%>"></div>
    <div class="column"><input type="number" name="sum" value="<%=outlay.getSumOutlay()%>"
                               title="<%=outlay.getSumOutlay()%>"></div>
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
