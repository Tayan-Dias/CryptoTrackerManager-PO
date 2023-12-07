/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package po23s.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import po23s.model.Cripto;

/**
 *
 * @author Cliente
 */
public class TelaDados extends javax.swing.JFrame {
    ArrayList<Cripto> bitcoins = new ArrayList<Cripto>();

    /**
     * Creates new form TelaDados
     */
    public TelaDados() {
        initComponents();
    }

    public void OrganizaJTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setNumRows(0);
        Cripto bit = new Cripto();
        Object colunas[] = new Object[3];

        for (int i = 0; i < bitcoins.size(); i++) {
            bit = bitcoins.get(i);

            colunas[0] = bit.getNome();
            colunas[1] = formatarDecimal(bit.getCompra());
            colunas[2] = formatarDecimal(bit.getVenda());

            model.addRow(colunas);
        }
    }

    private static final DecimalFormatSymbols FORMATO_SIMBOLOS = new DecimalFormatSymbols();
    private static final DecimalFormat FORMATO_DECIMAL;

    static {
        FORMATO_SIMBOLOS.setDecimalSeparator(',');
        FORMATO_SIMBOLOS.setGroupingSeparator('.');
        FORMATO_DECIMAL = new DecimalFormat("#,###.####", FORMATO_SIMBOLOS);
    }

    private String formatarDecimal(String valor) {
        try {
            double valorDouble = Double.parseDouble(valor);
            return FORMATO_DECIMAL.format(valorDouble);
        } catch (NumberFormatException e) {

            e.printStackTrace();
            return valor;
        }
    }

    public void excluir(java.awt.event.ActionEvent evt) {
        if (jTable2.getSelectedRow() != -1) {
            int indiceSelecionado = jTable2.getSelectedRow();
            bitcoins.remove(indiceSelecionado);

            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
            modelo.removeRow(indiceSelecionado);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir!");
        }
    }

    public void Att(java.awt.event.ActionEvent evt) {
        if (jTable2.getSelectedRow() != -1) {
            Cripto criptoSelecionada = bitcoins.get(jTable2.getSelectedRow());
            String nomeCripto = criptoSelecionada.getNome();

            // Requisitar dados atualizados com base no nome
            String url = criptoSelecionada.configURL(nomeCripto);
            String resultado = criptoSelecionada.buscaDados(url);

            if (resultado.equals("Not Found\n")) {
                JOptionPane.showMessageDialog(null, "Os dados não foram encontrados");
            } else {
                // Atualizar os dados da criptomoeda
                criptoSelecionada.coverteJson(resultado);

                // Atualizar a tabela
                OrganizaJTable();
                System.out.println("ATUALIZAÇAO:" + criptoSelecionada.getNome());
                System.out.println();
                System.out.println("Venda: " + formatarDecimal(criptoSelecionada.getVenda()));
                System.out.println("Compra: " + formatarDecimal(criptoSelecionada.getCompra()));
                System.out.println();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para Atualizar!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        txtTicker = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta CriptoMoedas");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(243, 241, 241));
        setLocationByPlatform(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnAdicionar.setBackground(new java.awt.Color(75, 238, 156));
        btnAdicionar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorderPainted(false);
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 102, 102));
        btnExcluir.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);

            }
        });

        btnAtualizar.setBackground(new java.awt.Color(252, 194, 44));
        btnAtualizar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorderPainted(false);
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);

            }
        });
        txtTicker.setBackground(new java.awt.Color(248, 243, 220));
        txtTicker.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        txtTicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTickerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Ticker");

        jScrollPane2.setBackground(new java.awt.Color(232, 210, 239));

        jTable2.setBackground(new java.awt.Color(232, 210, 239));
        jTable2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(82, 76, 76));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Crypto", "Compra (BRL)", "Venda (BRL)"
                }) {
            boolean[] canEdit = new boolean[] {
                    true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTicker))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAdicionar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(btnAtualizar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnExcluir,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtTicker, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))

                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdicionarActionPerformed

        Cripto b = new Cripto();
        if (this.txtTicker.getText().length() < 2) {
            JOptionPane.showMessageDialog(null, "Campo deve conter no mínimo dois caracteres");
        } else {
            // pega o que tem no campo e coloca em nome
            b.setNome(this.txtTicker.getText());
            // limpa o campo ticker
            txtTicker.setText("");
            // altera a url para conter o ticker pra fazer a busca
            String url = b.configURL(b.getNome());
            String resultado = "0";
            // faz a busca e retorna o json
            resultado = b.buscaDados(url);
            // se não encontrar exibe um aviso
            if (resultado.equals("Not Found\n")) {
                JOptionPane.showMessageDialog(null, "Os dados não foram encontrados");

            } else {
                // pega as informações do json
                b.coverteJson(resultado);
                // adiciona no Array
                bitcoins.add(b);
                // exibe na tabela
                OrganizaJTable();
                System.out.println("ADICIONOU:" + b.getNome());
                System.out.println();
                System.out.println("Venda: " + b.getVenda());
                System.out.println("Compra: " + b.getCompra());
                System.out.println();
            }
        }

    }// GEN-LAST:event_btnAdicionarActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField3ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
        // deixar tela ao cetro
        setLocationRelativeTo(null);
    }// GEN-LAST:event_formComponentShown

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }// GEN-LAST:event_formWindowOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
        excluir(evt);
    }// GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
        Att(evt);
    }

    private void txtTickerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTickerActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtTickerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtTicker;
    // End of variables declaration//GEN-END:variables
}
