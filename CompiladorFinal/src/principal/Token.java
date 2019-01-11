package principal;

public class Token {

	private Integer codigo, linha;
	private String palavra;
	

	public Token() {
	}

	public Token(String palavra) {
		this.palavra = palavra;
	}

	public Token(Integer codigo, String palavra) {
		this.codigo = codigo;
		this.palavra = palavra;
	}
	
	public Token(Integer codigo, String palavra, Integer linha) {
		this.codigo = codigo;
		this.palavra = palavra;
		this.linha = linha;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("=-=-=-=-=-=-=-\n");
		sb.append("Código: ");
		sb.append(this.getCodigo());
		sb.append("\n");
		sb.append("Palavra: ");
		sb.append(this.getPalavra());
		sb.append("\n");
		sb.append("Linha: ");
		sb.append(this.getLinha());
		sb.append("\n=-=-=-=-=-=-=-\n");
		return sb.toString();
	}

}