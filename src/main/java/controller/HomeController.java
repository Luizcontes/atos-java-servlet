package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(urlPatterns = {  })
public class HomeController extends HttpServlet {

    DAO dao = new DAO();

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("home");

        request.getRequestDispatcher("home.jsp").forward(request, response);
        // PrintWriter writer = response.getWriter();
        // writer.println("<p>HomeController</p>");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // processRequest(request, response);
        
        System.out.println("aqui");

        // if (request.getServletPath() == "/consulta") {
        //     request.getRequestDispatcher("consulta.jsp").forward(request, response);
        // } else if (request.getServletPath() == "/cadastro") {
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        // }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
