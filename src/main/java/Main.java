import view.LanchoneteView;
import controller.LanchoneteControllerImpl; 
import model.DatabaseConnection;
public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection(); 
        LanchoneteControllerImpl controller = new LanchoneteControllerImpl(databaseConnection); 
        LanchoneteView lanchonete = new LanchoneteView(controller);
    }
}
