package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaAdmController {

    @FXML
    private Button btnVerObjeto;

    @FXML
    private Button btnSolicitacoesAdm;

    @FXML
    private ImageView imageLogOut;

    @FXML
    void handleSolicitacoesAdm(ActionEvent event) {
        AnchorPane e;
        try {
            e = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/telaSolicitacoesAdm.fxml"));
            // this.btnStart.setStyle("-fx-background-color: E6BE40;");
            Stage secondStage = new Stage();
            Scene secondScene = new Scene(e);
            secondStage.setScene(secondScene);
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(TelaAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleVerObjeto(ActionEvent event) {
        AnchorPane f;
        try {
            f = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/telaObjetosAdm.fxml"));
            // this.btnStart.setStyle("-fx-background-color: E6BE40;");
            Stage secondStage = new Stage();
            Scene secondScene = new Scene(f);
            secondStage.setScene(secondScene);
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(TelaAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
