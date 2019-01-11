package principal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class PegaProx {
	private FileInputStream fis;
	private InputStreamReader isr;
	private static PushbackReader pbr;
	//public static String prox;
	//String cami = Compilador.attCaminho;

	public PegaProx(String caminho) throws FileNotFoundException{
		this.fis = new FileInputStream(caminho);
		this.isr = new InputStreamReader(this.fis);
		this.pbr = new PushbackReader(this.isr);
	}
	public static Character obterCaracter() throws IOException, TrataException {
		Character c = null;
		int i = pbr.read();
		if (i != -1) {
			c = (char) i;
		}
		if(c != null) {
			return Character.toUpperCase(c);
		}
		return null;
		}

	public static void devolverCaracter(Character c) throws IOException {
		pbr.unread(Character.toUpperCase(c));

	}
	
	public static Token getProx() throws IOException, TrataException{
		Token token = null;
		String retorno = null;
		Character c;
		do {
			String lexema = new String();
			c = obterCaracter();

			if (c == null) {
				throw new TrataException();
			}

			if (Character.isLetter(c) || c.equals('_')) {
				lexema = lexema + c;
				c = obterCaracter();
				while (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
					lexema = lexema + c;
					c = obterCaracter();
				}
				devolverCaracter(c);
				if(lexema.equals("INTEGER")) {
					token = new Token(TabelaMapa.INTEGER, "INTEGER");
				}else if(lexema.equals("ARRAY")) {
					token = new Token(TabelaMapa.ARRAY, "ARRAY");
				}else if(lexema.equals("BEGIN")) {
					token = new Token(TabelaMapa.BEGIN, "BEGIN");
				}else if(lexema.equals("PROGRAM")) {
					token = new Token(TabelaMapa.PROGRAM, "PROGRAM");
				}else if(lexema.equals("LABEL")) {
					token = new Token(TabelaMapa.LABEL, "LABEL");
				}else if(lexema.equals("CONST")) {
					token = new Token(TabelaMapa.CONST, "CONST");
				}else if(lexema.equals("VAR")) {
					token = new Token(TabelaMapa.VAR, "VAR");
				}else if(lexema.equals("PROCEDURE")) {
					token = new Token(TabelaMapa.PROCEDURE, "PROCEDURE");
				}else if(lexema.equals("END")) {
					token = new Token(TabelaMapa.END, "END");
				}
				else {
					token = new Token(TabelaMapa.IDENTIFICADOR, lexema);
				}
				
				//retorno = lexema;
				/*}else {
					return "";
				}*/
				break;
			}
		// ...
			else if (Character.isDigit(c)) {
				lexema = lexema + c;
				c = obterCaracter();
				while (Character.isDigit(c)) {
					lexema = lexema + c;
					c = obterCaracter();
				}
				devolverCaracter(c);
				token = new Token(TabelaMapa.INTEIRO, lexema);
				break;
			}
			if (c.equals(';')) {
				token = new Token(TabelaMapa.PONTO_VIRGULA, ";");
			}
			if(c.equals(':')) {
				token = new Token(TabelaMapa.DOISPONTOS, ":");
			}
			else if(c.equals('*')) {
				token = new Token(TabelaMapa.OP_MULT, "*");
			}
			else if(c.equals('+')) {
				token = new Token(TabelaMapa.OP_SOMA, "+");
			}
			else if(c.equals('-')) {
				token = new Token(TabelaMapa.OP_SUB, "-");
			}
			else if(c.equals('>')) {
				token = new Token(TabelaMapa.MAIOR, ">");
			}
			else if(c.equals('<')) {
				token = new Token(TabelaMapa.MENOR, "<");
			}
			else if(c.equals('[')) {
				token = new Token(TabelaMapa.CONCHETE_D, "(");
			}
			else if(c.equals(']')) {
				token = new Token(TabelaMapa.CONCHETE_E, "]");
			}
			else if(c.equals('(')) {
				token = new Token(TabelaMapa.PARENTESE_D, "(");
			}
			else if(c.equals(')')) {
				token = new Token(TabelaMapa.PARENTESE_E, ")");
			}
			else if(c.equals('.')) {
				token = new Token(TabelaMapa.PONTO, ".");
			}
			else if(c.equals(',')) {
				token = new Token(TabelaMapa.VIRGULA, ",");
			}
			else if(c.equals('=')) {
				token = new Token(TabelaMapa.IGUAL,"=");
				//retorno = c.toString();
			}
		} while (Character.isSpace(c));
		
		return token;
	}

}
