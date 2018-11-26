package de.c1bergh0st.visual;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.Speicher;
import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class TableListener implements TableModelListener {
    JTable table;
    Speicher speicher;

    public TableListener(JTable table, Speicher speicher) {
        this.table = table;
        this.speicher = speicher;
    }

    public void tableChanged(TableModelEvent e) {
        int adress = e.getFirstRow();
        int inputField = e.getColumn();

        if(e.getType() == TableModelEvent.UPDATE){

            Debug.send("Row:"+ adress + " Column:" + inputField + " to: "+ table.getModel().getValueAt(adress, inputField));

            if(isValidInput(adress, inputField)){
                speicher.setMem(adress,parseValue(adress, inputField));
            }else{
                table.getModel().setValueAt(speicher.getMem(adress),adress,inputField);
            }
        }

    }

    private int parseValue(int adress, int inputField) {
        return 0;
    }

    private boolean isValidInput(int adress, int inputField) {
        String value = (String)table.getModel().getValueAt(adress, inputField);
        if(adress >= 0 && adress <= Steuerwerk.MAX_ADRESS){
            if(inputField == 1) {
                if (ParseUtil.validBinary(value)){

                }
            }
        }
        return false;
    }
}
