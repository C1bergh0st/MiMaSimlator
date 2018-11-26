package de.c1bergh0st.visual;

import de.c1bergh0st.debug.Debug;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class TableListener implements TableModelListener {
    JTable table;

    public TableListener(JTable table) {
        this.table = table;
    }

    public void tableChanged(TableModelEvent e) {
        int firstRow = e.getFirstRow();
        int lastRow = e.getLastRow();
        int index = e.getColumn();

        if(e.getType() == TableModelEvent.UPDATE){
            Debug.send("Row:"+ firstRow + " Column:" + index + " to: "+ table.getModel().getValueAt(firstRow, index));
        }

    }
}
