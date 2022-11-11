package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;

// @WebServlet("/home")
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
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
