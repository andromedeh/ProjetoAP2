package controller;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

public class TelaLoginAdmController extends BaseController implements Initializable {
    private PasswordField campoSenha;
    private Button btnLogIn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
    }
    
    public void handleLogIn(ActionEvent event){
        // FAZER VERIFICAÇÃO DA SENHA IGUAL NO LOGIN (usuario) -> OLHAR TelaLoginControlller
        // sceneManager.switchScene("/fxml/telaAdm/fxml");
    }
    
    void limparCampos(){
        campoSenha.clear();
    }
    
    
}
