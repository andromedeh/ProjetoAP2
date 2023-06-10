package view;
import controller.SceneManager;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sistema extends Application {
        private SceneManager sceneManager;
        
	@Override
	public void start(Stage primaryStage) throws IOException {
            // Configura o estágio inicial
            sceneManager = new SceneManager(primaryStage);
            sceneManager.switchScene("/fxml/telaInicial.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}