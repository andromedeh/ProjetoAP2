package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TelaUsuarioController implements Initializable{

    @FXML
    private AnchorPane AnchorPaneUsuario;

    @FXML
    private Button btnNotificarObjeto;

    @FXML
    private Button btnProcurarObjeto;

    @FXML
    private Button btnSolicitacoes;

    @FXML
    private ImageView imageLogOut;

    public void OpBuscarObjeto(ActionEvent event) throws Exception{ // Usei o modo antigo pra poder servir como um "pop-up"
        AnchorPane a;
        try {
            System.out.print("Entrou");
            a = (AnchorPane)FXMLLoader.load(getClass().getResource("/fxml/telaBusca.fxml"));
            Stage stage  = new Stage();
            Scene secondScene = new Scene(a);
            stage.setScene(secondScene);
            stage.setResizable(true);
            stage.show();
            System.out.print("Saiu");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
