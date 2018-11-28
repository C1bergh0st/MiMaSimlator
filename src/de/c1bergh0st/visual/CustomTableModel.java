//Copyright (C) 2018  Philipp Berdesinski
// A MiMa Simulator with GUI
// The Copyright outlined in the File LISENCE applies
package de.c1bergh0st.visual;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(String[][] data, String[] columns){
        super(data, columns);
    }


    public boolean isCellEditable(int row, int column){
        return column != 0 && column != 3;
    }

}
