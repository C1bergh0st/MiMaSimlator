//Copyright (C) 2018  Philipp Berdesinski
// A MiMa Simulator with GUI
// The Copyright outlined in the File LICENSE applies
package de.c1bergh0st.visual;

import de.c1bergh0st.mima.SpeicherSaver;
import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBar extends JPanel{
    private JButton lock;
    private JButton reset;
    private JButton save;
    private JButton load;
    private JButton clear;
    private JButton help;
    private Steuerwerk mima;
    private MemoryEditor memEdit;
    HelpWindow currentHelpWindow;
    private JFrame parent;

    public TopBar(Steuerwerk mima, MemoryEditor memEdit){
        this.mima = mima;
        this.memEdit = memEdit;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        lock = new JButton("Lock Code");
        lock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.getSpeicher().lockCurrState();
                memEdit.revalidate();
            }
        } );
        reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.resetAdress();
                mima.getSpeicher().loadLockedState();
                memEdit.revalidate();
            }
        } );
        add(lock);
        add(reset);

        add(Box.createHorizontalStrut(20));

        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SpeicherSaver.saveMemory(mima.getSpeicher().getMem(),parent,memEdit.getComments());
            }
        } );
        load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SpeicherSaver.loadMemory(parent,memEdit,mima.getSpeicher());
            }
        } );
        add(save);
        add(load);

        add(Box.createHorizontalStrut(20));

        clear = new JButton("Clear Mem");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(null, "Clear Everything?","Warning",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION) {
                    mima.getSpeicher().clear();
                    memEdit.clearComments();
                    memEdit.revalidate();
                }
            }
        } );
        add(clear);

        add(Box.createHorizontalStrut(20));

        help = new JButton("Help");
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
    public void setFrame(JFrame frame){
        parent = frame;
    }

}
