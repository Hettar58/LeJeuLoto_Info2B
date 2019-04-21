/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

/**
 *
 * @author yann
 */
public class OptionsDlg extends javax.swing.JDialog {
    private int choixOpt;
    private int nbCol;
    private int nbNum;
    /**
     * Creates new form OptionsDlg
     */
    public OptionsDlg(java.awt.Frame parent, boolean modal, boolean ca, int nc, int nn) {
        super(parent, modal);
        initComponents();
        remplirComboCol();
        QuineRB.setSelected(true);
        if (!ca){
            nbCol = 5;
            nbNum = 5;
        }else{
            nbCol = nc;
            nbNum = nn;
            ColCB.insertItemAt(""+nbNum, 0);
            ColCB.setSelectedIndex(0);
            NumTF.setText(""+nbCol);
            ColCB.setEnabled(false);
            NumTF.setEnabled(false);
            Message.setText("Nombre de colonnes et de numéros non modifiable");
        }
    }
    
    private void remplirComboCol(){
        ColCB.addItem("5");
        ColCB.addItem("6");
        ColCB.addItem("7");
        ColCB.addItem("8");
        ColCB.addItem("9");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup1 = new javax.swing.ButtonGroup();
        North = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Center = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        QuineRB = new javax.swing.JRadioButton();
        ButtonGroup1.add(QuineRB);
        DoubleQuineRB = new javax.swing.JRadioButton();
        ButtonGroup1.add(DoubleQuineRB);
        CartonPleinRB = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ColCB = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        NumTF = new javax.swing.JTextField();
        Message = new javax.swing.JLabel();
        South = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Options du jeu");
        North.add(jLabel1);

        getContentPane().add(North, java.awt.BorderLayout.NORTH);

        Center.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel2.setText("Comment voulez vous jouer ?");
        jPanel1.add(jLabel2);

        QuineRB.setText("Quine - Une ligne complète");
        jPanel1.add(QuineRB);

        DoubleQuineRB.setText("Double Quine - Deux lignes complètes");
        jPanel1.add(DoubleQuineRB);

        ButtonGroup1.add(CartonPleinRB);
        CartonPleinRB.setText("Carton plein");
        jPanel1.add(CartonPleinRB);

        Center.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        jLabel3.setText("Configuration des cartons");
        jPanel2.add(jLabel3);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setText("Combien de colonnes ?");
        jPanel3.add(jLabel4);

        jPanel3.add(ColCB);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Combien de numéros ?");
        jPanel4.add(jLabel5);
        jPanel4.add(NumTF);

        jPanel2.add(jPanel4);
        jPanel2.add(Message);

        Center.add(jPanel2);

        getContentPane().add(Center, java.awt.BorderLayout.CENTER);

        South.setLayout(new java.awt.GridLayout(1, 2));

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        South.add(jButton1);

        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        South.add(jButton2);

        getContentPane().add(South, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (QuineRB.isSelected() == true){
            choixOpt = 1;
        }
        if (DoubleQuineRB.isSelected() == true){
            choixOpt = 2;
        }
        if(CartonPleinRB.isSelected() == true){
            choixOpt = 3;
        }
        nbCol = Integer.parseInt(ColCB.getItemAt(ColCB.getSelectedIndex()));
        
        System.out.println("output"+NumTF.getText());
        if(NumTF.getText().equals("")){
            Message.setText("Erreur: Valeur manquante");
        }
        else{
            nbNum = Integer.parseInt(NumTF.getText());
            if(nbNum < 5 || nbNum > nbCol * 3){
                Message.setText("Erreur: Valeur invalide");
            }
            else{
                this.setVisible(false);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public int getChoixOpt() {
        return choixOpt;
    }

    public int getNbCol() {
        return nbCol;
    }

    public int getNbNum() {
        return nbNum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGroup1;
    private javax.swing.JRadioButton CartonPleinRB;
    private javax.swing.JPanel Center;
    private javax.swing.JComboBox<String> ColCB;
    private javax.swing.JRadioButton DoubleQuineRB;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel North;
    private javax.swing.JTextField NumTF;
    private javax.swing.JRadioButton QuineRB;
    private javax.swing.JPanel South;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}