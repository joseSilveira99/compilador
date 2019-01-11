package principal;

import java.awt.Color;
import java.util.Stack;

public class SetaTabela {
	static Stack<Token> pilhaToken = new Stack<Token>();
	static Token ultRemovido;
	static Stack<Token> pilhaParser = new Stack<Token>();
	static int nivel = 0;
	static String categoria, tipo, concatena = "";
	static boolean tudook;
	public static void setarTab(Token token) {
		//Se o token analisado for nulo não sera adicionado a pilha
		//o mesmo equivale para o caso do token estiver em um comentario
		//para o caso do token ser um literal é mudado o valor do token
		Token token2;
		if(token != null) {
			if(PegaCar.comentario == false) {
				if(PegaCar.literal) {
					token2 = new Token(concatena+token.getPalavra());
					token2.setCodigo(48);
				    pilhaToken.pop();
		            pilhaToken.add(token2);
		            concatena = token.getPalavra();
				}else {
					if(PegaCar.secret == false) {
					pilhaToken.add(token);
					}else {
						PegaCar.secret = false;
					}
				}
		}
		}
	}
	public static void remove() {
		pilhaToken.pop();
	}
	public static void AddTab() {
		for(int i=0; i<pilhaToken.size(); i++) {
   		 if(pilhaToken.get(i) != null) {
   		 Compilador.modeloConsultas.addRow(new Object[] {pilhaToken.get(i).getCodigo(), pilhaToken.get(i).getPalavra()});
        }
		}
	}
	
	public static void Analise() {
		pilhaParser.push(new Token(TabelaMapa.PROGRAMA, "PROGRAMA"));
		do {
		if(pilhaParser.peek().getCodigo() <= 51) {// x é terminal
			if(pilhaParser.peek().getCodigo().equals(pilhaToken.get(0).getCodigo())) {//x = a
				ultRemovido = pilhaToken.get(0);
				pilhaParser.pop();
				pilhaToken.remove(0);
			}else {
				Compilador.textAreaConsole.setForeground(Color.RED);
                Compilador.textAreaConsole.setText("Foi encontrado um erro sintatico, antes da declaracao de "+pilhaToken.get(0).getPalavra()+ "linha "+pilhaToken.get(0).getLinha());//arrumar a linha
                tudook = false;
                pilhaParser.clear();
                break;
			}
	        }else {//caiu aqui entao x é nao terminal
			if(pilhaParser.peek().getCodigo().equals(52)) {
				if(pilhaToken.get(0).getCodigo().equals(1)) {
				ultRemovido = pilhaToken.get(0);
				pilhaParser.pop();
				pilhaParser.push(new Token(TabelaMapa.PONTO, "PONTO"));
				pilhaParser.push(new Token(TabelaMapa.BLOCO, "BLOCO"));
				pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
				pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
				pilhaParser.push(new Token(TabelaMapa.PROGRAM, "PROGRAM"));
				}else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
	                  Compilador.textAreaConsole.setText("Deve-se começar com PROGRAM. "+ "linha "+pilhaToken.get(0).getLinha());
	                  tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(53)) {
				categoria = "LABEL";
				tipo = "LITERAL";
				if(pilhaToken.get(0).getCodigo().equals(2)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
					pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
					pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
				}else if(pilhaToken.get(0).getCodigo().equals(3)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
					pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
					pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
				}else if(pilhaToken.get(0).getCodigo().equals(4)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
					pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
					pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
					pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
					pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
					pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
					pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
				}else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
	                  Compilador.textAreaConsole.setText("erro apos o ; inicial. Espera-se label, const, var, procedure ou begin. "+ "linha "+pilhaToken.get(0).getLinha());
	                  tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(54)) {
				if(pilhaToken.get(0).getCodigo().equals(2)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.LID, "LID"));
					pilhaParser.push(new Token(TabelaMapa.LABEL, "LABEL"));
				}else if(pilhaToken.get(0).getCodigo().equals(3)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(4)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
				    pilhaParser.clear();
	                break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(55)) {
				if(pilhaToken.get(0).getCodigo().equals(25)) {
					if(pilhaToken.get(1).getCodigo().equals(39)) {
						if(ultRemovido.getPalavra().equals("(")) {
							categoria = "PARAMETRO";
							nivel = 1;
						}
					}
					//try {
						Semantico.insercao(new TabelaSimbolos(pilhaToken.get(0).getPalavra(), categoria, tipo, nivel, pilhaToken.get(0).getLinha()));
					/*} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPIDENT, "REPIDENT"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
				}else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("esperando um identificador apos o label."+ " linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
	                pilhaParser.clear();
	                break;
				}
				
			}else if(pilhaParser.peek().getCodigo().equals(56)) {
				if(pilhaToken.get(0).getCodigo().equals(46)) {
					//try {
						Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel,pilhaToken.get(1).getLinha()));
					/*} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPIDENT, "REPIDENT"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.VIRGULA, ","));
				}
				else if(pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(39)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Faltando virgula, ponto e virgula ou dois pontos no token "+pilhaToken.get(0).getPalavra()+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
	                pilhaParser.clear();
	                break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(57)) {
				categoria = "CONST";
				tipo = "INTEGER";
				if(pilhaToken.get(0).getCodigo().equals(3)) {
					//try {
						Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel, pilhaToken.get(1).getLinha()));
					/*} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.LDCONST, "LDCONST"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.IGUAL, "="));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.CONST, "CONST"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(4)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(58)) {
				if(pilhaToken.get(0).getCodigo().equals(4)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(25)) {
					//try {
						Semantico.insercao(new TabelaSimbolos(pilhaToken.get(0).getPalavra(), categoria, tipo, nivel, pilhaToken.get(0).getLinha()));
					/*} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.LDCONST, "LDCONST"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.IGUAL, "="));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}else if(pilhaParser.peek().getCodigo().equals(59)) {
				categoria = "VAR";
				if(pilhaToken.get(0).getCodigo().equals(4)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.LDVAR, "LDVAR"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.TIPO, "TIPO"));
					pilhaParser.push(new Token(TabelaMapa.DOISPONTOS, ":"));
					pilhaParser.push(new Token(TabelaMapa.LID, "LID"));
					pilhaParser.push(new Token(TabelaMapa.VAR, "VAR"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(60)) {
				if(pilhaToken.get(0).getCodigo().equals(5)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.LDVAR, "LDVAR"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.TIPO, "TIPO"));
					pilhaParser.push(new Token(TabelaMapa.DOISPONTOS, ":"));
					pilhaParser.push(new Token(TabelaMapa.LID, "LID"));
					
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(61)) {
				if(pilhaToken.get(0).getCodigo().equals(8)) {
					tipo = "INTEGER";
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.INTEGER, "INTEGER"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(9)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.INTEGER, "INTEGER"));
					pilhaParser.push(new Token(TabelaMapa.OF, "OF"));
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_E, "]"));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_PONTO, ".."));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_D, "["));
					pilhaParser.push(new Token(TabelaMapa.ARRAY, "ARRAY"));
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
				
			}
			else if(pilhaParser.peek().getCodigo().equals(62)) {
				if(pilhaToken.get(0).getCodigo().equals(5)) {
					//try {
						Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), "PROCEDURE", "PROCEDURE", 0, pilhaToken.get(1).getLinha()));
					/*} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.BLOCO, "BLOCO"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
					pilhaParser.push(new Token(TabelaMapa.DEFPAR, "DEFPAR"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.PROCEDURE, "PROCEDURE"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo. "+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(63)) {
				if(pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_E, ")"));
					pilhaParser.push(new Token(TabelaMapa.INTEGER, "INTEGER"));
					pilhaParser.push(new Token(TabelaMapa.DOISPONTOS, ":"));
					pilhaParser.push(new Token(TabelaMapa.LID, "LID"));
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_D, "("));
				}
				else if(pilhaToken.get(0).getCodigo().equals(39)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(64)) {
				if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.END, "END"));
					pilhaParser.push(new Token(TabelaMapa.REPCOMANDO, "REPCOMANDO"));
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.BEGIN, "BEGIN"));
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
	                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
	                tudook = false;
					pilhaParser.clear();
	                break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(65)) {
				if (pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPCOMANDO, "REPCOMANDO"));
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
				}
				else {
					Compilador.textAreaConsole.setForeground(Color.RED);
					Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
					tudook = false;
					pilhaParser.clear();
					break;
				}
			}
			else if (pilhaParser.peek().getCodigo().equals(66)) {
				if(pilhaToken.get(0).getCodigo().equals(6)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					nivel = 0;
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(11)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARAMETROS, "PARAMETROS"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.CALL, "CALL"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(12)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.GOTO, "GOTO"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(13)) {
					if(!pilhaToken.get(2).getCodigo().equals(26)) {
						Semantico.busca(pilhaToken.get(2).getPalavra(),pilhaToken.get(2).getCodigo(), nivel, pilhaToken.get(2).getLinha());	
					}
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.ELSEPARTE, "ELSEPARTE"));
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.THEN, "THEN"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.IF, "IF"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(16)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.DO, "DO"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.WHILE, "WHILE"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(18)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.UNTIL, "UNTIL"));
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.REPEAT, "REPEAT"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(20)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_E, ")"));
					pilhaParser.push(new Token(TabelaMapa.REPVARIAVEL, "REPVARIAVEL"));
					pilhaParser.push(new Token(TabelaMapa.VARIAVEL, "VARIAVEL"));
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_D, "("));
					pilhaParser.push(new Token(TabelaMapa.READLN, "READLN"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(21)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_E, ")"));
					pilhaParser.push(new Token(TabelaMapa.REPITEM, "REPITEM"));
					pilhaParser.push(new Token(TabelaMapa.ITEMSAIDA, "ITEMSAIDA"));
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_D, "("));
					pilhaParser.push(new Token(TabelaMapa.WRITELN, "WRITELN"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.RCOMID, "RCOMID"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					
				}
				else if(pilhaToken.get(0).getCodigo().equals(27)) {
					Semantico.busca(pilhaToken.get(1).getPalavra(), pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(0).getLinha());
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.DO, "DO"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.TO, "TO"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.ATRIBUICAO, ":="));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					pilhaParser.push(new Token(TabelaMapa.FOR, "FOR"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(29)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.END, "END"));
					pilhaParser.push(new Token(TabelaMapa.CONDCASE, "CONDCASE"));
					pilhaParser.push(new Token(TabelaMapa.OF, "OF"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.CASE, "CASE"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		              Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo "+ "linha "+pilhaToken.get(0).getLinha());
		              tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(67)) {
					if (ultRemovido.getCodigo().equals(25)) {
						Semantico.verificaConst(ultRemovido.getPalavra(), nivel, pilhaToken.get(0).getLinha());
					}
					Semantico.busca(ultRemovido.getPalavra(),ultRemovido.getCodigo(), nivel, pilhaToken.get(0).getLinha());
					Semantico.busca(pilhaToken.get(1).getPalavra(),pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(0).getLinha());	
				if(pilhaToken.get(0).getCodigo().equals(34)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.ATRIBUICAO, ":="));
					pilhaParser.push(new Token(TabelaMapa.RVAR, "RVAR"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(38)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.ATRIBUICAO, ":="));
					pilhaParser.push(new Token(TabelaMapa.RVAR, "RVAR"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(39)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.DOISPONTOS, ":"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		              Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		              tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(68)) {
				if(pilhaToken.get(0).getCodigo().equals(34)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_E, "]"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_D, "["));
				}
				else if(pilhaToken.get(0).getCodigo().equals(38)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		              Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		              tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(69)) {
				if (Semantico.verificaExistencia(ultRemovido.getPalavra(), nivel) == false) {
					tudook = false;
					Compilador.textAreaConsole.setForeground(Color.RED);
		            Compilador.textAreaConsole.setText(ultRemovido.getPalavra()+" nao foi declarado anteriormente "+"linha "+pilhaToken.get(0).getLinha());
				}
				Semantico.verificaTipoParametro(ultRemovido.getPalavra(), pilhaToken.get(1).getPalavra(), pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(0).getLinha());
				
				if(pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				if(pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_E, ")"));
					pilhaParser.push(new Token(TabelaMapa.REPPAR, "REPPAR"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_D, "("));
				}
				else if(pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontradono Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(70)) {
				if(pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPPAR, "REPPAR"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.VIRGULA, ","));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(71)) {
				if(pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.ELSE, "ELSE"));
				}
				else if(pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if(pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(72)) {
				Semantico.busca(pilhaToken.get(0).getPalavra(),pilhaToken.get(0).getCodigo(), nivel, pilhaToken.get(0).getLinha());
				if(pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.VARIAVEL1, "VARIAVEL1"));
					pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(73)) {
				if (pilhaToken.get(0).getCodigo().equals(32) || pilhaToken.get(0).getCodigo().equals(45) || pilhaToken.get(0).getCodigo().equals(41) || pilhaToken.get(0).getCodigo().equals(43) || pilhaToken.get(0).getCodigo().equals(30)) {
					Semantico.busca(ultRemovido.getPalavra(),ultRemovido.getCodigo(), nivel, pilhaToken.get(0).getLinha());
						Semantico.busca(pilhaToken.get(1).getPalavra(),pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(1).getLinha());											
				}

			    if(pilhaToken.get(0).getCodigo().equals(7)) {
			    	Semantico.ant = null;
			    	Semantico.xx = true;
			    	Semantico.delecao();
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(10)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(14)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(15)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(17)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(19)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(22)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(23)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(28)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(30)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(31)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(32)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(33)) {
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(34)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_D, "]"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.CONCHETE_E, "["));
				}
			    else if(pilhaToken.get(0).getCodigo().equals(35)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(37)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(40)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(41)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(42)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(43)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(44)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(45)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(46)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else if(pilhaToken.get(0).getCodigo().equals(47)) {
			    	ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
			    else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
				}
			}
			else if(pilhaParser.peek().getCodigo().equals(74)) {
				
				if(pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				 else if(pilhaToken.get(0).getCodigo().equals(46)) {
					 ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.REPVARIAVEL, "REPVARIAVEL"));
						pilhaParser.push(new Token(TabelaMapa.VARIAVEL, "VARIAVEL"));
						pilhaParser.push(new Token(TabelaMapa.VIRGULA, ","));
				}
				 else {
						  Compilador.textAreaConsole.setForeground(Color.RED);
			                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
			                tudook = false;
						  pilhaParser.clear();
		                  break;
				}
			}
			else if (pilhaParser.peek().getCodigo().equals(75)) {
				if (pilhaToken.get(0).getCodigo().equals(24)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					
				}
				else if (pilhaToken.get(0).getCodigo().equals(26)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(30)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(31)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(48)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.LITERAL, "LITERAL"));
				}
				 else {
						  Compilador.textAreaConsole.setForeground(Color.RED);
			                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
			                tudook = false;
						  pilhaParser.clear();
		                  break;
				}
			}
			else if (pilhaParser.peek().getCodigo().equals(76)) {
				if (pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPITEM, "REPITEM"));
					pilhaParser.push(new Token(TabelaMapa.ITEMSAIDA, "ITEMSAIDA"));
					pilhaParser.push(new Token(TabelaMapa.VIRGULA, "VIRGULAR"));
				}
				 else {
						  Compilador.textAreaConsole.setForeground(Color.RED);
			                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
			                tudook = false;
						  pilhaParser.clear();
		                  break;
				}
			}
			else if (pilhaParser.peek().getCodigo().equals(77)) {			
				if (pilhaToken.get(0).getCodigo().equals(24)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(25)) {
					Semantico.busca(pilhaToken.get(0).getPalavra(),pilhaToken.get(0).getCodigo(), nivel, pilhaToken.get(0).getLinha());
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					
				}
				else if (pilhaToken.get(0).getCodigo().equals(26)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(30)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(31)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXPSIMP, "REPEXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(78)) {
				if (pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(10)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(14)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(17)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(28)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(35)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(40)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.IGUAL, "="));
				}
				else if (pilhaToken.get(0).getCodigo().equals(41)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.MAIOR, ">"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(42)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.MAIORIGUAL, ">="));
				}
				else if (pilhaToken.get(0).getCodigo().equals(43)) {
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.MENOR, "<"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(44)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.MENORIGUAL, "<="));
				}
				else if (pilhaToken.get(0).getCodigo().equals(45)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.EXPSIMP, "EXPSIMP"));
					pilhaParser.push(new Token(TabelaMapa.DIFERENTE, "<>"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(79)) {
				if (pilhaToken.get(0).getCodigo().equals(24)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					
				}
				else if (pilhaToken.get(0).getCodigo().equals(26)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(30)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					pilhaParser.push(new Token(TabelaMapa.OP_SOMA, "+"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(31)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					pilhaParser.push(new Token(TabelaMapa.OP_SUB, "-"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		              Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		              tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(80)) {
				if (pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(10)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(14)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(17)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(22)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					pilhaParser.push(new Token(TabelaMapa.OR, "OR"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(28)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(30)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					pilhaParser.push(new Token(TabelaMapa.OP_SOMA, "+"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(31)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPEXP, "REPEXP"));
					pilhaParser.push(new Token(TabelaMapa.TERMO, "TERMO"));
					pilhaParser.push(new Token(TabelaMapa.OP_SUB, "-"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(35)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(40)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(41)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(42)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(43)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(44)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(45)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(81)) {
				if (pilhaToken.get(0).getCodigo().equals(24)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(25)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
					
				}
				else if (pilhaToken.get(0).getCodigo().equals(26)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(36)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(82)) {
				if (pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(10)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(14)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(15)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(17)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(19)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(22)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(23)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
					pilhaParser.push(new Token(TabelaMapa.AND, "AND"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(28)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(30)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(31)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(32)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
					pilhaParser.push(new Token(TabelaMapa.OP_MULT, "*"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(33)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.REPTERMO, "REPTERMO"));
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
					pilhaParser.push(new Token(TabelaMapa.OP_DIVI, "/"));
				}
				else if (pilhaToken.get(0).getCodigo().equals(35)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(37)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(40)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(41)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(42)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(43)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(44)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(45)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(83)) {
			 if (pilhaToken.get(0).getCodigo().equals(24)) {
				 ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.FATOR, "FATOR"));
					pilhaParser.push(new Token(TabelaMapa.NOT, "NOT"));
				}
			 else if (pilhaToken.get(0).getCodigo().equals(25)) {
				 ultRemovido = pilhaToken.get(0);
				 	pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.VARIAVEL, "VARIAVEL"));
					
				}
			 else if (pilhaToken.get(0).getCodigo().equals(26)) {
				 ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
				}
			 else if (pilhaToken.get(0).getCodigo().equals(36)) {
				 ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_E, ")"));
					pilhaParser.push(new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO"));
					pilhaParser.push(new Token(TabelaMapa.PARENTESE_D, "("));
				}
			 else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(84)) {
				if (pilhaToken.get(0).getCodigo().equals(26)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CONTCASE, "CONTCASE"));
					pilhaParser.push(new Token(TabelaMapa.COMANDO, "COMANDO"));
					pilhaParser.push(new Token(TabelaMapa.DOISPONTOS, ":"));
					pilhaParser.push(new Token(TabelaMapa.RPINTEIRO, "RPINTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(85)) {
				if (pilhaToken.get(0).getCodigo().equals(7)) {
					Semantico.ant = null;
					Semantico.xx = true;
					Semantico.delecao();
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(47)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.CONDCASE, "CONDCASE"));
					pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
			else if (pilhaParser.peek().getCodigo().equals(86)) {
				if (pilhaToken.get(0).getCodigo().equals(39)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
				}
				else if (pilhaToken.get(0).getCodigo().equals(46)) {
					ultRemovido = pilhaToken.get(0);
					pilhaParser.pop();
					pilhaParser.push(new Token(TabelaMapa.RPINTEIRO, "RPINTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
					pilhaParser.push(new Token(TabelaMapa.VIRGULA, "VIRGULA"));
				}
				else {
					  Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					  pilhaParser.clear();
	                  break;
			}
			}
				else {
				  Compilador.textAreaConsole.setForeground(Color.RED);
	              Compilador.textAreaConsole.setText("Foi encontrado um erro sintatico, antes da declaracao de "+pilhaToken.get(0).getPalavra()+ "linha "+pilhaToken.get(0).getLinha());//arrumar a linha
	              tudook = false;
				  pilhaParser.clear();
				  break;
			}
		}
		}while(!pilhaParser.isEmpty());
		if(tudook) {
			Compilador.textAreaConsole.setForeground(Color.GREEN);
			Compilador.textAreaConsole.setText("Leitura realizada com sucesso.");
		}
	}
}
