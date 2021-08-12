<%@ page import="Entity.ShopEntity" %>
<%@ page import="Entity.WorkerEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Income</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
    <script src="script.js" defer></script>
</head>
<body>
<h1 style="text-align: center">Управление работниками</h1>
<h2 class="list-header">Добавить работника</h2>
<div style="text-align: center;">
    <%
        WorkerEntity worker = (WorkerEntity) request.getAttribute("worker");
        {
    %>
    <form class="add-table" action="addWorker" method="POST">
        <input type="text" name="fio" placeholder="Введите ФИО" title="Введите ФИО" value="<%=worker != null ? worker.getFioWorker() : ""%>">
        <input type="text" name="employment" placeholder="Введите номер трудовой" title="Введите номер трудовой" value="<%=worker != null ? worker.getEmploymentRecords() : ""%>">
        <input type="text" name="type" placeholder="Введите тип" title="Введите тип" value="<%=worker != null ? worker.getTypeWorker() : ""%>">

        <span>Выберете магазин:</span>
        <select name="shop_id" title="Выбрать магазин" >
            <%
                List<ShopEntity> shops = (List<ShopEntity>) request.getAttribute("shops");
                for (ShopEntity shopEntity : shops) {
                    if (worker != null && shopEntity.getIdShop() == worker.getShopEntity().getIdShop()) {

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

        <button type="submit" name="action" value="add" class="add-button"> Добавить/Изменить </button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>