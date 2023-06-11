package controller;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import controller.ControleObjeto;
import model.Objeto;
import controller.ControleSolicitacao;
import javafx.beans.Observable;
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

public class TelaAdicionarObjetoAdmController implements Initializable{

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
        choiceBoxTipo.setItems(TipoList);
        choiceBoxTipo.setValue("Selecione uma categoria");
    }

    @FXML
    private void cadastrarObjeto(ActionEvent event) throws Exception{
        //Date data = Date.from(campoData.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate data = campoData.getValue();
        String descricao = campoDescricao.getText();
        String local = campoLocal.getText();
        String categoria = choiceBoxTipo.getValue();
        if(descricao.isEmpty() || local.isEmpty() || categoria.equalsIgnoreCase("Selecione uma categoria") || campoData.getValue() == null){
            labelStatus.setText("Preencha todos os campo!");
        }else{
            Objeto obj = new Objeto(categoria, descricao, local, data);
            cObj.cadastrarObjeto(obj);
            labelStatus.setText("Objeto cadastrador com sucesso!");
            
        }
    }
}
