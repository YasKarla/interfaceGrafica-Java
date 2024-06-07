package controller;

import model.DatabaseConnection;

public class LanchoneteControllerImpl{
    private DatabaseConnection model;

    public LanchoneteControllerImpl(DatabaseConnection model) {
        this.model = model;
    }

    public void lancheSelecionado(String lanche, double preco) {
        // Lógica para lidar com o lanche selecionado
        // Por exemplo, salvar os dados no banco de dados
        model.salvarLanche(lanche, preco);
    }

    public void refrigeranteSelecionado(String refrigerante, double preco) {
        // Lógica para lidar com o refrigerante selecionado
        // Por exemplo, salvar os dados no banco de dados
        model.salvarRefrigerante(refrigerante, preco);
    }

    public void sobremesaSelecionada(String sobremesa, double preco) {
        // Lógica para lidar com a sobremesa selecionada
        // Por exemplo, salvar os dados no banco de dados
        model.salvarSobremesa(sobremesa, preco);
    }
}
