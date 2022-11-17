package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.Proposta;

@WebServlet(urlPatterns = { "/relatorio" })
public class RelatorioController extends HttpServlet {

    DAO dao = new DAO();
    ArrayList<Proposta> propostas = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Proposta proposta = dao.getContato(id);

        request.setAttribute("proposta", proposta);
        generateReport(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateReport(request, response);
    }

    public void generateReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Document document = new Document();
        Proposta proposta = (Proposta) request.getAttribute("proposta");

        try {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=" + "proposta.pdf");
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            String filename = "/home/luiz/Estudos/atos-java-servlet/src/main/webapp/assets/img/logo1.jpg";
            Image image = Image.getInstance(filename);
            document.add(image);

            document.add(new Paragraph("Proposta Comercial"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(2);
            PdfPCell headerCell = new PdfPCell(new Phrase("DADOS DA PROPOSTA"));
            table.setWidths(new int[] { 2, 5 });
            headerCell.setRowspan(1);
            headerCell.setColspan(2);
            table.addCell(headerCell);

            table.addCell("Nome");
            table.addCell(proposta.getNome());
            table.addCell("Convidados");
            table.addCell(proposta.getQuantidade());
            table.addCell("Sobremesa");
            table.addCell(proposta.getSobremesa());
            table.addCell("Valor Prato");
            table.addCell("R$" + proposta.getTotalPrato());
            table.addCell("Valor Garcom");
            table.addCell("R$" + proposta.getTaxaGarcom());
            table.addCell("Valor da Sobremesa");
            table.addCell("R$" + proposta.getTaxaSobremesa());
            table.addCell("Valor Total");
            table.addCell("R$" + proposta.getPrecoTotal());

            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
            document.close();
        }

        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
}