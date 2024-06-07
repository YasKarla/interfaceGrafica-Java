package model;

public class Pedido {
    //declaracao das variaveis
    private int lancheId;
    private int refrigeranteId;
    private int sobremesaId;
    private int numeroPedido;

    //construtor
    public Pedido(){}

    //getter e setter
    public int getLancheId() {
        return lancheId;
    }
    public void setLancheId(int lancheId) {
        this.lancheId = lancheId;
    }
    public int getRefrigeranteId() {
        return refrigeranteId;
    }
    public void setRefrigeranteId(int refrigeranteId) {
        this.refrigeranteId = refrigeranteId;
    }
    public int getSobremesaId() {
        return sobremesaId;
    }
    public void setSobremesaId(int sobremesaId) {
        this.sobremesaId = sobremesaId;
    }
    public int getNumeroPedido() {
        return numeroPedido;
    }
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    // Construtores, getters e setters
}
