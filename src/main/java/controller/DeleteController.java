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

@WebServlet(urlPatterns = { "/deletar" })
public class DeleteController extends HttpServlet {

    DAO dao = new DAO();
    ArrayList<Proposta> propostas = new ArrayList<>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        dao.deletarContato(id);

        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
}