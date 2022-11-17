package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    // Parametros de conexao
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/atos_java_servlet?useTimezone=true&serverTimezone=UTC";
    private String user = "teste";
    private String password = "5noSRIdmm@";

    // Metodo de conexao
    private Connection conectar() {

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void inserirContato(Proposta proposta) {
        String query = "INSERT INTO propostas(nome, quantidade, sobremesa, totalPrato, taxaGarcom, taxaSobremesa, precoTotal) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection con = conectar();
            PreparedStatement prepared = con.prepareStatement(query);
            prepared.setString(1, proposta.getNome());
            prepared.setString(2, proposta.getQuantidade());
            prepared.setString(3, proposta.getSobremesa());
            prepared.setString(4, proposta.getTotalPrato());
            prepared.setString(5, proposta.getTaxaGarcom());
            prepared.setString(6, proposta.getTaxaSobremesa());
            prepared.setString(7, proposta.getPrecoTotal());
            prepared.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Proposta getContato(String id) {
        String query = "SELECT * FROM propostas WHERE id = ?;";

        try {
            Connection con = conectar();
            PreparedStatement prepared = con.prepareStatement(query);
            prepared.setString(1, id);
            ResultSet result = prepared.executeQuery();

            result.next();
            String nome = result.getString(2);
            String quantidade = result.getString(3);
            String sobremesa = result.getString(4);

            Proposta proposta = new Proposta(nome, quantidade, sobremesa);
            con.close();
            return proposta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletarContato(String id) {
        String query = "DELETE FROM propostas WHERE id = ?";

        try {
            Connection con = conectar();
            PreparedStatement prepared = con.prepareStatement(query);
            prepared.setString(1, id);
            prepared.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarProposta(Proposta proposta, String id) {
        String query = "UPDATE propostas SET nome= ?, quantidade= ?, sobremesa= ?, totalPrato= ?, taxaGarcom= ?, taxaSobremesa= ?, precoTotal= ? WHERE id = ?";

        try {
            Connection con = conectar();
            PreparedStatement prepared = con.prepareStatement(query);
            prepared.setString(1, proposta.getNome());
            prepared.setString(2, proposta.getQuantidade());
            prepared.setString(3, proposta.getSobremesa());
            prepared.setString(4, proposta.getTotalPrato());
            prepared.setString(5, proposta.getTaxaGarcom());
            prepared.setString(6, proposta.getTaxaSobremesa());
            prepared.setString(7, proposta.getPrecoTotal());
            prepared.setString(8, id);
            prepared.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Proposta> listarPropostas(String str) {

        ArrayList<Proposta> propostas = new ArrayList<>();

        String query = "SELECT * FROM propostas WHERE nome LIKE ?;";

        try {
            Connection con = conectar();
            PreparedStatement prepared = con.prepareStatement(query);
            prepared.setString(1, "%" + str + "%");
            ResultSet result = prepared.executeQuery();

            while (result.next()) {

                String id = result.getString(1);
                String nome = result.getString(2);
                String quantidade = result.getString(3);
                String sobremesa = result.getString(4);
                String totalPrato = result.getString(5);
                String taxaGarcom = result.getString(6);
                String taxaSobremesa = result.getString(7);
                String precoTotal = result.getString(8);

                propostas.add(new Proposta(id, nome, quantidade, sobremesa, totalPrato, taxaGarcom, taxaSobremesa,
                        precoTotal));
            }
            con.close();
            return propostas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
