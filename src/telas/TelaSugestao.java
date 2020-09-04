/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import ENUMERADORES.EnumStatusSugestao;
import classes.Sugestao;
import classes.Usuario;
import controle.ControleSugestao;
import controle.ControleUsuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class TelaSugestao extends javax.swing.JDialog {

    Sugestao sugestao = null;
    Sugestao sugestaoAnterior = null;
    ControleSugestao controleSugestao = null;

    /**
     * Creates new form TelaSugestao
     */
    public TelaSugestao(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        desabilitaCampos();
        jButtonSalvarAlteracao.setEnabled(false);
        jButtonIncluirSugestao.setEnabled(false);
        jButtonPesquisarSugestão.setEnabled(false);
        jFormattedTextFieldDataSugestao.requestFocus();

        sugestao = new Sugestao();
        sugestaoAnterior = new Sugestao();
        controleSugestao = new ControleSugestao("Sugestoes.txt");

        ControleUsuario usuario = new ControleUsuario("Usuarios.txt");
        ArrayList<Usuario> listaUsuario = usuario.recuperar();
        for (int pos = 0; pos < listaUsuario.size(); pos++) {
            Usuario aux = listaUsuario.get(pos);
            jComboBoxUsuarioSugerir.addItem(aux.getId() + "-" + aux.getNome().toUpperCase());
        }

        for (EnumStatusSugestao status : EnumStatusSugestao.values()) {
            jComboBoxSituacaoSugestao.addItem(status.toString());
        }
        imprimirSugestoes(controleSugestao.recuperar());
    }

    public void desabilitaCampos() {
        jFormattedTextFieldDataSugestao.setEnabled(false);
        jComboBoxUsuarioSugerir.setEnabled(false);
        jComboBoxSituacaoSugestao.setEnabled(false);
        jTextFieldDigitarSugestao.setEnabled(false);
    }

    public void habilitaCampos() {
        jFormattedTextFieldDataSugestao.setEnabled(true);
        jComboBoxUsuarioSugerir.setEnabled(true);
        jComboBoxSituacaoSugestao.setEnabled(true);
        jTextFieldDigitarSugestao.setEnabled(true);
    }

    public void limpaCampos() {
        jFormattedTextFieldDataSugestao.setText("");
        jComboBoxUsuarioSugerir.setSelectedIndex(0);
        jComboBoxSituacaoSugestao.setSelectedIndex(0);
        jTextFieldDigitarSugestao.setText("");
    }

    public void preencherFormulario() {
        int linha = jTableSugestao.getSelectedRow();
        if (linha >= 0) {
            String campoId = jTableSugestao.getValueAt(linha, 0).toString();
            String campoData = jTableSugestao.getValueAt(linha, 1).toString();
            String campoIdNomeUsuario = jTableSugestao.getValueAt(linha, 2).toString();
            String campoTextoSugestao = jTableSugestao.getValueAt(linha, 3).toString();
            String campoStatusSugestao = jTableSugestao.getValueAt(linha, 4).toString();

            sugestaoAnterior.setId(Integer.parseInt(campoId));
            jFormattedTextFieldDataSugestao.setText(campoData);
            jComboBoxUsuarioSugerir.setSelectedItem(campoIdNomeUsuario);
            jTextFieldDigitarSugestao.setText(campoTextoSugestao);
            jComboBoxSituacaoSugestao.setSelectedItem(campoStatusSugestao);

        }
    }

    private void imprimirSugestoes(ArrayList<Sugestao> lista) throws Exception {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableSugestao.getModel();
            model.setNumRows(0);
            Collections.sort(lista);
            
            for (int pos = 0; pos < lista.size(); pos++) {
                String linha[] = new String[5];
                Sugestao aux = lista.get(pos);
                linha[0] = "" + aux.getId();
                linha[1] = new SimpleDateFormat("dd/MM/yyyy").format(aux.getDataDaSugestao());
                linha[2] = aux.getUsuario().getId() + "-" + aux.getUsuario().getNome().toUpperCase();
                linha[3] = aux.getSugestao();
                linha[4] = aux.getStatusDaSugestao().toString().toUpperCase();
                model.addRow(linha);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar as sugestões!\n" + erro);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSugestoes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalvarAlteracao = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldDataSugestao = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxUsuarioSugerir = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();
        jButtonIncluirSugestao = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSituacaoSugestao = new javax.swing.JComboBox<>();
        jTextFieldDigitarSugestao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSugestao = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisarSugestão = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Sugestões de Usuários");

        jPanelSugestoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("DIGITE NO CAMPO ABAIXO A SUGESTÃO DO USUÁRIO SELECIONADO");

        jButtonSalvarAlteracao.setText("SALVAR ALTERAÇÃO");
        jButtonSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteracaoActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonFechar.setText("FECHAR");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabel3.setText("DATA");

        try {
            jFormattedTextFieldDataSugestao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("USUÁRIO");

        jComboBoxUsuarioSugerir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o usuário>" }));

        jButtonEditar.setText("EDITAR");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonIncluirSugestao.setText("INCLUIR");
        jButtonIncluirSugestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSugestaoActionPerformed(evt);
            }
        });

        jLabel5.setText("SITUAÇÃO");

        jComboBoxSituacaoSugestao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione a situação da sugestão>" }));

        jTableSugestao.setAutoCreateRowSorter(true);
        jTableSugestao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA", "ID-NOME DO USUARIO", "TRECHO DA SUGESTAO", "SITUAÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSugestao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSugestaoMouseClicked(evt);
            }
        });
        jTableSugestao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSugestaoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSugestao);
        if (jTableSugestao.getColumnModel().getColumnCount() > 0) {
            jTableSugestao.getColumnModel().getColumn(0).setMinWidth(50);
            jTableSugestao.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableSugestao.getColumnModel().getColumn(1).setMinWidth(80);
            jTableSugestao.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        jButtonNovo.setText("NOVO");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jTextFieldPesquisar.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldPesquisar.setText("Digite aqui a sugestão, nome do usuário ou matrículaCPF");
        jTextFieldPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPesquisarFocusLost(evt);
            }
        });

        jButtonPesquisarSugestão.setText("PESQUISAR");
        jButtonPesquisarSugestão.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarSugestãoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSugestoesLayout = new javax.swing.GroupLayout(jPanelSugestoes);
        jPanelSugestoes.setLayout(jPanelSugestoesLayout);
        jPanelSugestoesLayout.setHorizontalGroup(
            jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisarSugestão))
                    .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                        .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDigitarSugestao)
                            .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldDataSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxUsuarioSugerir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncluirSugestao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvarAlteracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFechar))
                            .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxSituacaoSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanelSugestoesLayout.setVerticalGroup(
            jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSugestoesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldDataSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxUsuarioSugerir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxSituacaoSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDigitarSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarSugestão))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanelSugestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonSalvarAlteracao)
                    .addComponent(jButtonIncluirSugestao)
                    .addComponent(jButtonNovo))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSugestoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSugestoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracaoActionPerformed
        try {
            if (jFormattedTextFieldDataSugestao.getText().trim().replaceAll("/", "").equals("")) {
                JOptionPane.showMessageDialog(null, "O campo data de aquisição deve ser informada.\n");
                jFormattedTextFieldDataSugestao.requestFocus();
            } else if (jComboBoxUsuarioSugerir.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "O campo nome do usuario deve ser selecionado.\n");
            } else if (jComboBoxSituacaoSugestao.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "O campo da situação da sugestão deve ser selecionada.\n");
            } else if (jTextFieldDigitarSugestao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo da sugestão deve ser informada");
                jTextFieldDigitarSugestao.requestFocus();
            }

            sugestao.setId(sugestaoAnterior.getId());
            sugestao.setDataDaSugestao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDataSugestao.getText()));
            Usuario usuario = new Usuario();
            usuario.setUsuarioSplit(jComboBoxUsuarioSugerir.getSelectedItem().toString());
            sugestao.setUsuario(usuario);
            sugestao.setSugestao(jTextFieldDigitarSugestao.getText());
            sugestao.setStatusDaSugestao(EnumStatusSugestao.valueOf(jComboBoxSituacaoSugestao.getSelectedItem().toString()));

            controleSugestao.alterar(sugestao);
            imprimirSugestoes(controleSugestao.recuperar());
            limpaCampos();
            desabilitaCampos();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonSalvarAlteracaoActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        try {
            limpaCampos();
            jFormattedTextFieldDataSugestao.requestFocus();
            imprimirSugestoes(controleSugestao.recuperar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        habilitaCampos();

        jTextFieldDigitarSugestao.requestFocus();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonIncluirSugestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSugestaoActionPerformed

        if (jFormattedTextFieldDataSugestao.getText().trim().replaceAll("/", "").equals("")) {
            JOptionPane.showMessageDialog(null, "O campo data de aquisição deve ser informada.\n");
            jFormattedTextFieldDataSugestao.requestFocus();
        } else if (jComboBoxUsuarioSugerir.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "O campo nome do usuario deve ser selecionado.\n");
        } else if (jComboBoxSituacaoSugestao.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "O campo da situação da sugestão deve ser selecionada.\n");
        } else if (jTextFieldDigitarSugestao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo da sugestão deve ser informada");
            jTextFieldDigitarSugestao.requestFocus();
        } else {

            try {

                sugestao.setDataDaSugestao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDataSugestao.getText()));
                Usuario usuario = new Usuario();
                usuario.setUsuarioSplit(jComboBoxUsuarioSugerir.getSelectedItem().toString());
                sugestao.setUsuario(usuario);
                sugestao.setSugestao(jTextFieldDigitarSugestao.getText());
                sugestao.setStatusDaSugestao(EnumStatusSugestao.valueOf(jComboBoxSituacaoSugestao.getSelectedItem().toString()));

                controleSugestao.incluir(sugestao);
                imprimirSugestoes(controleSugestao.recuperar());
                limpaCampos();
                desabilitaCampos();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
        jFormattedTextFieldDataSugestao.requestFocus();
    }//GEN-LAST:event_jButtonIncluirSugestaoActionPerformed

    private void jTableSugestaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSugestaoMouseClicked
        habilitaCampos();
        preencherFormulario();
        jButtonIncluirSugestao.setEnabled(false);
        jButtonSalvarAlteracao.setEnabled(true);

    }//GEN-LAST:event_jTableSugestaoMouseClicked

    private void jTableSugestaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSugestaoKeyReleased
        preencherFormulario();
    }//GEN-LAST:event_jTableSugestaoKeyReleased

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        limpaCampos();
        habilitaCampos();
        jFormattedTextFieldDataSugestao.requestFocus();
        jButtonIncluirSugestao.setEnabled(true);
        jButtonSalvarAlteracao.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonPesquisarSugestãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarSugestãoActionPerformed
        try {
            imprimirSugestoes(controleSugestao.pesquisar(jTextFieldPesquisar.getText()));
            jTextFieldPesquisar.requestFocus();
            jTextFieldPesquisar.setText("");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            jTextFieldPesquisar.requestFocus();
            jTextFieldPesquisar.setText("");
        }
    }//GEN-LAST:event_jButtonPesquisarSugestãoActionPerformed

    private void jTextFieldPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarFocusGained
        if (jTextFieldPesquisar.getText().equals("Digite aqui a sugestão, nome do usuário ou matrículaCPF")) {
            jTextFieldPesquisar.setText("");
            jButtonPesquisarSugestão.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldPesquisarFocusGained

    private void jTextFieldPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarFocusLost
        if (jTextFieldPesquisar.getText().equals("")) {
            jTextFieldPesquisar.setText("Digite aqui a sugestão, nome do usuário ou matrículaCPF");
            jButtonPesquisarSugestão.setEnabled(false);
        }
    }//GEN-LAST:event_jTextFieldPesquisarFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaSugestao dialog = new TelaSugestao(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaSugestao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonIncluirSugestao;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisarSugestão;
    private javax.swing.JButton jButtonSalvarAlteracao;
    private javax.swing.JComboBox<String> jComboBoxSituacaoSugestao;
    private javax.swing.JComboBox<String> jComboBoxUsuarioSugerir;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataSugestao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelSugestoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSugestao;
    private javax.swing.JTextField jTextFieldDigitarSugestao;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}