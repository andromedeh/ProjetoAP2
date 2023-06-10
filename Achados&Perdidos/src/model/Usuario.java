package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
    private String email;
    private String nome;
    private String senha;
    private final long cpf;
    private long numero;
    private String endereco;
    private ArrayList <Solicitacao> solicitacoes = new ArrayList <> ();

    public Usuario (String email, String senha, String nome, long cpf, long numero, String endereco){
        setEmail(email);
        setSenha(senha);
        setNome(nome);
        setNumero(numero);
        setEndereco(endereco);
        this.cpf = cpf;
    }

    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
       this.nome = nome;
    }

    public long getNumero (){
        return this.numero;
    }

    public void setNumero(long numero){
       this.numero = numero;
    }

    public long getCpf (){
        return this.cpf;
    }

    public String getEndereco(){
        return this.endereco;
    }
    
    public void setEndereco(String endereco){
       this.endereco = endereco;
    }
    
    public void enviarSolicitacao(Solicitacao s){
        solicitacoes.add(s);
    }

    public ArrayList <Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }  
    
}