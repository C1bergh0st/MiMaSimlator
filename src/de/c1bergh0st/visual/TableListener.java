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
    long lastchange;

    public TableListener(JTable table, Speicher speicher) {
        this.table = table;
        this.speicher = speicher;
        lastchange = System.currentTimeMillis();
    }

    public void tableChanged(TableModelEvent e) {
        int adress = e.getFirstRow();
        int inputField = e.getColumn();
        String value = (String)table.getModel().getValueAt(adress, inputField);
        if(e.getType() == TableModelEvent.UPDATE){
            if(lastchange > System.currentTimeMillis() - 100){
                return;
            }
            lastchange = System.currentTimeMillis();

            Debug.send("Row:"+ adress + " Column:" + inputField + " to: "+ value);

            if(isValidInput(adress, inputField)){
                speicher.setMem(adress,parseValue(adress, inputField));
                //proper Formatting
                updateBinary(adress);
                updateRepr(adress);
            }else{
                //If the new Value is invalid we reset it
                updateBinary(adress);
                updateRepr(adress);
            }
        }

    }

    private void updateBinary(int adress) {
        table.getModel().setValueAt(ParseUtil.toBinaryString(speicher.getMem(adress)),adress,1);
    }

    private void updateRepr(int adress) {
        int value = speicher.getMem(adress);
        table.getModel().setValueAt(ParseUtil.code(value),adress,2);
    }

    private int parseValue(int adress, int inputField) {
        String value = (String)table.getModel().getValueAt(adress, inputField);
        if(inputField == 1){
            return Integer.parseInt(value.trim(), 2);
        } else if (inputField == 2){
            return ParseUtil.parseCommand(value);
        }
        return 0;
    }

    private boolean isValidInput(int adress, int inputField) {
        String value = (String)table.getModel().getValueAt(adress, inputField);
        //check if the newly saved value lies within the adress space
        if(adress >= 0 && adress <= Steuerwerk.MAX_ADRESS){

            if(inputField == 1) {//Binary Input
                if (ParseUtil.validBinary(value)){
                    return true;
                }
            } else if(inputField == 2){//Command style input
                if(ParseUtil.validCommand(value)){
                    return true;
                }

            }
        }
        return false;
    }
}
