package model;

public class Proposta {
    
    private String nome;
    private String quantidade ;
    private String sobremesa;
    
    public Proposta() {
        super();
    }

    public Proposta(String nome, String quantidade, String sobremesa) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.sobremesa = sobremesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }
    
}
