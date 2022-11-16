package model;

public class Proposta {
    
    private String nome;
    private String quantidade ;
    private String sobremesa;
    private String totalPrato;
    private String taxaGarcom;
    private String taxaSobremesa;
    private String precoTotal;
    
    public Proposta() {
        super();
    }
    
    public Proposta(String nome, String quantidade, String sobremesa) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.sobremesa = sobremesa;
        calculateProposta();
    }
    
    public Proposta(String nome, String quantidade, String sobremesa, String totalPrato, String taxaGarcom,
            String taxaSobremesa, String precoTotal) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.sobremesa = sobremesa;
        this.totalPrato = totalPrato;
        this.taxaGarcom = taxaGarcom;
        this.taxaSobremesa = taxaSobremesa;
        this.precoTotal = precoTotal;
    }
    
    public String getTotalPrato() {
        return totalPrato;
    }

    public String getTaxaGarcom() {
        return taxaGarcom;
    }

    public String getTaxaSobremesa() {
        return taxaSobremesa;
    }

    public String getPrecoTotal() {
        return precoTotal;
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
        calculateProposta();
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    public void calculateProposta() {

        double quantidade = Double.parseDouble(getQuantidade());
        double total = 0;
        double dSobremesa = 0;
        double prato = quantidade * 22.90;
        double garcom = Math.ceil(quantidade / 15) * 250;


        total = prato + garcom;

        if (sobremesa == "true") {
            dSobremesa = prato * 0.1;
            total = total + dSobremesa;
        }

        this.totalPrato = String.format("%, .2f", prato);
        this.taxaGarcom = String.format("%,.2f", (garcom));
        this.taxaSobremesa = String.format("%,.2f",dSobremesa);
        this.precoTotal = String.format("%,.2f",total);
    }
    
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nQuantidade: " + getQuantidade() + 
        "\nSobremesa: " + getSobremesa() + "\nTotal Prato: " + getTotalPrato() +
        "\nTaxa Garcom: " + getTaxaGarcom() + "\nTaxa Sobremesa: " + getTaxaSobremesa() +
        "\nPreco Total: " + getPrecoTotal();
    }

}
