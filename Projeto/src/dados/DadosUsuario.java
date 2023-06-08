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
import modelo.Usuario;

/**
 *
 * @author hugob
 */
public class DadosUsuario {
    
    public void cadastrarUsuario(Usuario u)throws FileNotFoundException, IOException{
        FileOutputStream fluxo = new FileOutputStream("usuario.ser",true);
        ObjectOutputStream gravarUser = new ObjectOutputStream(fluxo);
        gravarUser.writeObject(u);
        gravarUser.close();
    }
    
    public ArrayList<Usuario> listarUsuario()throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Usuario> usuarios = new ArrayList();
        FileInputStream fluxo = new FileInputStream("usuario.ser");
        ObjectInputStream lerObj = null;
        while (fluxo.available()>0){
            lerObj = new ObjectInputStream(fluxo);
            Usuario u = (Usuario)lerObj.readObject();
            usuarios.add(u);
        }
        return usuarios;
    }
    
    public Usuario pesquisarUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuario flag = null;
        for (int i = 0; i < listarUsuario().size(); i++){
            if (i == listarUsuario().get(i).getCpf()){
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