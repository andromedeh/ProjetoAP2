package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Objeto;
import model.Solicitacao;

public class TelaObjetosAdmController extends BaseController implements Initializable {

    @FXML
    private TableView<Objeto> tabelaObjetos;

    @FXML
    private TableColumn<Objeto, String> nome;

    @FXML
    private TableColumn<Objeto, String> tipo;

    @FXML
    private TableColumn<Objeto, String> descricao;

    @FXML
    private TableColumn<Objeto, String> local;

    @FXML
    private TableColumn<Objeto, LocalDate> data;

    @FXML
    private Label labelAviso;

    @FXML
    private Button btnAdicionarObjeto;

    @FXML
    private Button btnRemoverObjeto;

    @FXML
    private TextField campoBusca;

    @FXML
    private Button btnBuscar;
    
    ControleObjeto cObj = new ControleObjeto();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       carregarTableObjeto();
    }

    public void carregarTableObjeto() {
        tipo.setCellValueFactory(new PropertyValueFactory<Objeto, String>("categoria"));
        descricao.setCellValueFactory(new PropertyValueFactory<Objeto, String>("descricao"));
        local.setCellValueFactory(new PropertyValueFactory<Objeto, String>("local"));
        data.setCellValueFactory(new PropertyValueFactory<Objeto, LocalDate>("data"));
        
        try {
                ArrayList<Objeto> listObjetos = (ArrayList<Objeto>)cObj.getListaObjetos();
                ObservableList obsListObjeto = FXCollections.observableArrayList(listObjetos);
                tabelaObjetos.setItems(obsListObjeto);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }


    
    public void buscar(KeyEvent event) throws Exception{
        ObservableList obsListObjetos = FXCollections.observableArrayList();
        ArrayList<Objeto> listObjetos = (ArrayList<Objeto>)cObj.getListaObjetos();
        
        String descricao = campoBusca.getText();
        if (!descricao.isEmpty()){
            for (Objeto o : listObjetos){
                if (o.getDescricao().startsWith(descricao)){
                    obsListObjetos.add(o);
                }
            }
            tabelaObjetos.setItems(obsListObjetos);
        }
        else{
            carregarTableObjeto();
        }
    }
    
    @FXML
    public void adicionarObjeto(ActionEvent event){
        AnchorPane f;
        try {
            f = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/telaAdicionarObjetoAdm.fxml"));
            Stage secondStage = new Stage();
            Scene secondScene = new Scene(f);
            secondStage.setScene(secondScene);
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(TelaAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void removerObjeto(ActionEvent event) throws Exception{
        Objeto obj = tabelaObjetos.getSelectionModel().getSelectedItem();
        if(obj == null){
            labelAviso.setText("Selecione o objeto desejado!");
        }else{
            cObj.deleteObjeto(obj);
            carregarTableObjeto();
        }
    }
}