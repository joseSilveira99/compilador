package principal;

import java.awt.Color;
import java.util.Stack;

public class Sintatico {
	private static int nivel = 0;
	private static String categoria, tipo, concatena = "";
	public static boolean tudook;
	public static Token ultRemovido = null;
	public static void Analise(Stack<Token> pilhaParser, Stack<Token> pilhaToken) {
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
					/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(0).getPalavra(), 4,26,nivel);
					s.insercao(obj);*/
					}else {
						  Compilador.textAreaConsole.setForeground(Color.RED);
		                  Compilador.textAreaConsole.setText("Deve-se começar com PROGRAM."+ "linha "+pilhaToken.get(0).getLinha());
		                  tudook = false;
						  pilhaParser.clear();
		                  break;
					}
				}else if(pilhaParser.peek().getCodigo().equals(53)) {
					//System.out.println("categoria? "+ pilhaToken.get(0).getPalavra());
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
					/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(1).getPalavra(), 2,2,nivel);
					s.insercao(obj);*/
					//System.out.println(pilhaToken.get(0).getPalavra()+ testes);
					}else if(pilhaToken.get(0).getCodigo().equals(3)) {
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
						pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
						pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
						pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
						pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
						/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(0).getPalavra(), 3,3,testes);
						s.insercao(obj);*/
						//System.out.println(pilhaToken.get(0).getPalavra()+testes);
					}else if(pilhaToken.get(0).getCodigo().equals(4)) {
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
						pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
						pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
						pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
						pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
						/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(0).getPalavra(), 4,4,nivel);
						s.insercao(obj);
						*/
						//System.out.println(pilhaToken.get(0).getPalavra()+testes);
					}
					else if(pilhaToken.get(0).getCodigo().equals(5)) {
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
						pilhaParser.push(new Token(TabelaMapa.DCLPROC, "DCLPROC"));
						pilhaParser.push(new Token(TabelaMapa.DCLVAR, "DCLVAR"));
						pilhaParser.push(new Token(TabelaMapa.DCLCONST, "DCLCONST"));
						pilhaParser.push(new Token(TabelaMapa.DCLROT, "DCLROT"));
						/*nivel = 2;
						TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(0).getPalavra(), 5,5,nivel);
						s.insercao(obj);*/
						//System.out.println(pilhaToken.get(0).getPalavra()+testes);
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
		                  Compilador.textAreaConsole.setText("erro apos o ; inicial. Espera-se label, const, var, procedure ou begin."+ "linha "+pilhaToken.get(0).getLinha());
		                  tudook = false;
						  pilhaParser.clear();
		                  break;
					}
					//if(pilhaToken.get(0).getCodigo().equals(25)) {}
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
					    pilhaParser.clear();
		                break;
					}
				}else if(pilhaParser.peek().getCodigo().equals(55)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//label_a, x, array_a, array_b, idd, label_a, x, array_a, array_b entraram aqui
					if(pilhaToken.get(0).getCodigo().equals(25)) {
						if(pilhaToken.get(1).getCodigo().equals(39)) {
							if(ultRemovido.getPalavra().equals("(")) {
								categoria = "PARAMETRO";
								nivel = 1;
							}
						}
						//System.out.println(">1 "+pilhaToken.get(0).getPalavra()+" categoria "+categoria+" tipo "+tipo+" nivel "+ nivel);
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(0).getPalavra(), categoria, tipo, nivel, pilhaToken.get(0).getLinha()));
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.REPIDENT, "REPIDENT"));
						pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
					}else {
						Compilador.textAreaConsole.setForeground(Color.RED);
		                Compilador.textAreaConsole.setText("esperando um identificador apos o label."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
		                pilhaParser.clear();
		                break;
					}
					
				}else if(pilhaParser.peek().getCodigo().equals(56)) {
					//System.out.println(">< "+pilhaToken.get(0).getPalavra());//virgulas, ponto e virgula dois pontos entraram aqui
					if(pilhaToken.get(0).getCodigo().equals(46)) {
						//System.out.println(">2 "+pilhaToken.get(1).getPalavra()+" categoria "+categoria+" tipo "+tipo+" nivel "+ nivel);
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel,pilhaToken.get(1).getLinha()));
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
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//const entrou aqui
					//System.out.println("categoria? "+ pilhaToken.get(0).getPalavra());
					categoria = "CONST";
					tipo = "INTEGER";
					if(pilhaToken.get(0).getCodigo().equals(3)) {
						//System.out.println(">3 "+pilhaToken.get(1).getPalavra()+" categoria "+categoria+" tipo "+tipo+" nivel "+ nivel);
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel, pilhaToken.get(1).getLinha()));
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.LDCONST, "LDCONST"));
						pilhaParser.push(new Token(TabelaMapa.PONTO_VIRGULA, ";"));
						pilhaParser.push(new Token(TabelaMapa.INTEIRO, "INTEIRO"));
						pilhaParser.push(new Token(TabelaMapa.IGUAL, "="));
						pilhaParser.push(new Token(TabelaMapa.IDENTIFICADOR, "IDENTIFICADOR"));
						pilhaParser.push(new Token(TabelaMapa.CONST, "CONST"));
						/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(0).getPalavra(), 3,3,testes);
						s.insercao(obj);*/
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
						//Compilador.textAreaConsole.setText("ERRO, "+pilhaParser.peek().getPalavra()+" e "+pilhaToken.get(0).getPalavra());
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
						pilhaParser.clear();
		                break;
					}
				}else if(pilhaParser.peek().getCodigo().equals(58)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//b e var nivel 0 junto com b e var nivel 1
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
						//System.out.println(">3 "+pilhaToken.get(0).getPalavra()+" categoria "+categoria+" tipo "+tipo+" nivel "+ nivel);
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(0).getPalavra(), categoria, tipo, nivel, pilhaToken.get(0).getLinha()));
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
						pilhaParser.clear();
		                break;
					}
				}else if(pilhaParser.peek().getCodigo().equals(59)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());// var nivel 0 e var nivel 1
					//System.out.println("categoria? "+ pilhaToken.get(0).getPalavra());
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
						pilhaParser.clear();
		                break;
					}
				}
				else if(pilhaParser.peek().getCodigo().equals(60)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//Array_a, array_b, procedure, array_a, array_b, begin entraram aqui
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
						pilhaParser.clear();
		                break;
					}
				}
				else if(pilhaParser.peek().getCodigo().equals(61)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//integer, array, array, integer, array, array
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
		                tudook = false;
						pilhaParser.clear();
		                break;
					}
					
				}
				else if(pilhaParser.peek().getCodigo().equals(62)) {
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());
					if(pilhaToken.get(0).getCodigo().equals(5)) {
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), "PROCEDURE", "PROCEDURE", 0, pilhaToken.get(1).getLinha()));
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
		                Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo."+ "linha "+pilhaToken.get(0).getLinha());
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
					/*System.out.println(">1 "+pilhaToken.get(0).getPalavra());
					System.out.println(">2 "+pilhaToken.get(1).getPalavra());*/
					/*TabelaSimbolos obj = new TabelaSimbolos(pilhaToken.get(1).getPalavra(), 1, 1, nivel);
					if(pilhaToken.get(1).getCodigo().equals(25)) {
						Semantico.busca(obj);	
					}*/
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
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//; e END
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
					/*System.out.println(">0 "+ultRemovido.getPalavra());
					System.out.println(">1 "+pilhaToken.get(0).getPalavra());//K(X), END, X, BEGIN, X, END, CALL, IF, BEGIN, END, BEGIN, END, WHILE, BEGIN, END, REPEAT, BEGIN, END, WRITELN, FOR, BEGIN, END, CASE... ETC
					System.out.println(">2 "+pilhaToken.get(1).getPalavra());
					System.out.println(">3 "+pilhaToken.get(2).getPalavra());*/
					/*for (int i = 0; i < pilhaToken.size(); i++) {
						if(pilhaToken.get(i).getCodigo().equals(25)) {
							System.out.println(pilhaToken.get(i).getPalavra()+" nivel "+nivel);
						}
					}*/
					if(pilhaToken.get(0).getCodigo().equals(6)) {
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						pilhaParser.push(new Token(TabelaMapa.CORPO, "CORPO"));
					}
					else if(pilhaToken.get(0).getCodigo().equals(7)) {
						Semantico.ant = null;
						Semantico.xx = true;
						Semantico.delecao();
						//Semantico.listar();
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
						/*System.out.println(">1 "+pilhaToken.get(0).getPalavra());
						System.out.println(">2 "+pilhaToken.get(1).getPalavra());
						System.out.println(">3 "+pilhaToken.get(2).getPalavra()); //**
	*/					//usar metodo busca para verificar o Semantico.busca(pilhaToken.get(3).getPalavra(),nivel);
						//pra verificar o final usado ex: > entao so pode usar variavel const ou var
						if(!pilhaToken.get(2).getCodigo().equals(26)) {
							Semantico.busca(pilhaToken.get(2).getPalavra(),pilhaToken.get(2).getCodigo(), nivel, pilhaToken.get(2).getLinha());	
						}
						/*System.out.println(">4 "+pilhaToken.get(3).getPalavra());
						System.out.println(">5 "+pilhaToken.get(4).getPalavra());//**
						
						try {
							Semantico.insercao(new TabelaSimbolos(pilhaToken.get(4).getPalavra(), categoria, tipo, nivel));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}*/
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
			              //Compilador.textAreaConsole.setText("Erro encontrado no Token "+pilhaToken.get(0).getPalavra()+" ou anteriormente do mesmo \nDerivacao Parsing "+pilhaParser.get(0).getCodigo()+ " linha "+pilhaToken.get(0).getLinha());
			              tudook = false;
						  pilhaParser.clear();
		                  break;
					}
				}
				else if(pilhaParser.peek().getCodigo().equals(67)) {
					/*System.out.println(">0 "+ultRemovido +" "+ categoria+" "+ tipo+" "+ nivel);
					System.out.println(">1 "+pilhaToken.get(0).getPalavra() +" "+ nivel);// 3 := , (BEGIN VARIAVEL E :=)
					System.out.println(">2 "+pilhaToken.get(1).getPalavra() +" "+  nivel);*/
					/*System.out.println(">3 "+pilhaToken.get(2).getPalavra() + nivel);
					System.out.println(">4 "+pilhaToken.get(3).getPalavra() + nivel);*/
					//if (!ultRemovido.getCodigo().equals(26) && !pilhaToken.get(1).getCodigo().equals(26)) {//verifica se foi declarado
						if (ultRemovido.getCodigo().equals(25)) {
							Semantico.verificaConst(ultRemovido.getPalavra(), nivel, pilhaToken.get(0).getLinha());
						}
						Semantico.busca(ultRemovido.getPalavra(),ultRemovido.getCodigo(), nivel, pilhaToken.get(0).getLinha());
						Semantico.busca(pilhaToken.get(1).getPalavra(),pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(0).getLinha());	
					//}
					/*Semantico.testeTipo(ultRemovido.getPalavra(), nivel, pilhaToken.get(0).getLinha()-1);
					Semantico.testeTipo(pilhaToken.get(1).getPalavra(), nivel, pilhaToken.get(1).getLinha());*/
					//Semantico.busca(pilhaToken.get(1).getPalavra(), nivel);
					//Semantico.busca(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel));// entrando numeros

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
					// mesmo resultado que 67
					//System.out.println(">1 "+pilhaToken.get(0).getPalavra());//3 :=
					/*System.out.println(">0 "+ultRemovido +" "+ nivel);
					System.out.println(">1 "+pilhaToken.get(0).getPalavra() +" "+ nivel);// 3 := , (BEGIN VARIAVEL E :=)
					System.out.println(">2 "+pilhaToken.get(1).getPalavra() +" "+  nivel);*/
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
					//call identificador(identificador); o primeiro call entra aqui, este e o parametro passado para as procedures
					//Semantico.insercao(new TabelaSimbolos(pilhaToken.get(1).getPalavra(), categoria, tipo, nivel));
					if (Semantico.verificaExistencia(ultRemovido.getPalavra(), nivel) == false) {
						tudook = false;
						Compilador.textAreaConsole.setForeground(Color.RED);
			            Compilador.textAreaConsole.setText(ultRemovido.getPalavra()+" nao foi declarado anteriormente "+"linha "+pilhaToken.get(0).getLinha());
					}
					/*System.out.println("1 "+ultRemovido.getPalavra());
					System.out.println("2 "+pilhaToken.get(0).getPalavra());
					System.out.println("3 "+pilhaToken.get(1).getPalavra());
					System.out.println("4 "+pilhaToken.get(2).getPalavra());*/
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
						/*System.out.println(">0 "+ultRemovido);
						System.out.println(">1 "+pilhaToken.get(0).getPalavra());
	*/					pilhaParser.pop();
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
					/*System.out.println(">1 "+pilhaToken.get(0).getPalavra());// ), ultimo de call ( 100 ')'
					System.out.println(">2 "+pilhaToken.get(1).getPalavra());
					System.out.println(">3 "+pilhaToken.get(2).getPalavra());
					System.out.println(">4 "+pilhaToken.get(3).getPalavra());*/

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
					/*System.out.println(">0 "+ultRemovido);
					System.out.println(">1 "+pilhaToken.get(0).getPalavra());//ELSE
					System.out.println(">2 "+pilhaToken.get(1).getPalavra());
					System.out.println(">3 "+pilhaToken.get(2).getPalavra());
					System.out.println(">4 "+pilhaToken.get(3).getPalavra());*/

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
					//System.out.println(">1 "+ultRemovido);
					/*System.out.println(">1 "+pilhaToken.get(0).getPalavra());// rever
					System.out.println(">2 "+pilhaToken.get(1).getPalavra());
					System.out.println(">3 "+pilhaToken.get(2).getPalavra());
					System.out.println(">4 "+pilhaToken.get(3).getPalavra());
					System.out.println(">5 "+pilhaToken.get(4).getPalavra());*/
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
					/*System.out.println("731 "+pilhaToken.get(0).getPalavra());
					System.out.println("732 "+pilhaToken.get(1).getPalavra());
					System.out.println("733 "+pilhaToken.get(2).getPalavra());
					System.out.println("734 "+pilhaToken.get(3).getPalavra());*/
					/*System.out.println(">0< "+ultRemovido);
					System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());
					System.out.println(">1< "+pilhaToken.get(0).getPalavra());*/

					if (pilhaToken.get(0).getCodigo().equals(32) || pilhaToken.get(0).getCodigo().equals(45) || pilhaToken.get(0).getCodigo().equals(41) || pilhaToken.get(0).getCodigo().equals(43) || pilhaToken.get(0).getCodigo().equals(30)) {
						/*System.out.println(">0< "+ultRemovido);
						System.out.println(">1< "+pilhaToken.get(0).getPalavra());
						System.out.println(">2< "+pilhaToken.get(1).getPalavra());*/
						Semantico.busca(ultRemovido.getPalavra(),ultRemovido.getCodigo(), nivel, pilhaToken.get(0).getLinha());
						//if (pilhaToken.get(1).getCodigo().equals(25)) {
							Semantico.busca(pilhaToken.get(1).getPalavra(),pilhaToken.get(1).getCodigo(), nivel, pilhaToken.get(1).getLinha());											
					//	}
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
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());
					System.out.println(">3< "+pilhaToken.get(2).getPalavra());
					System.out.println(">4< "+pilhaToken.get(3).getPalavra());rever*/
					if (pilhaToken.get(0).getCodigo().equals(37)) {
						ultRemovido = pilhaToken.get(0);
						pilhaParser.pop();
						/*x = new Token(TabelaMapa.EXPRESSAO, "EXPRESSAO");
						pilhaParser.push(x);*/
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
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());
					System.out.println(">3< "+pilhaToken.get(2).getPalavra());
					System.out.println(">4< "+pilhaToken.get(3).getPalavra());*/
					
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
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());
					System.out.println(">3< "+pilhaToken.get(2).getPalavra());
					System.out.println(">4< "+pilhaToken.get(3).getPalavra());*/
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
					//usar este para verificar o tipo de if(10>15), while(x<>0), until x > 10, 2 e 10 de for, A de case
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());
					System.out.println(">3< "+pilhaToken.get(2).getPalavra());
					System.out.println(">4< "+pilhaToken.get(3).getPalavra());*/
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
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());*/
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
					/*System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());*/
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
					/*System.out.println(">0< "+ultRemovido);
					System.out.println(">1< "+pilhaToken.get(0).getPalavra());
					System.out.println(">2< "+pilhaToken.get(1).getPalavra());*/
					//aqui entra o outro lado da expressao x := x * x; no topo tem * ai é so verificar o anterior e o proximo
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
						
						//Semantico.busca(pilhaToken.get(1).getPalavra(), nivel, pilhaToken.get(1).getLinha());
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
					//ultRemovido = pilhaToken.get(0).getPalavra();
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
			/*Compilador.textAreaConsole.setForeground(Color.GREEN);
			Compilador.textAreaConsole.setText("Leitura realizada com sucesso.");*/
			}while(!pilhaParser.isEmpty());
			if(tudook) {
				Compilador.textAreaConsole.setForeground(Color.GREEN);
				Compilador.textAreaConsole.setText("Leitura realizada com sucesso.");
			}
		}

}
