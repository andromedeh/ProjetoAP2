
package data;

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

public class DadosObjeto {
    private final String fileObjects = "objeto.ser";
    
    public void cadastrarObjeto(Objeto o)throws FileNotFoundException, IOException{
        ArrayList <Objeto> objetos = (ArrayList<Objeto>)listarObjetos();
        objetos.add(o);
        try{
            FileOutputStream fluxo = new FileOutputStream(fileObjects);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(objetos);
            escreverObj.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
}

    public ArrayList<Objeto> listarObjetos() throws IOException{
        ArrayList<Objeto> objetos = new ArrayList<Objeto>();
        File arq = new File(fileObjects);
        if (!arq.exists()){
            arq.createNewFile();
            return objetos;
        }
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            objetos = (ArrayList<Objeto>)lerObj.readObject();
            fluxo.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (ClassNotFoundException | IOException ex) {
            System.out.print(ex.getMessage());
        }
        return objetos;
    }

    public Objeto pesquisarObjeto(String descricao) throws IOException, FileNotFoundException, ClassNotFoundException{
    Objeto flag = null;
    for (int i = 0; i < listarObjetos().size(); i++){
        if (descricao.equalsIgnoreCase(listarObjetos().get(i).getDescricao())){
            flag = listarObjetos().get(i);  
        }
    }
    return flag;
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
    
    public void removerObjeto(Objeto o) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Objeto> objetos = listarObjetos();
        Objeto objetoEncontrado = null;
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getCodigo() == o.getCodigo()) {
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

    public void deleteObjeto(Objeto o) throws Exception {
        ArrayList <Objeto> objetos = (ArrayList<Objeto>)listarObjetos();
        boolean achou=false;
        for (int i=0; i<objetos.size(); i++){
             if (objetos.get(i).getCodigo() == o.getCodigo()){
                 objetos.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(objetos);
        }else{
            System.out.print("aaaaaaaaaaaaaaaaaaaaa");
        }
    }

    private void atualizarArquivo (ArrayList<Objeto> obj) throws Exception{
        try{
            FileOutputStream fluxo = new FileOutputStream(fileObjects);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(obj);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println (ex.getMessage());
           } catch (IOException ex) {
            System.out.println (ex.getMessage());
        }
    }
}
