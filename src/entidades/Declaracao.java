package entidades;
/**
 * Classe Declaracao com os seus respectivos atributos
 * @author Eddie
 */
public class Declaracao {
	/**
	 * Atributos da classe
	 */
    private String codigo;
    private String codigoSol;
    private String data;
    private String status;
    private String tipo;
    private String descricao;
    /**
     * Contrutores da classe
     */
    public Declaracao(){
    	
    }
    /**
     *Getters e setters da classe 
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getCodigoSol() {
		return codigoSol;
	}

	public void setCodigoSol(String codigoSol) {
		this.codigoSol = codigoSol;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
