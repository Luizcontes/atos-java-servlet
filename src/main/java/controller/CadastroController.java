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

@WebServlet(urlPatterns = { "/cadastrar", "/cadastro" })
public class CadastroController extends HttpServlet {

    Proposta proposta;
    DAO dao = new DAO();

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parameter = request.getServletPath();

        if (parameter == "/cadastro") {

            request.getRequestDispatcher("cadastro.jsp").forward(request, response);

        }

        else if (parameter == "/cadastrar") {

            ArrayList<String> params = new ArrayList<>();

            String reader = request.getReader().lines().collect(Collectors.joining());

            System.out.println(reader);

            String[] attributes = reader.split("&", 0);

            System.out.println(attributes.length);

            String[] temp;
            for (String str : attributes) {
                temp = str.split("=", 0);
                params.add(temp[1]);
            }

            if (params.size() == 3) {
                proposta = new Proposta(params.get(0), params.get(1), "true");
            } else if (params.size() == 2) {
                proposta = new Proposta(params.get(0), params.get(1), "false");
            }

            dao.inserirContato(proposta);

            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getServletPath();

        if (parameter == "/cadastro") {

            request.getRequestDispatcher("consulta").forward(request, response);

        }
        // processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getServletPath();

        if (parameter == "/cadastrar") {

            ArrayList<String> params = new ArrayList<>();

            String reader = request.getReader().lines().collect(Collectors.joining());

            System.out.println(reader);

            String[] attributes = reader.split("&", 0);

            System.out.println(attributes.length);

            String[] temp;
            for (String str : attributes) {
                temp = str.split("=", 0);
                params.add(temp[1]);
            }

            if (params.size() == 3) {
                proposta = new Proposta(params.get(0), params.get(1), "true");
            } else if (params.size() == 2) {
                proposta = new Proposta(params.get(0), params.get(1), "false");
            }

            dao.inserirContato(proposta);

            request.getRequestDispatcher("cadastro").forward(request, response);
        }
        // processRequest(request, response);
    }
}
