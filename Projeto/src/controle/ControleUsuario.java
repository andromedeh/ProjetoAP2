package controle;
import dados.DadosUsuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import modelo.*;
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
        //Usuario removido com sucesso!
    }

    public Usuario procurarUsuario(long cpf) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuario u = dadosUsuario.pesquisarUsuario(cpf);
        return u;
    }
    
}