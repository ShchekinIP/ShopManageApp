package servlets;

import DAO.IncomeDAO;
import DAO.ShopDAO;
import DAO.WorkerDAO;
import Entity.IncomeEntity;
import Entity.ShopEntity;
import Entity.WorkerEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/workers")
public class WorkerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<WorkerEntity> workerEntities = WorkerDAO.selectWorkers();
        workerEntities.sort(Comparator.comparing(WorkerEntity::getIdWorker));
        req.setAttribute("workers", workerEntities);
        req.setAttribute("shops", ShopDAO.selectShops());
        req.getRequestDispatcher("worker.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "edit":{
                WorkerEntity workerEntity = new WorkerEntity(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("fio"), req.getParameter("employment"), req.getParameter("type"),
                        ShopDAO.findById(Integer.parseInt(req.getParameter("shop_id"))));
                req.getSession().setAttribute("toEdit", workerEntity);
                resp.sendRedirect(req.getContextPath() + "/addWorker");
                break;
            }
            case "delete": {
                WorkerDAO.deleteWorker(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("workers", WorkerDAO.selectWorkers());
                req.getRequestDispatcher("worker.jsp").forward(req, resp);
                break;
            }


        }
    }

}
