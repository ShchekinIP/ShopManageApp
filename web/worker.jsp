<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="Entity.WorkerEntity" %>
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
    <li><a href="incomes">Доходы</a></li>
    <li><a href="outlays">Расходы</a></li>
</ul>
<h1 style="text-align: center">Управление работниками</h1>
<h2 class="list-header">Список работников</h2>
<a class="nav-menu-a" href="addWorker" style="margin-left:120px;">Добавить работника</a>
<div class="table-header">
    <div class="column">ФИО</div>
    <div class="column">Номер трудовой</div>
    <div class="column">Тип</div>
    <div class="column">№ Магазина</div>
    <div class="column"></div>
</div>
<%
    List<WorkerEntity> workers = (List<WorkerEntity>) request.getAttribute("workers");
    for (WorkerEntity workerEntity : workers) {
%>
<form id="workers" class="table-list" action="workers" method="POST">
    <input type="text" name="id" value="<%=workerEntity.getIdWorker()%>" readonly hidden>
    <div class="column"><input type="text" name="fio" value="<%=workerEntity.getFioWorker()%>"
                               title="<%=workerEntity.getFioWorker()%>" readonly></div>
    <div class="column"><input type="text" name="employment" value="<%=workerEntity.getEmploymentRecords()%>"
                               title="<%=workerEntity.getEmploymentRecords()%>" readonly></div>
    <div class="column"><input type="text" name="type" value="<%=workerEntity.getTypeWorker()%>"
                               title="<%=workerEntity.getTypeWorker()%>" readonly></div>
    <div class="column"><input type="number" name="shop_id" value="<%=workerEntity.getShopEntity().getIdShop()%>"
                               title="<%=workerEntity.getShopEntity().getIdShop()%>" readonly>

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
