package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Usuario;

public class DadosUsuario{
    private final String fileUsers = "usuarios.ser";
    
    public void cadastrarUsuario(Usuario u)throws FileNotFoundException, IOException{
        ArrayList <Usuario> usuarios = (ArrayList<Usuario>)listarUsuario();
        usuarios.add(u);
        try{
            FileOutputStream fluxo = new FileOutputStream(fileUsers);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(usuarios);
            escreverObj.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (IOException ex) {
           System.out.print(ex.getMessage());
        }
    }
    
    public ArrayList<Usuario> listarUsuario() throws IOException{
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        File arq = new File(fileUsers);
        if (!arq.exists()){
            arq.createNewFile();
            return usuarios;
        }
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            usuarios = (ArrayList<Usuario>)lerObj.readObject();
            fluxo.close();
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (ClassNotFoundException | IOException ex) {
            System.out.print(ex.getMessage());
        }
        return usuarios;
    }
    
    public Usuario pesquisarUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuario flag = null;
        for (int i = 0; i < listarUsuario().size(); i++){
            if (cpf == listarUsuario().get(i).getCpf()){
                flag = listarUsuario().get(i);  
            }
        }
        return flag;
    }
    
    public void removerUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = listarUsuario();
        Usuario usuarioEncontrado = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf() == cpf) {
                usuarioEncontrado = usuarios.get(i);
                usuarios.remove(i);
                break;
            }
        }
        
        if (usuarioEncontrado != null) {
            FileOutputStream fluxo = new FileOutputStream("usuario.ser");
            ObjectOutputStream gravarUser = new ObjectOutputStream(fluxo);

            for (int i = 0; i < usuarios.size(); i++) {
                gravarUser.writeObject(usuarios.get(i));
            }
            gravarUser.close();
            System.out.println("Usuário removido com sucesso!");
        } 
        else {
            System.out.println("Usuário não encontrado.");
        }
    }
}