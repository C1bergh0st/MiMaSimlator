package de.c1bergh0st.visual;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.Speicher;
import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.TimerTask;
import java.util.Timer;

class TableListener implements TableModelListener {
    JTable table;
    Speicher speicher;
    long lastchange;

    public TableListener(JTable table, Speicher speicher) {
        this.table = table;
        this.speicher = speicher;
        lastchange = System.currentTimeMillis();
        revalidate();

    }


    public void revalidate(){
        for(int i = 0; i < table.getRowCount(); i++){
            updateBinary(i);
            updateRepr(i);
            updateDec(i);
        }
    }

    public void tableChanged(TableModelEvent e) {
        int adress = e.getFirstRow();
        int inputField = e.getColumn();
        String value = (String)table.getModel().getValueAt(adress, inputField);
        if(lastchange > System.currentTimeMillis() - 100){
            return;
        }
        lastchange = System.currentTimeMillis();

        //Debug.send("Row:"+ adress + " Column:" + inputField + " to: "+ value);

        if(isValidInput(adress, inputField)){
            speicher.setMem(adress,parseValue(adress, inputField));
            //proper Formatting
            updateRow(adress);
        }else{
            //If the new Value is invalid we reset it
            updateRow(adress);
        }
    }

    private void updateRow(int adress){
        forceUpdate(adress,0);
        updateBinary(adress);
        updateRepr(adress);
        updateDec(adress);
        forceUpdate(adress,4);
    }

    private void forceUpdate(int adress, int column){
        table.getModel().setValueAt(table.getModel().getValueAt(adress,column),adress,column);
    }

    private void updateBinary(int adress) {
        table.getModel().setValueAt(ParseUtil.toBinaryString(speicher.getMem(adress)),adress,1);
    }

    private void updateDec(int adress){
        table.getModel().setValueAt(""+speicher.getMem(adress),adress,3);
    }

    private void updateRepr(int adress) {
        int value = speicher.getMem(adress);
        table.getModel().setValueAt(ParseUtil.code(value),adress,2);
    }


    /** Parses the Input into a Register Int
     *
     * @param adress The Adress of the changed Value
     * @param inputField The Type of Input (1 means binary, 2 means Command)
     * @return The int value of the Memory Register
     */
    private int parseValue(int adress, int inputField) {
        String value = (String)table.getModel().getValueAt(adress, inputField);
        if(inputField == 1){
            return Integer.parseInt(value.trim(), 2);
        } else if (inputField == 2){
            return ParseUtil.parseCommand(value);
        }
        return 0;
    }

    /** Checks if the newly Changed String is valid
     *
     * @param adress The Adress of the changed Value
     * @param inputField The Type of Input (1 means binary, 2 means Command)
     * @return Whether the changed String is valid
     */
    private boolean isValidInput(int adress, int inputField) {
        //we get the String that was changed
        String value = (String)table.getModel().getValueAt(adress, inputField);
        //check if the newly saved value lies within the adress space
        if(adress >= 0 && adress <= Steuerwerk.MAX_ADRESS){
            //if the inputField is 1 it should be a binary String
            if(inputField == 1) {//Binary Input
                if (ParseUtil.validBinary(value)){
                    return true;
                }
            //if the inputField is 2 it should be a command String
            } else if(inputField == 2){//Command style input
                if(ParseUtil.validCommand(value)){
                    return true;
                }

            }
        }
        return false;
    }
}
