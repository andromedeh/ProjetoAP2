package modelo;
import controle.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Administrador {
    private final String email;
    private final String senha;
    private ControleUsuario cUser = new ControleUsuario();
    private ControleObjeto cObj = new ControleObjeto();

    public Administrador (){
        this.email = "admpadrao@gmail.com";
        this.senha = "Adm00000";
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
    public void analisarSolicitacoes() throws IOException, FileNotFoundException, ClassNotFoundException{
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