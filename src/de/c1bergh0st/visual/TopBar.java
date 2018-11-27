package de.c1bergh0st.visual;

import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBar extends JPanel{
    private HelpWindow currentHelpWindow;

    public TopBar(Steuerwerk mima, MemoryEditor memEdit){
        Steuerwerk mima1 = mima;
        MemoryEditor memEdit1 = memEdit;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton lock = new JButton("Lock Code");
        lock.setEnabled(false);
        JButton reset = new JButton("Reset");
        reset.setEnabled(false);
        add(lock);
        add(reset);

        add(Box.createHorizontalStrut(20));

        JButton save = new JButton("Save");
        save.setEnabled(false);
        JButton load = new JButton("Load");
        load.setEnabled(false);
        add(save);
        add(load);

        add(Box.createHorizontalStrut(20));

        JButton clear = new JButton("Clear Mem");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(null, "Clear Everything?","Warning",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION) {
                    mima.getSpeicher().clear();
                    memEdit.revalidate();
                }
            }
        } );
        add(clear);

        add(Box.createHorizontalStrut(20));

        JButton help = new JButton("Help");
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(currentHelpWindow != null){
                    currentHelpWindow.dispose();
                }
                currentHelpWindow = new HelpWindow();
            }
        } );
        add(help);
    }
}
