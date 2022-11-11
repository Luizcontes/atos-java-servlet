package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Proposta;


@WebServlet(urlPatterns = "/cadastrar")
public class CadastroController extends HttpServlet{
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);

        retornarAgenda(request, response);

        // response.getWriter().write("cu do macaco!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);        
    }

    
    public void retornarAgenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("cadastro.jsp");
    }
    
    
}
