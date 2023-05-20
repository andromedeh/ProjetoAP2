package modelo;

public class Solicitacao {
    private Objeto objeto;
    private String status;
    
    public Solicitacao (Objeto o, String status){
        this.status = status;
        this.objeto = o;
    }
    
    public Objeto getObjeto() {
        return objeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
