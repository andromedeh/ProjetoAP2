package controller;
import data.DadosUsuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.*;
import java.util.ArrayList;

public  class ControleUsuario{
    private DadosUsuario dadosUsuario = new DadosUsuario();

    public ArrayList<Usuario> getListaUsuarios() throws IOException, FileNotFoundException, ClassNotFoundException {
        return dadosUsuario.listarUsuario();
    }

    public void cadastrarUsuario(String email, String senha, String nome, long cpf, long numero, String endereco) throws IOException{
        Usuario u = new Usuario( email, senha, nome, cpf, numero, endereco);
        dadosUsuario.cadastrarUsuario(u);
    }

    public void removerUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException{
        dadosUsuario.removerUsuario(cpf); 
    }

    public Usuario procurarUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuario u = dadosUsuario.pesquisarUsuario(cpf);
        return u;
    }
    
    public boolean loginUsuario(long cpf, String senha)throws IOException, FileNotFoundException, ClassNotFoundException{
        if (procurarUsuario(cpf) != null && cpf == procurarUsuario(cpf).getCpf() && senha.equals(procurarUsuario(cpf).getSenha())){
            return true;
        }
        return false;
    }
    
}