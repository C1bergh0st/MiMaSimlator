package de.c1bergh0st.visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MemoryEditor{
    private JTable table;
    private JScrollPane panel;

    public MemoryEditor(){
        //How much of the Memory should be shown
        int shownLength = 400;
        //int shownLength = 1048576;
        String[] cols = {"Adress", "Binary", "Instr.", "Masked Value"};
        String[][] data = new String[shownLength][4];

        for(int i = 0; i < shownLength; i++){
            data[i][0] = ""+i;
        }

        for(int x = 1; x < 4; x++){
            for(int i = 0; i < shownLength; i++){
                data[i][x] = new String();
            }
        }
        CustomTableModel model = new CustomTableModel(data, cols);
        table = new JTable(model);
        TableListener listener = new TableListener(table);
        model.addTableModelListener(listener);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);

        panel = new JScrollPane(table);

    }

    public JScrollPane getPanel() {
        return panel;
    }
}
