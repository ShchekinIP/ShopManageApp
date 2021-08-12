package servlets;

import DAO.OutlayDAO;
import DAO.ShipmentDAO;
import DAO.ShopDAO;
import Entity.OutlayEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/outlays")
public class OutlayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("outlays", OutlayDAO.selectOutlays());
        req.getRequestDispatcher("outlay.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "edit": {
                OutlayEntity outlay = new OutlayEntity(Integer.parseInt(req.getParameter("id")),
                        Integer.parseInt(req.getParameter("sum")),
                        req.getParameter("date"), ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))),
                        ShipmentDAO.findById(Integer.parseInt(req.getParameter("shipment_id"))));
                req.getSession().setAttribute("toEdit", outlay);
                resp.sendRedirect(req.getContextPath() + "/addOutlay");
                break;
            }

            case "delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                OutlayDAO.deleteOutlay(id);
                req.setAttribute("outlays", OutlayDAO.selectOutlays());
                req.getRequestDispatcher("outlay.jsp").forward(req, resp);
                break;
            }

        }
    }
}


