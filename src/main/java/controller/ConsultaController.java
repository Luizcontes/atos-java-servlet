package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.Proposta;

@WebServlet(urlPatterns = { "/consultar", "/consulta" })
public class ConsultaController extends HttpServlet {

    DAO dao = new DAO();
    ArrayList<Proposta> propostas = new ArrayList<>();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        propostas = dao.listarPropostas("");

        if ( propostas.size() == 0 ) {
            propostas = null;
        }

        request.setAttribute("propostas", propostas);

        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = request.getParameter("nome");

        propostas = dao.listarPropostas(nome);

        if ( propostas.size() == 0 ) {
            propostas = null;
        }

        request.setAttribute("propostas", propostas);

        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
}
