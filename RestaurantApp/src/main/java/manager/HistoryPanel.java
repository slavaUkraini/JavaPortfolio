/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.awt.Color;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanysha
 */
public class HistoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form HistoryPanel
     */
    private static HistoryPanel reference;
    private static final Object[] columnNames = { "Id","Name", "Surname", "Date"};
    private DefaultTableModel model; 
    Object[][] object ;
    private HistoryPanel() {
        model = new DefaultTableModel(null, columnNames);
        initComponents();
        setBackground(Color.getHSBColor(276,9,95));
        writingData ();
        historyT.getTableHeader().setReorderingAllowed(false); 
        historyT.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        historyT.setModel(model);
        jScrollPane1.setViewportView(historyT);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(332, 332, 332))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 public static HistoryPanel getReference(){
         if (reference==null){
             reference = new HistoryPanel();
         }
         return reference;
     }
  public void writingData (){
       model.setDataVector(null, columnNames);
       try {
            Set<Integer> keys = Manager.getThread().getHistory().keySet();
             //множина айді всіх працівників, які прийшли на роботу
        //скільки у тебе там стовпчиків, нехай айді, імя, прізвище, дата
        //ітого 4
        //рядків стільки, скільки й ключів
        int n = keys.size();
        Object[] keysArr = keys.toArray(); // перевели в масив
        object = new Object[n][4];
        for(int i = 0; i<n; i++){
            object[i][0] = keysArr[i]; //стовпчик айді
            object[i][1] = Manager.getThread().getEmployees().get(Integer.parseInt((String)keysArr[i])).getName();//стовпчик ім 'я
            object[i][2] = Manager.getThread().getEmployees().get(Integer.parseInt((String)keysArr[i])).getSurname(); //стовпчик прізвище
            object[i][3] = Manager.getThread().getHistory().get(keysArr[i]); //стовпчик дата
        }
         }
          catch (IOException ex) {
            Logger.getLogger(HistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.setDataVector(object, columnNames);
          
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable historyT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
