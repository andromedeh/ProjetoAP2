package controle;
import modelo.*;
import java.util.ArrayList;

public class ControleObjeto {
    private static final ArrayList <Objeto> listaObjetos = new ArrayList<>();

    public void cadastrarObjeto(Objeto obj){
        if (obj != null){
            listaObjetos.add(obj);
        }
    }

    public void removerObjeto(Objeto obj){
        if (procurarObjeto(obj.getCodigo()) != null){
            listaObjetos.remove(obj);
        }
    }

    public Objeto procurarObjeto(int codigo){
        Objeto obj = null;
        for (Objeto o: listaObjetos){
            if (o.getCodigo() == codigo){
                obj = o;
            }
        }
        return obj;
    }
}
