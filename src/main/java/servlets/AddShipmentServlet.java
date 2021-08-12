package servlets;

import DAO.ShipmentDAO;
import Entity.ShipmentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addShipment")
public class AddShipmentServlet extends HttpServlet {
    private ShipmentEntity shipment = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shipment = (ShipmentEntity) req.getSession().getAttribute("toEdit");
        if (shipment != null) {
            req.getSession().removeAttribute("toEdit");
        }
        req.setAttribute("shipment", shipment);
        req.getRequestDispatcher("addShipment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (shipment == null) {
            ShipmentEntity newEntity = new ShipmentEntity(req.getParameter("nameShipment"), req.getParameter("typeShipment"),
                    req.getParameter("adressShipment"), req.getParameter("dateShipment"), Integer.parseInt(req.getParameter("productCount")));
            ShipmentDAO.insertShipment(newEntity);
        } else {
            shipment.setNameShipment(req.getParameter("nameShipment"));
            shipment.setTypeShipment(req.getParameter("typeShipment"));
            shipment.setAdressShipment(req.getParameter("adressShipment"));
            shipment.setDateShipment(req.getParameter("dateShipment"));
            shipment.setProductCount(Integer.parseInt(req.getParameter("productCount")));
            ShipmentDAO.updateShipment(shipment);
        }
        resp.sendRedirect(req.getContextPath() + "/shipments");
    }
}
