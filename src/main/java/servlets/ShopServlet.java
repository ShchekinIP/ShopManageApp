package servlets;

import DAO.ShopDAO;
import Entity.ShopEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShopEntity> shopEntities = ShopDAO.selectShops();
        shopEntities.sort(Comparator.comparing(ShopEntity::getIdShop));
        req.setAttribute("shops", shopEntities);
        req.getRequestDispatcher("Shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "edit": {
                req.getSession().setAttribute("toEdit", new ShopEntity(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"), req.getParameter("address"),
                        req.getParameter("type"), Integer.parseInt(req.getParameter("capital"))));
                resp.sendRedirect(req.getContextPath() + "/addShop");
                break;
            }
            case "delete": {
                ShopDAO.deleteShop(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("shops", ShopDAO.selectShops());
                req.getRequestDispatcher("Shop.jsp").forward(req, resp);
                break;
            }
        }
    }
}
