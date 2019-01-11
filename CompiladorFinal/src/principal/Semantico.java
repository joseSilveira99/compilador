package principal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Semantico {
	public static List<TabelaSimbolos> tabsimbolo = new ArrayList<TabelaSimbolos>();
	public static List<String> arrayTeste = new ArrayList<String>();
	static TabelaSimbolos ant = null;
	static boolean xx = true;
	
	public static void insercao(TabelaSimbolos obj) {
		if(verificaExistencia(obj.getNome(), obj.getNivel())) { 
			 Compilador.textAreaConsole.setForeground(Color.RED);
             Compilador.textAreaConsole.setText(obj.getCategoria()+" "+obj.getNome()+" ja foi declarado anteriormente "+"linha "+obj.getLinha());
             SetaTabela.tudook = false;
		}else {
			tabsimbolo.add(obj);
		}
	}
	public static boolean verificaExistencia(String obj, int niv) {
		boolean var = false;
		for (int i = 0; i < tabsimbolo.size(); i++) {
			if (tabsimbolo.get(i).getNome().equals(obj) && tabsimbolo.get(i).getNivel().equals(niv)) {
				var =  true;
			}
		}
		return var;
	}
	public static TabelaSimbolos retornaIdentificadorDeclarado(String obj, int niv) {
		for (int i = 0; i < tabsimbolo.size(); i++) {
			if (tabsimbolo.get(i).getNome().equals(obj) && tabsimbolo.get(i).getNivel().equals(niv)) {
				return new TabelaSimbolos(tabsimbolo.get(i).getNome(), tabsimbolo.get(i).getCategoria(), tabsimbolo.get(i).getTipo(), tabsimbolo.get(i).getNivel(), tabsimbolo.get(i).getLinha());
			}
		}
		return null;
	}
	public static void busca(String nome, Integer cod, Integer nivel, Integer linha) {
		TabelaSimbolos ts;
		if(cod.equals(26)) {
		ts = new TabelaSimbolos(nome, "VARIAVEL", "INTEGER", nivel, linha);
		}else if (cod.equals(48)) {
			ts = new TabelaSimbolos(nome, "ROTULO", "LITERAL", nivel, linha);
		}else {
			ts = retornaIdentificadorDeclarado(nome, nivel);
			if (ts != null) {
				ts.setLinha(linha);
			}
		}
		if(ts != null) {
			testeTipo(ts);
		}else {
			SetaTabela.tudook = false;
			Compilador.textAreaConsole.setForeground(Color.RED);
			Compilador.textAreaConsole.setText("Identificador "+nome+" não foi declarado neste escopo linha "+linha);
		}
	}
	public static void delecao() {
		for (int i = tabsimbolo.size()-1; i > 0; i--) {
			if (tabsimbolo.get(i).getNivel() == 1) {
				tabsimbolo.remove(i);
			}
		}
	}
	public static void listar() {
		for (int i = 0; i < tabsimbolo.size(); i++) {
			System.out.println("Nome "+tabsimbolo.get(i).getNome() +" Categoria "+ tabsimbolo.get(i).getCategoria() +" Tipo "+ tabsimbolo.get(i).getTipo() +" Nivel "+ tabsimbolo.get(i).getNivel());
		}
	}
	public static void verificaConst(String nome, Integer nivel, Integer linha) {
		TabelaSimbolos ts;
		ts = retornaIdentificadorDeclarado(nome, nivel);
		if(ts != null) {
			if (ts.getCategoria().equals("CONST")) {
				 SetaTabela.tudook = false;
				 Compilador.textAreaConsole.setForeground(Color.RED);
	             Compilador.textAreaConsole.setText("Voce nao pode modificar o valor da CONST "+ts.getNome()+" linha "+linha);
			}
		}else {
			SetaTabela.tudook = false;
			Compilador.textAreaConsole.setForeground(Color.RED);
			Compilador.textAreaConsole.setText("Identificador "+nome+" não foi declarado neste escopo linha "+linha);
		}
	}
	public static void verificaTipoParametro(String nomeProce, String nomeIden, Integer cod, Integer nivel, Integer linha) {
		//if (cod != 26) {
			if (cod.equals(25)) {
				TabelaSimbolos ts;
				ts = retornaIdentificadorDeclarado(nomeIden, nivel);
				if (ts == null) {
					SetaTabela.tudook = false;
					Compilador.textAreaConsole.setForeground(Color.RED);
					Compilador.textAreaConsole.setText("Identificador "+nomeIden+" não foi declarado neste escopo linha "+linha);
				}else if (ts.getTipo() != "INTEGER") {
					SetaTabela.tudook = false;
					Compilador.textAreaConsole.setForeground(Color.RED);
					Compilador.textAreaConsole.setText("Passagem de parametro nao associavel com a procedure "+nomeProce+" linha "+linha+" esperando identificador do tipo INTEGER");
					try {
						System.out.wait();
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
				}
			}
	}
	public static void testeTipo(TabelaSimbolos ts) {
		if (xx == true) {
			ant = ts;	
		}
		if (ts != null && ant != null) {
			System.out.println(ant.getNome()+" "+ant.getCategoria()+" "+ant.getTipo()+" "+ant.getNivel()+" "+ant.getLinha());
			System.out.println(ts.getNome()+" "+ts.getCategoria()+" "+ts.getTipo()+" "+ts.getNivel()+" "+ts.getLinha());
			if (ant.getTipo() != ts.getTipo()) {
				 SetaTabela.tudook = false;
				 Compilador.textAreaConsole.setForeground(Color.RED);
	             //Compilador.textAreaConsole.setText("Tipo do identicador "+ant.getCategoria()+" "+ant.getNome()+" e diferente do identificador "+ts.getCategoria()+" "+ts.getNome());
	             Compilador.textAreaConsole.setText("Voce nao pode comparar um "+ts.getCategoria()+" do tipo "+ts.getTipo()+" a um "+ant.getCategoria()+" do tipo "+ant.getTipo()+" linha "+ts.getLinha());
	             try {
					System.out.wait();
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
			}
		}
		xx = false;
		ant = ts;
	}
}