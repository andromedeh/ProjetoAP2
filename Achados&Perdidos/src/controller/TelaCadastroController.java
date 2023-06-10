package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import controller.ControleUsuario;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastroController extends BaseController implements Initializable {
    @FXML
    private AnchorPane anchorPaneCadastro;
    @FXML
    private Button btnConfirmaCadastro;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoSenha;
    @FXML
    private TextField campoNumero;
    @FXML
    private TextField campoEndereco;
    @FXML
    private Label labelStatus;
    
    private ControleUsuario cUser = new ControleUsuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    } 
    
    public void handleBtnConfirmaCadastro(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        String nome = campoNome.getText();
        long cpf, numero;
        if(campoCPF.getText().isEmpty()){
            cpf = 0;
        }else{
            cpf = Long.parseLong(campoCPF.getText());
        }
        if(campoNumero.getText().isEmpty()){
            numero = 0;
        }else{
            numero = Long.parseLong(campoNumero.getText());
        }
        String email = campoEmail.getText();
        String senha = campoSenha.getText();
        String endereco = campoEndereco.getText();
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || endereco.isEmpty() || campoCPF.getText().isEmpty() || campoNumero.getText().isEmpty()){
            labelStatus.setText("Preencha todos os campo!");
        } else{
            if (cUser.procurarUsuario(cpf) != null){
                labelStatus.setText("CPF já cadastrado!");
                campoCPF.setText("");
                }   
            else{
                cUser.cadastrarUsuario(email, senha, nome, cpf, numero, endereco);
                labelStatus.setText("Cadastro realizado!");
                limparCampos();
                sceneManager.getStage().close();
                sceneManager.switchScene("/fxml/telaLogin.fxml");
            }
        }
    }
    
    void limparCampos() {
        campoNome.setText("");
        campoSenha.setText("");
        campoEmail.setText("");
        campoNumero.setText("");
        campoCPF.setText("");
        campoEndereco.setText("");
    }
    
}
