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
import java.util.Comparator;
import java.util.List;

@WebServlet("/incomes")
public class IncomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<IncomeEntity> incomeEntities = IncomeDAO.selectIncomes();
        incomeEntities.sort(Comparator.comparing(IncomeEntity::getIdIncome));
        req.setAttribute("incomes", incomeEntities);
        req.setAttribute("shops", ShopDAO.selectShops());
        req.getRequestDispatcher("income.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {

            case "edit": {
                IncomeEntity incomeEntity = new IncomeEntity(Integer.parseInt(req.getParameter("id")), req.getParameter("type"),
                        req.getParameter("date"), Integer.parseInt(req.getParameter("sum")),
                        ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))));
                req.getSession().setAttribute("toEdit", incomeEntity);
                resp.sendRedirect(req.getContextPath() + "/addIncome");
                break;
            }
            case "delete": {
                IncomeDAO.deleteIncome(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("incomes", IncomeDAO.selectIncomes());
                req.getRequestDispatcher("income.jsp").forward(req, resp);
                break;
            }
        }
    }
}

