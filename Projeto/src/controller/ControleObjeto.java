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

    public void removerObjeto(int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{
        dadosObjeto.removerObjeto(codigo);
    }

    public Objeto procurarObjetoCodigo(int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{ //poderia ter mais funções do tipo procurarObjeto mas com diferentes parâmetros, por exemplo:
        return dadosObjeto.pesquisarObjetoCodigo(codigo);
    }
    
    public ArrayList<Objeto> procurarObjetoNome(String nome)throws IOException, FileNotFoundException, ClassNotFoundException{
        return dadosObjeto.pesquisarObjetoNome(nome);
    }
    
    public ArrayList<Objeto> procurarObjetoOpcao(int op) throws IOException, FileNotFoundException, ClassNotFoundException{
        return dadosObjeto.pesquisarObjetoOpcao(op);
    }
}