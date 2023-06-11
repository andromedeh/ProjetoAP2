package model;
import java.io.Serializable;
import java.time.LocalDate;

public class Objeto implements Serializable {
    private String categoria;
    private String descricao;
    private LocalDate data;
    private String local; 
    private static int codigo = 0; 

    public Objeto (String categoria, String descricao, String local, LocalDate data){
        setCategoria(categoria);
        setDescricao(descricao);
        setLocal(local);
        setData(data);
        Objeto.codigo += 1;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        Objeto.codigo = codigo;
    }
    
    public String mostrarInformacoes(){
        return    "\nTipo: " + getCategoria()
                + "\nDescricao: " + getDescricao()
                + "\nData: " + getData()
                + "\nLocal: " + getLocal()
                + "\nCodigo: " + getCodigo();
    }
}