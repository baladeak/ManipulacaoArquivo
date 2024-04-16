package arquivos;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Arquivos {

    public static void main(String[] args) throws IOException {
        Manipulador.main(1);
    }

    public static void lerCriarDiretorio() {
        File diretorio = new File("dsadsadsa");
        if (!diretorio.exists()) {
            int resp = JOptionPane.showConfirmDialog(null, "Diretório não existe existe, deseja criar um novo?");
            if (resp == 0) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome do diretório");
                File diretorio2 = new File(nome);
                diretorio2.mkdir();

            }
        } else {
            //caso seja um diretório, é possível listar seus arquivos e diretórios
            File[] arquivos = diretorio.listFiles();

            int i = 0;

            while (i < arquivos.length) {

                System.out.println(arquivos[i].toString().replace(".\\", ""));

                i++;
            }
            //     System.out.println(Arrays.toString(arquivos));
        }
    }

    public static void lerAqruivo(String caminhoArquivo) throws FileNotFoundException, IOException {

        try {
            File file = new File(caminhoArquivo);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo não existe");
            } else {
                try (FileReader fr = new FileReader(file); var br = new BufferedReader(fr)) {
                    while (br.ready()) {

                        Manipulador.txt.setText(br.readLine());

                    }
                    fr.close();
                    br.close();
                }
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void lerArquivo() throws FileNotFoundException, IOException {

        try {
            File file = new File("peixe.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo não existe");
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while (br.ready()) {

                linha = br.readLine();

                System.out.println(linha);
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void escreverArquivo(String caminhoArquivo) throws IOException {
        File arquivo;
        FileWriter fw= null;
        BufferedWriter bw = null;
        try {
            arquivo = new File(caminhoArquivo);

            fw = new FileWriter(arquivo);
            bw = new BufferedWriter(fw);

            System.out.println("EscreverArquivotxt = " + Manipulador.txt.getText());
            bw.write(Manipulador.txt.getText());
            

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Escrita realizada com sucesso!");
        }

    }

    public static void escreverArquivo() throws IOException {
        File arquivo = new File("peixe.txt");
        try {
            if (!arquivo.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo não existe, criando um novo...");
                arquivo.createNewFile();
            }
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("\nOlá à todes");

            bf.close();
            fw.close();
        } catch (HeadlessException | IOException e) {

        }
    }

    public static void verificarChar() {
        /*
        // Define a string
        String str = "programação";

        // Define o caractere para contar
        char charParaContar = 'a';
        String texto = "pr";

        // Conta as ocorrências do caractere
        long contagem = str.chars().filter(ch -> ch == charParaContar).count();

        // Imprime o resultado
        System.out.println("O caractere '" + charParaContar + "' aparece " + contagem + " vezes na string.");
         */
        // Define a string
        String str = "programação, programação, programação";

        // Define a substring para contar
        String substringParaContar = "cho";

        // Conta as ocorrências da substring
        int contagem = (str.length() - str.replace(substringParaContar, "").length()) / substringParaContar.length();
        System.out.println(str);
        // Imprime o resultado
        System.out.println("A substring '" + substringParaContar + "' aparece " + contagem + " vezes na string.");
    }

}
