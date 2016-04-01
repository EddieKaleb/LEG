package entidades;

/**
 * Classe Curso que está relacionada com um Discente matriculado
 * @author Eddie
 */
public class Curso {
	/**
	 * Atributos da classe
	 */
    private String nome;
    private String codigo;
    private String ementa;
    private String cargaHoraria;
    private String descricao;
    /**
     * Construtores da classe
     */
    public Curso(){
    	
    }
    /**
     * Getters e setters da classe
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
