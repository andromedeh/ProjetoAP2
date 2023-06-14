package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
   
    @FXML
    private AnchorPane anchorPaneLoginAdm;

    @FXML
    private Button btnLogInAdm;
    
    @FXML
    private Button btnGoBack;

    @FXML
    private PasswordField campoSenhaAdm;
    
    @FXML
    private Label labelStatus;

    private ControleUsuario cUser = new ControleUsuario();
    
    private Administrador Adm = new Administrador();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    } 
    
    public void handleBtnIrCadastrar(ActionEvent event){
        sceneManager.switchScene("/fxml/telaCadastro.fxml");
    }
    
    public void handleLogIn(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        long cpf = Long.parseLong(campoCPF.getText());
        String senha = campoSenha.getText();
        if (cUser.loginUsuario(cpf, senha)){
            setLoginInstanciado(cUser.procurarUsuario(cpf).getNome());
            sceneManager.switchScene("/fxml/telaUsuario.fxml");

        } else{
            labelStatus.setText("CPF ou senha incorretos, digite novamente!");
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
            labelStatus.setText("Senha incorreta, digite novamente!");
            campoSenhaAdm.setPromptText("digite novamente");
            campoSenhaAdm.clear();
        }
    }

    public void GoBack(ActionEvent event){
        sceneManager.switchScene("/fxml/telaSelecao.fxml");
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
