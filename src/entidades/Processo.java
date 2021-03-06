package entidades;

/**
 * Classe objetos Processo
 */
public class Processo {
	/**
	 * Atributos da classe
	 */
    private String codigo;
    private String codigoSol;
	private String status;
	private String data;
	private String tipo;
    private String descricao;
    /**
     * Construtor da classe
     */
    public Processo(){
    	
    }
    /**
     * Getters e setters da classe
     * 
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

}
