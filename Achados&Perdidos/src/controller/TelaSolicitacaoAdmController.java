package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Objeto;
import model.Solicitacao;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.ControleSolicitacao;
import controller.ControleObjeto;

public class TelaSolicitacaoAdmController implements Initializable{

    @FXML
    private AnchorPane AnchorPaneSolicitacao;

    @FXML
    private Label labelAviso;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoData;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoDescricao;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoLocal;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoTipo;

    @FXML
    private TableView<Objeto> tableObjeto;

    @FXML
    private Button btnAceitarSolicitacao;

    @FXML
    private Button btnExcluirSolicitacao;

    ControleSolicitacao cSol = new ControleSolicitacao();
    ControleObjeto cObj = new ControleObjeto();

    @FXML
    void aceitarSolicitacao(ActionEvent event) throws Exception{
        Objeto obj = tableObjeto.getSelectionModel().getSelectedItem();
        if(obj == null){
            labelAviso.setText("Selecione o objeto desejado!");
        }else{
            cObj.cadastrarObjeto(obj);
            cSol.deleteSolicitacao(obj);
            carregarTableObjeto();
        }
    }

    private void carregarTableObjeto() {
        tableColumnObjetoData.setCellValueFactory(new PropertyValueFactory("data"));
        tableColumnObjetoDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tableColumnObjetoLocal.setCellValueFactory(new PropertyValueFactory("local"));
        tableColumnObjetoTipo.setCellValueFactory(new PropertyValueFactory("categoria"));
        try {
            ArrayList<Objeto> listObjetos = (ArrayList<Objeto>)cSol.getSolicitacaoObjetoList();
            ObservableList obsListObjeto = FXCollections.observableArrayList(listObjetos);
            tableObjeto.setItems(obsListObjeto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void excluirSolicitacao(ActionEvent event) throws Exception{
        Objeto obj = tableObjeto.getSelectionModel().getSelectedItem();
        if(obj == null){
            labelAviso.setText("Selecione o objeto desejado!");
        }else{
            cSol.deleteSolicitacao(obj);
            carregarTableObjeto();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarTableObjeto();
    }

}
