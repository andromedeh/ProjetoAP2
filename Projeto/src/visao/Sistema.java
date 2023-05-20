package visao;
import controle.*;
import javax.swing.JOptionPane;

public class Sistema {

    public static String menuUser(){
        return "Digite:\n" +
                "1 - Procurar objeto \n" +
                "2 - Notificar objeto encontrado \n" +
                "3 - Ver solicitações";
    }

    public static String menuAdm(){
        return "Digite:\n" +
                "1 - Adicionar objeto\n"+
                "2 - Remover objeto \n" +
                "3 - Analisar solitações";
    }
	
	public static void main(String[] args) {
            ControleUsuario cUser = new ControleUsuario();
            ControleObjeto cObj = new ControleObjeto();

            int op = Integer.parseInt(JOptionPane.showInputDialog("USUARIO OU ADM"));
            while (op!=0){
                switch (op){
                    case 1:{ 
                        JOptionPane.showInputDialog(menuUser());
                        break;
                    }
                    case 2:{  
                        JOptionPane.showInputDialog(menuUser());
                        break;
                    }
                    default:
                        //JOptionPane.showMessageDialog(null, "Entrada inválida!");
                }

                op = Integer.parseInt(JOptionPane.showInputDialog("USUARIO OU ADM"));
            }
	}
}