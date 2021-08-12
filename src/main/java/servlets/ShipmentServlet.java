package servlets;

import DAO.ShipmentDAO;
import Entity.ShipmentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/shipments")
public class ShipmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShipmentEntity> shipmentEntities = ShipmentDAO.selectShipments();
        shipmentEntities.sort(Comparator.comparing(ShipmentEntity::getIdShipment));
        req.setAttribute("shipments", shipmentEntities);
        req.getRequestDispatcher("shipment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "edit": {
                ShipmentEntity shipmentEntity = new ShipmentEntity(Integer.parseInt(req.getParameter("idShipment")),
                        req.getParameter("nameShipment"), req.getParameter("typeShipment"),
                        req.getParameter("adressShipment"), req.getParameter("dateShipment"),
                        Integer.parseInt(req.getParameter("productCount")));
                req.getSession().setAttribute("toEdit", shipmentEntity);
                resp.sendRedirect(req.getContextPath() + "/addShipment");
                break;
            }
            case "delete": {
                ShipmentDAO.deleteShipment(Integer.parseInt(req.getParameter("idShipment")));
                req.setAttribute("shipments", ShipmentDAO.selectShipments());
                req.getRequestDispatcher("shipment.jsp").forward(req, resp);
                break;
            }
        }
    }
}
