package entidades;
/**
 * Classe objeto de Administrador
 * @author Eddie
 *
 */
public class Administrador extends Usuario{
	/**
	 * Atributos da classe
	 */
	private String login;
	private String senha;
	public static Usuario usuario;
	/**
	 * Construtores da classe
	 */
	public Administrador(){
		
	}
	public Administrador(Usuario u){
	Administrador.usuario = u;
	}
	/**
	 * Getters e setters da classe
	 */
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
