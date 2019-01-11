package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabelaMapa {
	static Integer ant;
	/*public static List<String> guardaNome = new ArrayList<String>();
	static Integer categoria, nivel = 0, teste=0, tipo = 1;
	static String auxxx = "PROGRAM", auxx = "";*/
	public static final int PROGRAM = 1;
	public static final int LABEL = 2;
	public static final int CONST = 3;
	public static final int VAR = 4;
	public static final int PROCEDURE = 5;
	public static final int BEGIN = 6;
	public static final int END = 7;
	public static final int INTEGER = 8;
	public static final int ARRAY = 9;
	public static final int OF = 10;
	public static final int CALL = 11;
	public static final int GOTO = 12;
	public static final int IF = 13;
	public static final int THEN = 14;
	public static final int ELSE = 15;
	public static final int WHILE = 16;
	public static final int DO = 17;
	public static final int REPEAT = 18;
	public static final int UNTIL = 19;
	public static final int READLN = 20;
	public static final int WRITELN = 21;
	public static final int OR = 22;
	public static final int AND = 23;
	public static final int NOT = 24;
	public static final int IDENTIFICADOR = 25;
	public static final int INTEIRO = 26;
	public static final int FOR = 27;
	public static final int TO = 28;
	public static final int CASE = 29;
	public static final int OP_SOMA = 30;
	public static final int OP_SUB = 31;
	public static final int OP_MULT = 32;
	public static final int OP_DIVI = 33;
	public static final int CONCHETE_D = 34;
	public static final int CONCHETE_E = 35;
	public static final int PARENTESE_D = 36;
	public static final int PARENTESE_E = 37;
	public static final int ATRIBUICAO = 38;
	public static final int DOISPONTOS = 39;
	public static final int IGUAL = 40;
	public static final int MAIOR = 41;
	public static final int MAIORIGUAL = 42;
	public static final int MENOR = 43;
	public static final int MENORIGUAL = 44;
	public static final int DIFERENTE = 45;
	public static final int VIRGULA = 46;
	public static final int PONTO_VIRGULA = 47;
	public static final int LITERAL = 48;
	public static final int PONTO = 49;
	public static final int PONTO_PONTO = 50;
	public static final int CIFRAO = 51;
	public static final int ICOMEN = 88;
	public static final int FCOMEN = 89;
	/*----------------------------------*/
	public static final int PROGRAMA = 52;
	public static final int BLOCO = 53;
	public static final int DCLROT = 54;
	public static final int LID = 55;
	public static final int REPIDENT = 56;
	public static final int DCLCONST = 57;
	public static final int LDCONST = 58;
	public static final int DCLVAR = 59;
	public static final int LDVAR = 60;
	public static final int TIPO = 61;
	public static final int DCLPROC = 62;
	public static final int DEFPAR = 63;
	public static final int CORPO = 64;
	public static final int REPCOMANDO = 65;
	public static final int COMANDO = 66;
	public static final int RCOMID = 67;
	public static final int RVAR = 68;
	public static final int PARAMETROS = 69;
	public static final int REPPAR = 70;
	public static final int ELSEPARTE = 71;
	public static final int VARIAVEL = 72;
	public static final int VARIAVEL1 = 73;
	public static final int REPVARIAVEL = 74;
	public static final int ITEMSAIDA = 75;
	public static final int REPITEM = 76;
	public static final int EXPRESSAO = 77;
	public static final int REPEXPSIMP = 78;
	public static final int EXPSIMP = 79;
	public static final int REPEXP = 80;
	public static final int TERMO = 81;
	public static final int REPTERMO = 82;
	public static final int FATOR = 83;
	public static final int CONDCASE= 84;
	public static final int CONTCASE = 85;
	public static final int RPINTEIRO = 86;
	public static final int SEM_EFEITO = 87;
	public static final int FIMSE = 100;
	
	public static void encontraToken(Token token) {
		//Semantico s = new Semantico();
		if (token.getPalavra().equals("PROGRAM")) {
			token.setCodigo(PROGRAM);
			token.setLinha(PegaCar.linha);
		}
		else if (token.getPalavra().equals("LABEL")) {
			//PegaCar.linha--;
			token.setCodigo(LABEL);
			token.setLinha(PegaCar.linha);
			/*categoria = LABEL;
			auxxx = "LABEL";
			teste = 0;*/
			}
		else if (token.getPalavra().equals("CONST")) {
			//PegaCar.linha--;
			token.setCodigo(CONST);
			token.setLinha(PegaCar.linha);
			/*categoria = CONST;
			auxxx = "CONST";
			teste = 0;*/
			}
		else if (token.getPalavra().equals("ARRAY")) {
			token.setCodigo(ARRAY);
			token.setLinha(PegaCar.linha);
			//categoria = ARRAY;
			//auxxx = "ARRAY";
			}
		else if (token.getPalavra().equals("OF")) {
			token.setCodigo(OF);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("CALL")) {
			token.setCodigo(CALL);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("ELSE")) {
			token.setCodigo(ELSE);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("VAR")) {
			token.setCodigo(VAR);
			token.setLinha(PegaCar.linha);
			/*categoria = VAR;
			auxxx = "VAR";
			teste = 1;*/
		}
		else if (token.getPalavra().equals("INTEGER")) {
			token.setCodigo(INTEGER);
			token.setLinha(PegaCar.linha);
			//auxx = "INTEGER";
			}
		else if (token.getPalavra().equals("PROCEDURE")) {
			token.setCodigo(PROCEDURE);
			token.setLinha(PegaCar.linha);
			/*categoria = PROCEDURE;
			nivel = 1;
			teste = 1;*/
			//auxxx = "PROCEDURE";
			}
		else if (token.getPalavra().equals("DO")) {
			token.setCodigo(DO);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("WHILE")) {
			token.setCodigo(WHILE);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("REPEAT")) {
			token.setCodigo(REPEAT);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("UNTIL")) {
			token.setCodigo(UNTIL);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("OR")) {
			token.setCodigo(OR);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("AND")) {
			token.setCodigo(AND);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("NOT")) {
			token.setCodigo(NOT);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("FOR")) {
			token.setCodigo(FOR);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("TO")) {
			token.setCodigo(TO);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("CASE")) {
			token.setCodigo(CASE);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("<=")) {
			token.setCodigo(MENORIGUAL);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals(">=")) {
			token.setCodigo(MAIORIGUAL);
			token.setLinha(PegaCar.linha);
		}
		else if (token.getPalavra().equals("<>")) {
			token.setCodigo(DIFERENTE);
			token.setLinha(PegaCar.linha);
			}
		else if (token.getPalavra().equals("END")) {
			token.setCodigo(END);
			token.setLinha(PegaCar.linha);
			//nivel = 0;
			
			}
		else if (token.getPalavra().equals("BEGIN")) {
			token.setCodigo(BEGIN);
			token.setLinha(PegaCar.linha);
			//auxxx = "BEGIN";
			}
		else if (token.getPalavra().equals("READLN")) {
			token.setCodigo(READLN);
			token.setLinha(PegaCar.linha);
			//auxxx = "READLN";
			}
		else if (token.getPalavra().equals("WRITELN")) {
			token.setCodigo(WRITELN);
			token.setLinha(PegaCar.linha);
			//auxxx = "WRITELN";
			}
		else if (token.getPalavra().equals("IF")) {
			token.setCodigo(IF);
			token.setLinha(PegaCar.linha);
			//auxxx = "IF";
			}
		else if (token.getPalavra().equals("THEN")) {
			token.setCodigo(THEN);
			token.setLinha(PegaCar.linha);
			}
		/*else if (token.getPalavra().equals("FIMSE")) {
			token.setCodigo(FIMSE);
		}*/
		else {
	    	token.setCodigo(IDENTIFICADOR);
	    	token.setLinha(PegaCar.linha);
	    	/*if(PegaCar.ant.equals('(')) {
	    		categoria = 69;
	    		teste = 1;
	    	}
	    	if(auxxx.equals("LABEL") && PegaCar.comentario==false || auxxx.equals("CONST") && PegaCar.comentario==false || auxxx.equals("VAR") && PegaCar.comentario==false) {
	    	if(teste.equals(1)) {
	    			guardaNome.add(token.getPalavra());	
	    	}
	    	if (auxxx.equals("LABEL")) {
				tipo = 2;
			}else if (auxxx.equals("CONST")) {
			    tipo = 3;	
			}
	    	TabelaSimbolos obj = new TabelaSimbolos(token.getPalavra(), categoria, tipo, nivel);
	    	try {
				Semantico.insercao(obj);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	}else if(auxx.equals("INTEGER") && teste.equals(1)) {
	    		for (int i = 0; i < Semantico.tabsimbolo.size(); i++) {
	    			for (int j = 0; j < guardaNome.size(); j++) {
					if(Semantico.tabsimbolo.get(i).getNome().equals(guardaNome.get(j))) {
						Semantico.tabsimbolo.get(i).setTipo(8);
					}
	    			}
				}
	    	}*/
		}
		ant = token.getCodigo();
	}

}