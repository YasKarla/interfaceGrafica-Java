package controller;

import model.DatabaseConnection;

public class LanchoneteControllerImpl{
    private DatabaseConnection model;

    public LanchoneteControllerImpl(DatabaseConnection model) {
        this.model = model;
    }

    public void lancheSelecionado(String lanche, double preco) {
        model.salvarLanche(lanche, preco);
    }

    public void refrigeranteSelecionado(String refrigerante, double preco) {
        model.salvarRefrigerante(refrigerante, preco);
    }

    public void sobremesaSelecionada(String sobremesa, double preco) {
        model.salvarSobremesa(sobremesa, preco);
    }
}
