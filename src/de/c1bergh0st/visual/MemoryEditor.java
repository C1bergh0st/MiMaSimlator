package de.c1bergh0st.visual;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.*;

import java.awt.*;

public class MemoryEditor{
    private JTable table;
    private JScrollPane panel;
    private CustomTableModel model;
    private TableListener listener;
    private Steuerwerk mima;
    String[][] data;

    public MemoryEditor(Speicher speicher, Steuerwerk mima){
        this.mima = mima;
        //How much of the Memory should be shown
        int shownLength = 400;
        //int shownLength = 1048576;
        String[] cols = {"Adress", "Binary", "\"Code\"", "Decimal","Comments"};
        data = new String[shownLength][cols.length];



        for(int i = 0; i < shownLength; i++){
            data[i][0] = ""+i;
        }

        for(int x = 1; x < cols.length; x++){
            for(int i = 0; i < shownLength; i++){
                data[i][x] = new String();
            }
        }
        model = new CustomTableModel(data, cols);
        table = new JTable(model);
        listener = new TableListener(table,speicher);
        model.addTableModelListener(listener);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);

        //Colorcoding rows
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                if (row == mima.getNextAdress()) {
                    setBackground(Color.GREEN);
                } else if(row == mima.getLastAdress()){
                    setBackground(Color.ORANGE);
                } else if(row == mima.getLastChange()){
                    setBackground(Color.BLUE.brighter());
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        panel = new JScrollPane(table);
        panel.setPreferredSize(new Dimension(600,500));

    }

    public void revalidate(){
        listener.revalidate();

    }

    public TableListener getListener(){
        return listener;
    }

    public JScrollPane getPanel() {
        return panel;
    }
}
