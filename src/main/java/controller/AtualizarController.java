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

@WebServlet(urlPatterns = { "/atualizar" })
public class AtualizarController extends HttpServlet {

    DAO dao = new DAO();
    ArrayList<Proposta> propostas = new ArrayList<>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String sobremesa = request.getParameter("sobremesa");
        
        Proposta proposta = new Proposta(nome, quantidade, sobremesa);

        dao.atualizarProposta(proposta, id);

        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
}