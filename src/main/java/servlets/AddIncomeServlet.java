package servlets;

import DAO.IncomeDAO;
import DAO.ShopDAO;
import Entity.IncomeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addIncome")
public class AddIncomeServlet extends HttpServlet {
    private IncomeEntity incomeEntity;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        incomeEntity = (IncomeEntity) req.getSession().getAttribute("toEdit");
        if (incomeEntity != null) {
            req.getSession().removeAttribute("toEdit");
        }
        req.setAttribute("incomeEntity", incomeEntity);
        req.setAttribute("shops", ShopDAO.selectShops());
        req.getRequestDispatcher("addIncome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (incomeEntity == null) {
            IncomeEntity newEntity = new IncomeEntity(req.getParameter("type"), req.getParameter("date"), Integer.parseInt(req.getParameter("sum")));
            IncomeDAO.insertIncome(Integer.parseInt(req.getParameter("shop_id")), newEntity);

        } else {
            incomeEntity.setTypeIncome(req.getParameter("type"));
            incomeEntity.setDateIncome(req.getParameter("date"));
            incomeEntity.setSumIncome(Integer.parseInt(req.getParameter("sum")));
            incomeEntity.setShopEntity(ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))));
            IncomeDAO.updateIncome(incomeEntity);
        }
        resp.sendRedirect(req.getContextPath() + "/incomes");
    }
}
