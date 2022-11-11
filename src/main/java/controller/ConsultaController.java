package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.Proposta;


@WebServlet(urlPatterns = {"/consulta", "/consultar"})
public class ConsultaController extends HttpServlet{
    
    DAO dao = new DAO();
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArrayList<String> params = new ArrayList<>();
        
        // String reader = request.getReader().lines().collect(Collectors.joining());
        // String[] attributes = reader.split("&", 0);    
        
        // for(String a : attributes) {
        //     String[] temp = a.split("=", 0);
        //     params.add(temp[1]);
        // }
        
        // ArrayList<Proposta> propostas = dao.listarPropostas(params.get(1));
        ArrayList<Proposta> propostas = dao.listarPropostas("Luiz");

        for (Proposta proposta : propostas) {
            System.out.println(proposta);
            System.out.println("----------");
        }

        // request.getRequestDispatcher("consulta.jsp").forward(request, response);
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
