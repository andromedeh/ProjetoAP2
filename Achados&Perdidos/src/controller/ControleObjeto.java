package controller;
import data.DadosObjeto;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.*;
import java.util.ArrayList;

public class ControleObjeto {
    private DadosObjeto dadosObjeto = new DadosObjeto();

    public void cadastrarObjeto(Objeto obj) throws IOException{
        if (obj != null){
            dadosObjeto.cadastrarObjeto(obj);
        }
    }

     public ArrayList<Objeto> getListaObjetos() throws IOException, FileNotFoundException, ClassNotFoundException {
        return dadosObjeto.listarObjetos();
    }

    public void removerObjeto(Objeto codigo) throws IOException, FileNotFoundException, ClassNotFoundException{
        dadosObjeto.removerObjeto(codigo);
    }

    public void deleteObjeto(Objeto obj) throws Exception{
        dadosObjeto.deleteObjeto(obj);
    }

    public Objeto procurarObjetoCodigo(int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{ //poderia ter mais funções do tipo procurarObjeto mas com diferentes parâmetros, por exemplo:
        return dadosObjeto.pesquisarObjetoCodigo(codigo);
    }
    
    public Objeto procurarObjeto(String nome)throws IOException, FileNotFoundException, ClassNotFoundException{
        return dadosObjeto.pesquisarObjeto(nome);
    }
    
}