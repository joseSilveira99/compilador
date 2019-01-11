package principal;

public class TabelaSimbolos {
	String nome;//nome do identificador
	String categoria;//codigo da categoria, variavel, constante, procedure, rótulo, parâmetro
	String tipo;//tipo do identificador, inteiro ou literal
	Integer nivel, linha;//nivel onde o identificador foi declarado~
	
	
	public TabelaSimbolos() {}
	
	public TabelaSimbolos(String nome, String categoria, String tipo, Integer nivel, Integer linha) {
		this.nome = nome;
		this.categoria = categoria;
		this.tipo = tipo;
		this.nivel = nivel;
		this.linha = linha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
}
