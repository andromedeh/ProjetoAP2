package controle;
import modelo.*;
import java.util.ArrayList;

public  class ControleUsuario{
    private static  final ArrayList <Usuario> listaUsuarios = new ArrayList<>();

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void cadastrarUsuario(Usuario user){
        if (user != null){
            listaUsuarios.add(user);
        }
    }

    public void removerUsuario(Usuario user){
        if (procurarUsuario(user.getCpf()) != null){
            listaUsuarios.remove(user);
        }
    }

    public Usuario procurarUsuario(long cpf){
        Usuario user = null;
        for (Usuario u: listaUsuarios){
            if (u.getCpf() == cpf){
                user = u;
            }
        }
        return user;
    }
    
}