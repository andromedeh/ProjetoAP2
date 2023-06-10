package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Objeto;
import model.Solicitacao;

public class ControleSolicitacao {
    private final String fileObjects = "solicitacao.ser";

    public void cadastrarSolicitacao(Objeto o)throws Exception{
        Solicitacao s = new Solicitacao(o);
        ArrayList <Solicitacao> solicitacaos = (ArrayList<Solicitacao>)getSolicitacaoList();
        solicitacaos.add(s);
        try{
            FileOutputStream fluxo = new FileOutputStream(fileObjects);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(solicitacaos);
            escreverObj.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        }

    public ArrayList<Solicitacao> getSolicitacaoList() throws Exception{
        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        File arq = new File(fileObjects);
        if (!arq.exists()){
            arq.createNewFile();
            return solicitacoes;
        }
        FileInputStream fluxo;
        ObjectInputStream lerSol = null;
        try{
            fluxo = new FileInputStream(arq);
            lerSol = new ObjectInputStream(fluxo);
            solicitacoes = (ArrayList<Solicitacao>)lerSol.readObject();
            fluxo.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (ClassNotFoundException | IOException ex) {
            System.out.print(ex.getMessage());
        }
        return solicitacoes;
    }

}
