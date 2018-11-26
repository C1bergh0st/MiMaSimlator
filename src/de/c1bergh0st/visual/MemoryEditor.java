package de.c1bergh0st.visual;

import javax.swing.*;
import de.c1bergh0st.mima.*;

public class MemoryEditor{
    private JTable table;
    private JScrollPane panel;

    public MemoryEditor(Speicher speicher){
        //How much of the Memory should be shown
        int shownLength = 400;
        //int shownLength = 1048576;
        String[] cols = {"Adress", "Binary", "\"Code\""};
        String[][] data = new String[shownLength][3];

        for(int i = 0; i < shownLength; i++){
            data[i][0] = ""+i;
        }

        for(int x = 1; x < cols.length; x++){
            for(int i = 0; i < shownLength; i++){
                data[i][x] = new String();
            }
        }
        CustomTableModel model = new CustomTableModel(data, cols);
        table = new JTable(model);
        TableListener listener = new TableListener(table,speicher);
        model.addTableModelListener(listener);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);

        panel = new JScrollPane(table);

    }

    public JScrollPane getPanel() {
        return panel;
    }
}
