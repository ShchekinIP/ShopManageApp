<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.IncomeEntity" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<ul>
    <li><a href="shop">Магазин</a></li>
    <li><a href="shipments">Поставки</a></li>
    <li><a href="workers">Работники</a></li>
    <li><a href="outlays">Расходы</a></li>
</ul>
<h1 style="text-align: center">Управление доходами</h1>
<h2 class="list-header">Работа с существующими записями</h2>
<a class="nav-menu-a" href="addIncome" style="margin-left:120px;">Добавить доход</a>
<div class="table-header">
    <div class="column">Тип</div>
    <div class="column">Дата</div>
    <div class="column">Сумма</div>
    <div class="column">№ Магазина</div>
    <div class="column"></div>
</div>
<%
    List<IncomeEntity> incomes = (List<IncomeEntity>) request.getAttribute("incomes");
    for (IncomeEntity incomeEntity : incomes) {
%>
<form id="incomes" class="table-list" action="incomes" method="POST">
    <input type="text" name="id" value="<%=incomeEntity.getIdIncome()%>" readonly hidden>
    <div class="column"><input type="text" name="type" value="<%=incomeEntity.getTypeIncome()%>"
                               title="<%=incomeEntity.getTypeIncome()%>" readonly></div>
    <div class="column"><input type="text" name="date" value="<%=incomeEntity.getDateIncome()%>"
                               title="<%=incomeEntity.getDateIncome()%>" readonly></div>
    <div class="column"><input type="number" name="sum" value="<%=incomeEntity.getSumIncome()%>"
                               title="<%=incomeEntity.getSumIncome()%>" readonly></div>
    <div class="column"><input type="number" name="shop_id" value="<%=incomeEntity.getShopEntity().getIdShop()%>"
                               title="<%=incomeEntity.getShopEntity().getIdShop()%>" readonly>
    </div>
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
