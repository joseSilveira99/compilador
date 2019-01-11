package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Arquivos {
	public static String ler(String nomeArquivo){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "+ ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "+ ex.getMessage());
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "+ ex.getMessage());
                }
            }
        }
        return null;
    }
	public static void gravar(String msg, String caminho, boolean save) {
		try {
			FileWriter fw = new FileWriter(caminho, save);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(msg+"\r\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
