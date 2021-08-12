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

@WebServlet("/addOutlay")
public class AddOutlayServlet extends HttpServlet {
    private OutlayEntity outlay;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outlay = (OutlayEntity) req.getSession().getAttribute("toEdit");
        if (outlay != null) {
            req.getSession().removeAttribute("toEdit");
        }
        req.setAttribute("outlay", outlay);
        req.setAttribute("shops", ShopDAO.selectShops());
        req.setAttribute("shipments", ShipmentDAO.selectShipments());
        req.getRequestDispatcher("addOutlay.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (outlay == null) {
            OutlayEntity newEntity = new OutlayEntity(Integer.parseInt(req.getParameter("sum")), req.getParameter("date"),
                    ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))),
                    ShipmentDAO.findById(Integer.parseInt(req.getParameter("shipment_id"))));
            OutlayDAO.insertOutlay(Integer.parseInt(req.getParameter("shop_id")), Integer.parseInt(req.getParameter("shipment_id")),  newEntity);
        } else {
            outlay.setSumOutlay(Integer.parseInt(req.getParameter("sum")));
            outlay.setDateOutlay(req.getParameter("date"));
            outlay.setShipmentEntity(ShipmentDAO.findById(Integer.parseInt(req.getParameter("shipment_id"))));
            outlay.setShopEntity(ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))));
            OutlayDAO.updateOutlay(outlay);
        }
        resp.sendRedirect(req.getContextPath() + "/outlays");
    }
}
