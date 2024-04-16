package arquivos;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Manipulador extends javax.swing.JFrame {

    public static String caminhoArquivo = "";

    public Manipulador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        toggleButton1 = new toggle.ToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ler arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(51, 0, 51));

        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt.setLineWrap(true);
        txt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(txt);

        jButton2.setText("Escrever no arquivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        toggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(42, 42, 42)
                        .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Texto", "txt");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            setTitle(selectedFile.getName());
            caminhoArquivo = selectedFile.getAbsolutePath();
            System.out.println("Arquivo selecionado: " + caminhoArquivo);

            try {
                Arquivos.lerAqruivo(caminhoArquivo);
            } catch (IOException ex) {
                Logger.getLogger(Manipulador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if ("".equals(caminhoArquivo)) {
            int resp = JOptionPane.showConfirmDialog(null, "Sem arquivos carregados, deseja carregar um novo?");
            if (resp == 0) {
                JFileChooser fileChooser = new JFileChooser();
                int save = fileChooser.showSaveDialog(null);
                if (save == JFileChooser.APPROVE_OPTION) {
                    File novoArquivo = fileChooser.getSelectedFile();
                    caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("caminho a");
                    try {
                        if (novoArquivo.createNewFile()) {
                            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso");
                            if (!Objects.equals(txt.getText(), "") || !Objects.equals(txt.getText(), null)) {
                                Arquivos.escreverArquivo(caminhoArquivo);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo");
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo");
                    }
                }
            }
        } else {
            try {
                
                System.out.println("caminho b\ncaminhoArquivo: "+caminhoArquivo+ "\ntexto: "+ txt.getText() );
                Arquivos.escreverArquivo(caminhoArquivo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void toggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleButton1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_toggleButton1MouseClicked

    public static void main(int i) {
 
            FlatMacDarkLaf.setup();
 

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Manipulador().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private toggle.ToggleButton toggleButton1;
    public static javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
