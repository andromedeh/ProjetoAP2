package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import data.DadosObjeto;
import controller.ControleObjeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Objeto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaBuscaController implements Initializable{

    @FXML
    private AnchorPane AnchorPaneBusca;

    @FXML
    private TextField textFieldPesquisaObjeto;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoData;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoTipo;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoDescricao;

    @FXML
    private TableColumn<?, ?> tableColumnObjetoLocal;

    @FXML
    private TableView<?> tableObjeto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTableObjeto();
    }

    ControleObjeto cObj = new ControleObjeto();

    private void carregarTableObjeto() {
        tableColumnObjetoData.setCellValueFactory(new PropertyValueFactory("data"));
        tableColumnObjetoDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tableColumnObjetoLocal.setCellValueFactory(new PropertyValueFactory("local"));
        tableColumnObjetoTipo.setCellValueFactory(new PropertyValueFactory("categoria"));
        try {
            ArrayList<Objeto> listObjetos = (ArrayList<Objeto>)cObj.getListaObjetos();
            ObservableList obsListObjeto = FXCollections.observableArrayList(listObjetos);
            tableObjeto.setItems(obsListObjeto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    public void handlePesquisarObjeto(KeyEvent event) throws Exception{
        ObservableList obsListObjetos = FXCollections.observableArrayList();
        ArrayList<Objeto> listObjetos = (ArrayList<Objeto>)cObj.getListaObjetos();
        
        String descricao = textFieldPesquisaObjeto.getText();
        if (!descricao.isEmpty()){
            for (Objeto o : listObjetos){
                if (o.getDescricao().startsWith(descricao)){
                    obsListObjetos.add(o);
                }
            }
            tableObjeto.setItems(obsListObjetos);
        }
        else{
            carregarTableObjeto();
        }
    }
}