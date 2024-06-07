package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/lanchonete";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public DatabaseConnection() {
        try {
            // Estabelece a conexão com o banco de dados no construtor
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Lanche (" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "preco double NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Refrigerante (" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "preco double NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Sobremesa (" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "preco double NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Pedido (" +
                    "id int AUTO_INCREMENT PRIMARY KEY," +
                    "lanche_id int NOT NULL," +
                    "refrigerante_id int NOT NULL," +
                    "sobremesa_id int NOT NULL," +
                    "numero_pedido int NOT NULL," +
                    "FOREIGN KEY (lanche_id) REFERENCES Lanche(id)," +
                    "FOREIGN KEY (refrigerante_id) REFERENCES Refrigerante(id)," +
                    "FOREIGN KEY (sobremesa_id) REFERENCES Sobremesa(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tabelas criadas com sucesso!!");
    }

    public void salvarLanche(String lanche, double preco) {
        // Lógica para salvar o lanche no banco de dados
        try {
            String sql = "INSERT INTO Lanche (nome, preco) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lanche);
            statement.setDouble(2, preco);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarRefrigerante(String refrigerante, double preco) {
        // Lógica para salvar o refrigerante no banco de dados
        try {
            String sql = "INSERT INTO Refrigerante (nome, preco) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, refrigerante);
            statement.setDouble(2, preco);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarSobremesa(String sobremesa, double preco) {
        // Lógica para salvar a sobremesa no banco de dados
        try {
            String sql = "INSERT INTO Sobremesa (nome, preco) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sobremesa);
            statement.setDouble(2, preco);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

