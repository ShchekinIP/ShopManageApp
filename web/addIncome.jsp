<%@ page import="Entity.ShopEntity" %>
<%@ page import="Entity.IncomeEntity" %>
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
<h1 style="text-align: center">Управление доходами</h1>
<h2 class="list-header">Добавить доход</h2>
<div style="text-align: center;">
    <%
        IncomeEntity income = (IncomeEntity) request.getAttribute("incomeEntity");
        {
    %>
    <form class="add-table" action="addIncome" method="POST">
        <input type="text" name="type" placeholder="Введите тип" title="Введите тип"
               value="<%=income != null ? income.getTypeIncome() : ""%>">
        <input type="date" class="datapicker" name="date" id="date"
               value="<%=income != null ? income.getDateIncome() : "Введите дату"%>">
        <input type="number" name="sum" placeholder="Введите сумму" title="Введите сумму"
               value="<%=income != null ? income.getSumIncome() : ""%>">

        <span>Выберете магазин:</span>
        <select name="shop_id" title="Выбрать магазин">
            <%
                List<ShopEntity> shops = (List<ShopEntity>) request.getAttribute("shops");
                for (ShopEntity shopEntity : shops) {
                    if (income != null && shopEntity.getIdShop() == income.getShopEntity().getIdShop()) {
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

        <button type="submit" name="action" value="add" class="add-button"> Добавить/Изменить</button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>