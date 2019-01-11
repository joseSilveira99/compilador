package principal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arquivos.Arquivos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Compilador extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea, textAreaConsole, textAreaCont;
	private JTable table;
	public static DefaultTableModel modeloConsultas = new DefaultTableModel();
	public static String attCaminho;
	public static String prox2;
	public static Token prox;
	public static boolean var = true;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compilador frame = new Compilador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Compilador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 628);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JToggleButton tglbtnGravar = new JToggleButton("");
		tglbtnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attCaminho = ProcurarArq();
				textArea.setText(Arquivos.ler(attCaminho));
				textAreaCont.setText("");
				contaLinhaEnter(textArea, textAreaCont);
			}
		});
		tglbtnGravar.setBackground(Color.LIGHT_GRAY);
		tglbtnGravar.setIcon(new ImageIcon("img\\abrir.png"));
		menuBar.add(tglbtnGravar);
		
		JToggleButton toggleButtonSalvar = new JToggleButton("");
		toggleButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attCaminho = SalvaArq();
				Arquivos.gravar(textArea.getText(), attCaminho, false);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
		});
		toggleButtonSalvar.setBackground(Color.LIGHT_GRAY);
		toggleButtonSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		menuBar.add(toggleButtonSalvar);
		JToggleButton toggleButtonSaveDire = new JToggleButton("");
		toggleButtonSaveDire.setBackground(Color.LIGHT_GRAY);
		toggleButtonSaveDire.setIcon(new ImageIcon("img\\savedire.png"));
		toggleButtonSaveDire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arquivos.gravar(textArea.getText(), attCaminho, false);
			}
		});
		menuBar.add(toggleButtonSaveDire);
		
		JToggleButton toggleButtonPlay = new JToggleButton("");
		toggleButtonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaConsole.setText("");
				modeloConsultas.setNumRows(0);
				SetaTabela.pilhaToken.clear();
				SetaTabela.pilhaParser.clear();
				Semantico.tabsimbolo.clear();
				//TabelaMapa.guardaNome.clear();
				Semantico.xx = true;
				SetaTabela.tudook = true;
				var = true;
                incioCompi(attCaminho);
			}
		});
		toggleButtonPlay.setBackground(Color.LIGHT_GRAY);
		toggleButtonPlay.setIcon(new ImageIcon("img\\play.png"));
		menuBar.add(toggleButtonPlay);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		
		//JScrollPane scrollPaneCodigo = new JScrollPane();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneTabela, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						.addComponent(scrollPaneTabela, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
		);
		/*txtCont = new JTextArea();
        txtCont.setForeground(Color.RED);
        txtCont.setText("1");
        txtCont.setEditable(false);
        jScrollPane.setRowHeaderView(txtCont);
        txtEditor = new JTextArea();
        jScrollPane.setViewportView(txtEditor);*/
        
		textAreaCont = new JTextArea();
		textAreaCont.setBackground(new Color(248, 248, 255));
		textAreaCont.setForeground(new Color(255, 0, 0));
		textAreaCont.setText("1      ");
		textAreaCont.setEditable(false);
		scrollPane.setRowHeaderView(textAreaCont);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					contaLinhaEnter(textArea,textAreaCont);
				}
				else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					contaLinhaBack(textArea,textAreaCont);	
				}
				else if(evt.getKeyCode() == evt.VK_CONTROL) {
					contaLinhaBack(textArea,textAreaCont);	
				}
				else if(evt.getKeyCode() == evt.VK_DELETE) {
					contaLinhaBack(textArea,textAreaCont);	
				}
			}
		});
		textArea.setForeground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		
		table = new JTable(modeloConsultas);
		scrollPaneTabela.setViewportView(table);
		modeloConsultas.addColumn("Codigo");
		modeloConsultas.addColumn("Palavra");
		
		JPanel panelConsole = new JPanel();
		tabbedPane.addTab("Console", null, panelConsole, null);
		
		JScrollPane scrollPaneConsole = new JScrollPane();
		GroupLayout gl_panelConsole = new GroupLayout(panelConsole);
		gl_panelConsole.setHorizontalGroup(
			gl_panelConsole.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneConsole, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
		);
		gl_panelConsole.setVerticalGroup(
			gl_panelConsole.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsole.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPaneConsole, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
		);
		
		textAreaConsole = new JTextArea();
		textAreaConsole.setEditable(false);
		textAreaConsole.setForeground(Color.BLACK);
		scrollPaneConsole.setViewportView(textAreaConsole);
		panelConsole.setLayout(gl_panelConsole);
		
		JPanel panelSecundario = new JPanel();
		tabbedPane.addTab("Secundario", null, panelSecundario, null);
		
		JScrollPane scrollPaneSecundario = new JScrollPane();
		GroupLayout gl_panelSecundario = new GroupLayout(panelSecundario);
		gl_panelSecundario.setHorizontalGroup(
			gl_panelSecundario.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneSecundario, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
		);
		gl_panelSecundario.setVerticalGroup(
			gl_panelSecundario.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneSecundario, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
		);
		
		JTextArea textAreaSecundario = new JTextArea();
		textAreaSecundario.setEditable(false);
		scrollPaneSecundario.setViewportView(textAreaSecundario);
		panelSecundario.setLayout(gl_panelSecundario);
		contentPane.setLayout(gl_contentPane);
	}
	public String ProcurarArq() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		fc.showOpenDialog(this);
		File selFile = fc.getSelectedFile();
		return selFile.getPath();
	}
	public String SalvaArq() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		fc.showSaveDialog(this);
		File selFile = fc.getSelectedFile();
		return selFile.getPath();
	}
	
	private void incioCompi(String caminho) {
		try {
			PegaProx pegaProx = new PegaProx(caminho);
			prox = PegaProx.getProx();
			PegaCar pegarcar = new PegaCar(caminho);
			Token token = pegarcar.getToken();
			SetaTabela.setarTab(token);
			while (token != null) {
				//System.out.println(token);
				token = pegarcar.getToken();
				
				SetaTabela.setarTab(token);
				if(token.getCodigo().equals(89)) {
					PegaCar.comentario = false;
				}else if(token.getPalavra().equals("'")) {
					PegaCar.literal = !PegaCar.literal;
				}
			}
			
		} catch (Exception e) {
			Token token = null;
			token = new Token(TabelaMapa.PONTO, ".");
			SetaTabela.setarTab(token);
			System.out.println(e.getMessage());
		//e.printStackTrace();
		}
		if(PegaCar.comentario) {
            textAreaConsole.setForeground(Color.RED);
			textAreaConsole.setText("Erro faltando fechar comentario ");
		}else if(var){
			SetaTabela.Analise();
			SetaTabela.AddTab();
			//Semantico.listar();
		}
	}
	
	public void contaLinhaEnter(JTextArea area, JTextArea cont) {
		String linhas ="";
		int i;
		for(i=0;i<area.getLineCount();i++) {
			linhas += +i+1+"       \n";
		}
		cont.setText(linhas);
	}
	public void contaLinhaBack(JTextArea area,JTextArea cont) {
		String linhas ="";
		int i;
		for(i=1;i<area.getLineCount();i++) {
			linhas += i+"       \n";
		}
		linhas += i;
		cont.setText(linhas);
	}
}
