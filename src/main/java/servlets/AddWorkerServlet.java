package servlets;

import DAO.WorkerDAO;
import DAO.ShopDAO;
import Entity.WorkerEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addWorker")
public class AddWorkerServlet extends HttpServlet {
    private WorkerEntity worker;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        worker = (WorkerEntity) req.getSession().getAttribute("toEdit");
        if (worker != null) {
            req.getSession().removeAttribute("toEdit");
        }
        req.setAttribute("worker", worker);
        req.setAttribute("shops", ShopDAO.selectShops());
        req.getRequestDispatcher("addWorker.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (worker == null) {
            WorkerEntity workerEntity = new WorkerEntity(req.getParameter("fio"), req.getParameter("employment"), req.getParameter("type"));
            WorkerDAO.insertWorker(Integer.parseInt(req.getParameter("shop_id")), workerEntity);
        } else {
            worker.setFioWorker(req.getParameter("fio"));
            worker.setEmploymentRecords(req.getParameter("employment"));
            worker.setTypeWorker(req.getParameter("type"));
            worker.setShopEntity(ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))));
            WorkerDAO.updateWorker(worker);
        }
        resp.sendRedirect(req.getContextPath() + "/workers");
    }
}
