package de.c1bergh0st.visual;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(String[][] data, String[] colomns){
        super(data, colomns);
    }


    public boolean isCellEditable(int row, int column){
        if(column == 0 || column == 3){
            return false;
        }
        return true;
    }

}
