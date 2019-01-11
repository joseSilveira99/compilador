package principal;

import java.util.ArrayList;
import java.util.Stack;

import principal.Token;

public class Derivacoes {
	public static ArrayList<Token> derivacao;
	//public static ArrayList<Token> derivacao2;
	//new ArrayList<Token>();
	public Derivacoes() {

	}

	public static ArrayList<Token> devolveDerivacao(Integer c1, Integer c2) {
		if(c1.equals(52) && c2.equals(1)) {
			derivacao = new ArrayList<Token>();
			derivacao.add(new Token(TabelaMapa.PONTO, "PONTO"));
			derivacao.add(new Token(TabelaMapa.BLOCO, "BLOCO"));
			derivacao.add(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
			derivacao.add(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
			derivacao.add(new Token(TabelaMapa.PROGRAM, "PROGRAM"));	
		}else if(c1.equals(53) && c2.equals(2)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
			derivacao.add(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
			derivacao.add(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
			derivacao.add(new Token(TabelaMapa.DCLROT, "DCLROT"));
		}else if(c1.equals(53) && c2.equals(3)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
			derivacao.add(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
			derivacao.add(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
			derivacao.add(new Token(TabelaMapa.DCLROT, "DCLROT"));
		}else if(c1.equals(53) && c2.equals(4)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
			derivacao.add(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
			derivacao.add(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
			derivacao.add(new Token(TabelaMapa.DCLROT, "DCLROT"));
		}else if(c1.equals(53) && c2.equals(5)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
			derivacao.add(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
			derivacao.add(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
			derivacao.add(new Token(TabelaMapa.DCLROT, "DCLROT"));
		}else if(c1.equals(53) && c2.equals(6)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
			derivacao.add(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
			derivacao.add(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
			derivacao.add(new Token(TabelaMapa.DCLROT, "DCLROT"));
		}else if(c1.equals(54) && c2.equals(2)) {
			derivacao.add(new Token(TabelaMapa.CORPO, "CORPO"));
			derivacao.add(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
			derivacao.add(new Token(TabelaMapa.LID, "LID"));
			derivacao.add(new Token(TabelaMapa.LABEL, "LABEL"));
		}
		
		
		return derivacao;
	}


}
