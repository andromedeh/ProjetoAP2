package model;
import controller.*;

public class Administrador {
    private final String senha;
    private ControleUsuario cUser = new ControleUsuario();
    private ControleObjeto cObj = new ControleObjeto();

    public Administrador (){
        this.senha = "Adm00000";
    }

    public String getSenha() {
        return senha;
    }
    
}