package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DAO;
import model.Proposta;

@WebServlet(urlPatterns = { "/cadastro", "/cadastrar" })
public class CadastroController extends HttpServlet {

    Proposta proposta;
    DAO dao = new DAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = "";
        String quantidade = "";
        String sobremesa = "";

        try {
            nome = request.getParameter("nome");
            quantidade = request.getParameter("quantidade");
            sobremesa = request.getParameter("sobremesa");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println("Nome: " + nome + "\nQuantidade: " + quantidade +
        // "\nSobremesa: " + sobremesa);

        proposta = new Proposta(nome, quantidade, "nao");

        if (sobremesa != null) {
            proposta.setSobremesa("sim");
        }

        dao.inserirContato(proposta);

        request.setAttribute("proposta", proposta);

        request.getRequestDispatcher("/relatorio").forward(request, response);
    }
}
