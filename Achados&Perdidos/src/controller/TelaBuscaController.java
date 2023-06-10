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
import javafx.scene.control.TextField;

public class TelaBuscaController implements Initializable{

    @FXML
    private TextField barraPesquisa;

    @FXML
    private AnchorPane AnchorPaneBusca;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.print("hihi foi");
    }


}
