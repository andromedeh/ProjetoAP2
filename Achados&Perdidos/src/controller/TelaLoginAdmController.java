package controller;

import javafx.scene.control.Button;
import model.Administrador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

public class TelaLoginAdmController extends BaseController implements Initializable {
    private PasswordField campoSenha;
    private Button btnLogIn;
    private Administrador Adm = new Administrador();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    }
    
        public void handleLogIn(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        String senha = campoSenha.getText();
        if (senha.contentEquals(Adm.getSenha())){
            sceneManager.switchScene("/fxml/telaAdm.fxml");
        } else{
            campoSenha.setPromptText("digite novamente");
            campoSenha.clear();
        }
    }
    
    void limparCampos(){
        campoSenha.clear();
    }
    
    
}
