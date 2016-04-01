package entidades;

/**
 * 
 * Classe objeto de Cargo que é ocupada por um Servidor
 *@author Eddie
 */
public class Cargo {
	/**
	 * Atributos da classe
	 */
    private String codigo;
    private String nome;
    private String descricao;
    private String ramal;
    /**
     * Construtores da classe
     */
    public Cargo(){
    	
    }
    /**
     * Getters e setters da classe
     */
    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
