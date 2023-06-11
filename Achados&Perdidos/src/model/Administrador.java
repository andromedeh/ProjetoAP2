package model;
import javax.swing.JOptionPane;
import controller.*;
import java.io.IOException;

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
    
    public void analisarSolicitacoes() throws ClassNotFoundException, IOException{
        String opcao;
        for (Usuario user: cUser.getListaUsuarios()){
            for (Solicitacao s : user.getSolicitacoes()){
                JOptionPane.showMessageDialog(null, s.getObjeto().mostrarInformacoes());
                opcao = JOptionPane.showInputDialog("Objeto entregue ao estoque? SIM ou NAO");
                if (opcao.equalsIgnoreCase("Sim")){
                    cObj.cadastrarObjeto(s.getObjeto());
                    s.setStatus("Entregue ao Achados&Perdidos");
                } else{
                    s.setStatus("Pendente de entrega ao Achados&Perdidos");
                }
            }
        }
    }
    
}