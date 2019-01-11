package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class PegaCar {

	private FileInputStream fis;
	private InputStreamReader isr;
	private PushbackReader pbr;
	public static Character ant = ' ';
	public static boolean comentario = false, literal = false, secret = false, remove = false;
	public static Integer linha;
	public static Token ab;
	public PegaCar(String caminho) throws FileNotFoundException {
		this.fis = new FileInputStream(caminho);
		this.isr = new InputStreamReader(this.fis);
		this.pbr = new PushbackReader(this.isr);
		PegaCar.linha = 1;
	}

	public Character obterCaracter() throws IOException, TrataException {
		Character c = null;
		int i = pbr.read();
		if (i != -1) {
			c = (char) i;
		}
		if(c != null) {
			//incrementarLinhaColuna(c);
				if (c.hashCode() == 10 ) {
					//System.out.println("<!> "+c.hashCode());
					PegaCar.linha++;
				}
			return Character.toUpperCase(c);
		}
		return null;
		}

	public void devolverCaracter(Character c) throws IOException{
		decrementarLinhaColuna(c);
	    pbr.unread(Character.toUpperCase(c));
	}
	
	/*private void incrementarLinhaColuna(char c) {

		switch (c) {
		case '\n':
			//this.coluna = 0;
			PegaCar.linha++;
			break;
		default:
			//this.coluna = this.coluna + 1;
			break;
		}
	}
*/
	private void decrementarLinhaColuna(Character c) {

		switch (c) {
		case '\t':
			//this.coluna = this.coluna - 4;
			break;
		case '\n':
			PegaCar.linha--;
			break;
		case '\r':
			break;

		default:
			//this.coluna = this.coluna - 1;
			break;
		}
	}
	@SuppressWarnings({ "deprecation" })
	public Token getToken() throws IOException, TrataException{
		//if(!comentario) {
		Token token = null;
		Character c;
		ab = PegaProx.getProx();
		//System.out.println(ab);
		do {
			String palavra = new String();
			c = obterCaracter();

			/*if (c == null) {
				throw new TrataException();
			}*/
			if (Character.isLetter(c)) {
				palavra = palavra + c;
				c = obterCaracter();
				while (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
					palavra = palavra + c;
					c = obterCaracter();
				}
				devolverCaracter(c);
				token = new Token(palavra);
				TabelaMapa.encontraToken(token);
				break;
			}
			if (Character.isDigit(c)) {
				palavra = palavra + c;
				c = obterCaracter();//pegar prox caracter
				while (Character.isDigit(c)) {
					palavra = palavra + c;
					c = obterCaracter();
				}
				this.devolverCaracter(c);
				/*if(ant.equals('-')) 
				secret = true;*/
				if(ant.equals('-')) {
					SetaTabela.remove();
					//System.out.println(ant);
					String lavra = "-"+palavra;
					token = new Token(TabelaMapa.INTEIRO, lavra, PegaCar.linha);
					break;
				}else {
					token = new Token(TabelaMapa.INTEIRO, palavra, PegaCar.linha);
					break;	
				}
			}
			/*System.out.println("anterior: "+ant);*/
			//System.out.println("caracter: "+c);
			//System.out.println("prox: "+Compilador.prox);
     		if (c.equals(';')) {
				token = new Token(TabelaMapa.PONTO_VIRGULA, c.toString(), PegaCar.linha);
			}
     		else  if(c.toString().equals("'")) {
				token = new Token(TabelaMapa.LITERAL, c.toString(), PegaCar.linha);
				//literal = !literal;
			}
			else if(c.equals(':') && ab.getCodigo().equals(8) || c.equals(':') && ab.getCodigo().equals(9) || c.equals(':') && ab.getCodigo().equals(6) || c.equals(':') && ab.getCodigo().equals(5) || c.equals(':') && ab.getCodigo().equals(25)) {
				token = new Token(TabelaMapa.DOISPONTOS, c.toString(), PegaCar.linha);
			}
			else if(c.equals(':') && ab.getPalavra().equals("=")) {
				token = new Token(TabelaMapa.ATRIBUICAO, ":=", PegaCar.linha);
			}
			else if(c.toString().equals("(") && ab.getPalavra().equals("*")) {
				comentario = true;
				token = new Token(TabelaMapa.ICOMEN, "(*", PegaCar.linha);
				SetaTabela.setarTab(token);
			}
			else if(c.equals(')')) {
				if(ant.toString().equals("*")) {
				token = new Token(TabelaMapa.FCOMEN, "*)", PegaCar.linha);
				SetaTabela.setarTab(token);
				//break;
				}else {
					token = new Token(TabelaMapa.PARENTESE_E, ")", PegaCar.linha);
				}
			}
			else if(c.equals('(')) {
				token = new Token(TabelaMapa.PARENTESE_D, "(", PegaCar.linha);
			}
			else if(c.equals(',')) {
				token = new Token(TabelaMapa.VIRGULA, c.toString(), PegaCar.linha);
			}
			
			else if(c.equals('[')) {
				token = new Token(TabelaMapa.CONCHETE_D, c.toString(), PegaCar.linha);
			}
			else if(c.equals(']')) {
				token = new Token(TabelaMapa.CONCHETE_E, c.toString(), PegaCar.linha);
			}
			else if(c.equals('=')) {
				if(ant.toString().equals(":") || ant.toString().equals(">") || ant.toString().equals("<")) {
					secret = true;
					token = new Token(TabelaMapa.FATOR, "nada", PegaCar.linha);
				}else {
					token = new Token(TabelaMapa.IGUAL,"=", PegaCar.linha);	
				}
			}
			else if(c.equals('+')) {
				token = new Token(TabelaMapa.OP_SOMA, c.toString(), PegaCar.linha);
			}
			else if(c.equals('-')) {
				/*if(ab.getCodigo().equals(26)) {
					token = new Token(TabelaMapa.INTEIRO, "-"+ab.getPalavra());
				}*/
				/*else{*/
				token = new Token(TabelaMapa.OP_SUB, c.toString(), PegaCar.linha);
				//}
			}
			else if(c.equals('*')) {
				token = new Token(TabelaMapa.OP_MULT, c.toString(), PegaCar.linha);
			}
			else if(c.equals('/')) {
				token = new Token(TabelaMapa.OP_DIVI, c.toString(), PegaCar.linha);
			}
			else if(c.equals('>')) {
				if(ab.getPalavra().equals("=")) {
					token = new Token(TabelaMapa.MAIORIGUAL, ">=", PegaCar.linha);
				}else if(ant.toString().equals("<")) {
					secret = true;
					token = new Token(TabelaMapa.FATOR, "nada", PegaCar.linha);
				}else {
					token = new Token(TabelaMapa.MAIOR, ">", PegaCar.linha);
				}
			}else if(c.equals('<')) {
				if(ab.getPalavra().equals("=")) {
					token = new Token(TabelaMapa.MENORIGUAL, "<=", PegaCar.linha);			
				}else if(ab.getPalavra().equals(">")){
					token = new Token(TabelaMapa.DIFERENTE, "<>", PegaCar.linha);
				}else {
					token = new Token(TabelaMapa.MENOR, "<", PegaCar.linha);
				}
			}
     		//System.out.println(ant.toString());
			else if(c.equals('.')) {
				if(ab.getPalavra().equals(".")) {
					token = new Token(TabelaMapa.PONTO_PONTO, "..", PegaCar.linha);
				}else if(ant.toString().equals(".")){
					secret = true;
					token = new Token(TabelaMapa.FATOR, "nada", PegaCar.linha);
				}
				else {
					token = new Token(TabelaMapa.PONTO, ".", PegaCar.linha);
				}
			}
			ant=c;
		} while (Character.isSpace(c));

		return token;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		PegaCar.linha = linha;
	}
	
}
