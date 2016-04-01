package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Declaracao;
import excecoes.RegexException;

public class ValidacaoDeclaracao {
	private String padraoTipo;
	private String padraoDescricao;
	
	public ValidacaoDeclaracao(){
		this.padraoDescricao = "(?x)[a-zA-Z]";
		this.padraoTipo = "(?x)[a-zA-Z]";
	}
	
	public void validaDadosDaDeclaracao(Declaracao d) throws RegexException{
		this.validadorTipo(d.getTipo());
		this.validadorDescricao(d.getDescricao());
	}
	
	
	public void validadorTipo(String tipo) throws RegexException {
		Pattern regex = Pattern.compile(padraoTipo);
		Matcher matcher = regex.matcher(tipo);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) no tipo! ");
		}
	}

	
	public void validadorDescricao(String descricao) throws RegexException {
		Pattern regex = Pattern.compile(padraoDescricao);
		Matcher matcher = regex.matcher(descricao);
		if (!matcher.find()) {
			throw new RegexException("Não deveS conter caracteres especiais(%-$_#@) na descricao!");
		}
	}
	
}
