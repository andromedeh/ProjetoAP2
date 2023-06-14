package controller;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import model.Objeto;
import model.Solicitacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TelaNotificarObjetoController implements Initializable{

    ObservableList<String> TipoList = FXCollections.observableArrayList("Documento pessoal",
    "Celular", "Carregador / Fone de Ouvido", "Chave", "Peça de Roupa", "Outro");

    @FXML
    private AnchorPane AnchorPaneNotificar;

    @FXML
    private TextField campoLocal;

    @FXML
    private Button btnCadastrarObjeto;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextArea campoDescricao;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private Label labelData;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelLocal;

    @FXML
    private Label labelTipo;
    
    @FXML
    private Label labelStatus;

    ControleObjeto cObj = new ControleObjeto();
    ControleSolicitacao cSol= new ControleSolicitacao();
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        limparCampos();
        labelStatus.setText("");
    }

    @FXML
    private void cadastrarObjeto(ActionEvent event) throws Exception{
        LocalDate data = campoData.getValue();
        String descricao = campoDescricao.getText();
        String local = campoLocal.getText();
        String categoria = choiceBoxTipo.getValue();
        if(descricao.isEmpty() || local.isEmpty() || categoria.equalsIgnoreCase("Selecione uma categoria") || campoData.getValue() == null){
            labelStatus.setText("Preencha todos os campo!");
        }else{
            Objeto obj = new Objeto(categoria, descricao, local, data);
            Solicitacao s = new Solicitacao(obj);
            cSol.cadastrarSolicitacao(s);
            labelStatus.setText("Objeto notificado! Por favor, entregue em nossa sede!");  
            limparCampos();
        }
    }
    
    public void limparCampos(){
        choiceBoxTipo.setItems(TipoList);
        choiceBoxTipo.setValue("Selecione uma categoria");
        campoLocal.clear();
        campoDescricao.clear();
    }
}
