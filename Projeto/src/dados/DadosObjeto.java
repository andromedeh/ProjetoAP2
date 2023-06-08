/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Objeto;

/**
 *
 * @author hugob
 */
public class DadosObjeto {
    
    public void cadastrarObjeto(Objeto o) throws FileNotFoundException, IOException{
        FileOutputStream fluxo = new FileOutputStream("objeto.ser", true);
        ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo);
        gravarObj.writeObject(o);
        gravarObj.close();
    }
    
    public ArrayList<Objeto> listarObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList objetos = new ArrayList();
        FileInputStream fluxo = new FileInputStream("objeto.ser");
        ObjectInputStream lerObj = null;
        while (fluxo.available()>0){
            lerObj = new ObjectInputStream(fluxo);
            Objeto o = (Objeto)lerObj.readObject();
            objetos.add(o);
        }
        return objetos;
    }
    
    public ArrayList<Objeto> pesquisarObjetoNome(String nome) throws IOException, FileNotFoundException, ClassNotFoundException{ //pesquisa todos os objetos com determinado nome e retorna um arraylist com esses objetos
        ArrayList<Objeto> objetos = listarObjetos();
        ArrayList<Objeto> objEncontrado = new ArrayList();
        
        for (int i = 0; i < objetos.size(); i++){
            if(nome.equals( objetos.get(i).getNome())){
                objEncontrado.add(objetos.get(i));
            }
        }
        
        return objEncontrado;
    }
    
    public Objeto pesquisarObjetoCodigo(int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{ //pesquisa o objeto com o determinado código
        ArrayList<Objeto> objetos = listarObjetos();
        Objeto flag = null;
        for (int i = 0; i < objetos.size(); i++){
            if (codigo == objetos.get(i).getCodigo()){
                flag = objetos.get(i);
            }
        }        
        return flag;
    }
    
    public ArrayList<Objeto> pesquisarObjetoOpcao(int op) throws IOException, FileNotFoundException, ClassNotFoundException{ //pesquisa todos os objetos que sao de um determinado tipo e retorna um arraylist com esses objetos
        ArrayList<Objeto> objetos = listarObjetos();
        ArrayList<Objeto> objEncontrado = new ArrayList();
        
        for (int i = 0; i < objetos.size(); i++){
            if(op == objetos.get(i).getOpcao()){ //tive que criar um getOpcao() em Objeto para poder usar aqui para comparar
                objEncontrado.add(objetos.get(i));
            }
        }
        
        return objEncontrado;
    }
    
    public void removerObjeto(int codigo) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Objeto> objetos = listarObjetos();
        Objeto objetoEncontrado = null;
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getCodigo() == codigo) {
                objetoEncontrado = objetos.get(i);
                objetos.remove(i);
                break;
            }
        }
        
        if (objetoEncontrado != null) {
            FileOutputStream fluxo = new FileOutputStream("usuario.ser");
            ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo);

            for (int i = 0; i < objetos.size(); i++) {
                gravarObj.writeObject(objetos.get(i));
            }
            gravarObj.close();
            //usuario removido com sucesso!
        } 
        else {
            //usuario nao encontrado
        }
    }
    
}
