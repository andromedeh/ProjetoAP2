package modelo;
import java.util.Date;

public class Objeto {
    private String nome;
    private String tipo;
    private String descricao;
    private Date data; // nao sei trabalhar com essa biblioteca
    private String local; 
    private static int codigo = 0; // pode ser usada em funções de procurar objeto

    public Objeto (String nome, String descricao, String local, int opcao){
        setNome(nome);
        setDescricao(descricao);
        setLocal(local);
        // setDate (data que foi encontrado)
        this.codigo = ++codigo;
        classificar(opcao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Objeto.codigo = codigo;
    }
    
    // set e get de Date 
    
    public void classificar( int opcao){ // pensei em usar uma variavel tipo para classificar os objetos,
        switch (opcao){                     // ao inves de criar varios "filhos"
            case 1:
                this.tipo = "Documento pessoal";
                break;
            case 2: 
                this.tipo = "Celular";
                break;
            case 3: 
                this.tipo = "Carregador / Fone de Ouvido";
                break;
            case 4:
                this.tipo = "Material Escolar";
                break;
            case 5:
                this.tipo = "Chave";
                break;
            case 6:
                this.tipo = "Peça de Roupa";
                break;
            default:
                this.tipo = "Outro";
        }
    }
    
    public String mostrarInformacoes(){
        return "Nome: " + getNome()
                + "\nTipo: " + getTipo()
                + "\nDescricao: " + getDescricao()
                + "\nData: " + getData()
                + "\nLocal: " + getLocal()
                + "\nCodigo: " + getCodigo();
    }
}