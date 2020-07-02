/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gabriela
 */
public class Gantt1 extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof String) {
            table.selectAll();
            String valor = (String) value;
            if (valor.equals("X")) {
                cell.setBackground(Color.BLUE);
                cell.setForeground(Color.BLUE);            
            } else if (valor.equals("E")) {
                cell.setBackground(Color.black);
                cell.setForeground(Color.BLACK);
            } else if (valor != "X") {
                table.selectAll();
                cell.setForeground(Color.white);              
            } else if (valor != "E") {
                table.selectAll();
                cell.setForeground(Color.white);
            } 

        }

        return cell;
    }
}
