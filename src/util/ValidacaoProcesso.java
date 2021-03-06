package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Processo;
import excecoes.RegexException;
/**
 * Classe que valida dados do Processo
 * @author Eddie
 *
 */
public class ValidacaoProcesso {

	private String padraoTipo;
	private String padraoDescricao;

	public ValidacaoProcesso() {
		this.padraoTipo = "(?x)[a-zA-Z]";
		this.padraoDescricao = "(?x)[a-zA-Z]";
	}

	public void validaDadosDoProcesso(Processo p) throws RegexException {
		this.validadorTipo(p.getTipo());
		this.validadorDescricao(p.getDescricao());
	}
	public void validadorTipo(String tipo) throws RegexException {
		Pattern regex = Pattern.compile(padraoTipo);
		Matcher matcher = regex.matcher(tipo);
		if (!matcher.find()) {
			throw new RegexException("N�o deve conter caracteres especiais(%-$_#@) no tipo! ");
		}
	}

	public void validadorDescricao(String descricao) throws RegexException {
		Pattern regex = Pattern.compile(padraoDescricao);
		Matcher matcher = regex.matcher(descricao);
		if (!matcher.find()) {
			throw new RegexException("N�o deve conter caracteres especiais(%-$_#@) na descricao!");
		}
	}

}
