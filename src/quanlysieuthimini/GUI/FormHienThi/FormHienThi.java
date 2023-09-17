/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimini.GUI.FormHienThi;

import quanlysieuthimini.GUI.FormChung.MyTable;
import javax.swing.JPanel;

public class FormHienThi extends JPanel {
    
    MyTable mtb;
    
    public FormHienThi() {
        
    }
    
    public String getSelectedRow(int col) {
        int i = mtb.getTable().getSelectedRow();
        if (i >= 0) {
            int realI = mtb.getTable().convertRowIndexToModel(i);
            return mtb.getModel().getValueAt(realI, col).toString();
        }
        return null;
    }
    
    public MyTable getTable() {
        return this.mtb;
    }
}
