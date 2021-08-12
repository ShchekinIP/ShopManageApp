package servlets;

import DAO.ShopDAO;
import Entity.ShopEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addShop")
public class AddShopServlet extends HttpServlet {
    private ShopEntity shop;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shop = (ShopEntity) req.getSession().getAttribute("toEdit");
        if (shop != null) {
            req.getSession().removeAttribute("toEdit");
        }
        req.setAttribute("shop", shop);
        req.getRequestDispatcher("addShop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (shop == null) {
            ShopEntity newEntity = new ShopEntity(req.getParameter("name"), req.getParameter("address"),
                    req.getParameter("type"), Integer.parseInt(req.getParameter("capital")));
            ShopDAO.insertShop(newEntity);
        } else {
            shop.setAdressShop(req.getParameter("address"));
            shop.setNameShop(req.getParameter("name"));
            shop.setCapitalShop(Integer.parseInt(req.getParameter("capital")));
            shop.setTypeShop(req.getParameter("type"));
            ShopDAO.updateShp(shop);
        }
        resp.sendRedirect(req.getContextPath() + "/shop");
    }
}
