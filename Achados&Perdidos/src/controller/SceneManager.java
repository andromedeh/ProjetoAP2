package controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {
    private Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Obtém o controlador associado à nova cena e define o gerenciador de cena como seu proprietário
            BaseController controller = loader.getController();
            controller.setSceneManager(this);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getStage(){
      return stage;
    }
}
