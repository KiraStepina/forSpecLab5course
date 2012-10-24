package presentation;

import bussiness.Cache.UoW;
import bussiness.Cache.UoWImpl;
import bussiness.Client;
import presentation.forFilters.FilterManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 29.9.12
 * Time: 12.05
 */
public class SimpleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        FilterManager filterManager = new FilterManager();
        if (!filterManager.callFilters(request)) {
            response.sendRedirect("/forms/error.jsp");
            request.getSession().setAttribute("client", null);
            request.getSession().setAttribute("step", null);
        } else this.process(request, response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setStatus(200);
        //response.setContentType("text/html");
        HttpSession session = request.getSession();
        String step = (String) session.getAttribute("step");
        /* ClientList clientList = new ClientList();
        if (session.getAttribute("clientList") == null) {
            session.setAttribute("clientList", clientList);
        } else {
            clientList = (ClientList) session.getAttribute("clientList");
        }*/
        UoW unityOfWork = (UoW) session.getAttribute("unity");
        if (unityOfWork == null) {
            session.setAttribute("unity", new UoWImpl());
            unityOfWork = (UoW) session.getAttribute("unity");
        }
        if (step == null) {
            Client client = new Client();
            client.setName(request.getParameter("name"));
            response.sendRedirect("/forms/form2.jsp");
            session.setAttribute("client", client);
            session.setAttribute("step", "1");
            return;
        }
        int label = Integer.parseInt(step);
        Client client = (Client) session.getAttribute("client");
        switch (label) {
            case 1:
                client.setAddress(request.getParameter("address"));
                response.sendRedirect("/forms/form3.jsp");
                session.setAttribute("client", client);
                session.setAttribute("step", "2");
                return;
            case 2:
                client.setTelephone(request.getParameter("telephone"));
                unityOfWork.create(client);
                unityOfWork.commit();
                response.sendRedirect("list");
                session.setAttribute("client", null);
                session.setAttribute("step", null);
        }

    }
}
