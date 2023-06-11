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

    public void cadastrarSolicitacao(Solicitacao s)throws Exception{
        //Solicitacao s = new Solicitacao(o);
        ArrayList <Solicitacao> solicitacoes = (ArrayList<Solicitacao>)getSolicitacaoList();
        solicitacoes.add(s);
        try{
            FileOutputStream fluxo = new FileOutputStream(fileObjects);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(solicitacoes);
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

    public ArrayList<Objeto> getSolicitacaoObjetoList() throws Exception{
        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        ArrayList<Objeto> objetos = new ArrayList<Objeto>();
        File arq = new File(fileObjects);
        if (!arq.exists()){
            arq.createNewFile();
            return objetos;
        }
        FileInputStream fluxo;
        ObjectInputStream lerSol = null;
        try{
            fluxo = new FileInputStream(arq);
            lerSol = new ObjectInputStream(fluxo);
            solicitacoes = (ArrayList<Solicitacao>)lerSol.readObject();
            for(int i = 0; i < solicitacoes.size(); i++){
                objetos.add(solicitacoes.get(i).getObjeto());
            }
            fluxo.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (ClassNotFoundException | IOException ex) {
            System.out.print(ex.getMessage());
        }
        return objetos;
    }

    public void deleteSolicitacao(Objeto o) throws Exception {
        ArrayList <Solicitacao> solicitacoes = (ArrayList<Solicitacao>)getSolicitacaoList();
        boolean achou=false;
        for (int i=0; i<solicitacoes.size(); i++){
                Objeto obj = solicitacoes.get(i).getObjeto();
             if (obj.getLocal().equalsIgnoreCase(o.getLocal()) && obj.getCategoria().equalsIgnoreCase(o.getCategoria()) && obj.getDescricao().equalsIgnoreCase(o.getDescricao()) && obj.getData().equals(o.getData())){
                 solicitacoes.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(solicitacoes);
        }else{
            System.out.print("aaaaaaaaaaaaaaaaaaaaa");
        }
    }

        private void atualizarArquivo (ArrayList<Solicitacao> s) throws Exception{
        try{
            FileOutputStream fluxo = new FileOutputStream(fileObjects);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(s);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println (ex.getMessage());
           } catch (IOException ex) {
            System.out.println (ex.getMessage());
        }
    }

}
