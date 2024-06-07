import view.LanchoneteView;
import controller.LanchoneteControllerImpl; // Importe a classe LanchoneteController
import model.DatabaseConnection;
public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection(); // Crie uma conexão com o banco de dados
        LanchoneteControllerImpl controller = new LanchoneteControllerImpl(databaseConnection); // Passe a conexão do banco de dados para o controlador
        LanchoneteView lanchonete = new LanchoneteView(controller); // Passe o controlador para o construtor de LanchoneteView
    }
}
