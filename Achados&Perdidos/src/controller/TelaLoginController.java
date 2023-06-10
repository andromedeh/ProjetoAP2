package controller;

import controller.ControleUsuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import model.Administrador;

public class TelaLoginController extends BaseController implements Initializable {
    
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
    
        //Adm

    @FXML
    private AnchorPane anchorPaneLoginAdm;

    @FXML
    private Button btnLogInAdm;

    @FXML
    private PasswordField campoSenhaAdm;

    private ControleUsuario cUser = new ControleUsuario();
    private Administrador Adm = new Administrador();
    
    public void handleBtnIrCadastrar(ActionEvent event){
        sceneManager.switchScene("/fxml/telaCadastro.fxml");
    }
    
    public void handleLogIn(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        long cpf = Long.parseLong(campoCPF.getText());
        String senha = campoSenha.getText();
        if (cUser.loginUsuario(cpf, senha)){
            sceneManager.switchScene("/fxml/telaUsuario.fxml");

        } else{
            campoSenha.setPromptText("digite novamente");
            campoCPF.setPromptText("digite novamente");
            campoSenha.clear();
            campoCPF.clear();
        }
    }

    public void handleLogInAdm(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        String senha = campoSenhaAdm.getText();
        if (senha.contentEquals(Adm.getSenha())){
            sceneManager.switchScene("/fxml/telaAdm.fxml");
        } else{
            campoSenhaAdm.setPromptText("digite novamente");
            campoSenhaAdm.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    } 
    
    void limparCampos() {
        if(this.campoSenhaAdm == null){
            campoSenha.setText("");
            campoCPF.setText("");
        }else{
            campoSenhaAdm.setText("");
        }
    }
}
