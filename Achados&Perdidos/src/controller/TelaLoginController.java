package controller;

import controller.ControleUsuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaLoginController {
    
    @FXML
    private AnchorPane anchorPaneLogin;
    
    @FXML
    private TextField campoCPF;
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private Button btnIrCadastrar;
    
    @FXML
    private Button btnLogIn;
    
    private ControleUsuario cUser = new ControleUsuario();
    
    public void handleBtnIrCadastrar(ActionEvent event){
        AnchorPane a;
        try {
            a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaCadastro.fxml"));
            Stage stage  = new Stage();
            Scene scene = new Scene(a);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();
   
        } catch (IOException ex) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handleLogIn(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        long cpf = Long.parseLong(campoCPF.getText());
        String senha = campoSenha.getText();
        if (cUser.loginUsuario(cpf, senha)){
            AnchorPane a;
            try {
                a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaUsuario.fxml"));
                Stage stage  = new Stage();
                Scene scene = new Scene(a);
                stage.setScene(scene);
                stage.setResizable(true);
                stage.show();
                anchorPaneLogin.getScene().getWindow().hide();
                
            } catch (IOException ex) {
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else{
            campoSenha.setPromptText("digite novamente");
            campoCPF.setPromptText("digite novamente");
            campoSenha.clear();
            campoCPF.clear();
        }
    }
}
