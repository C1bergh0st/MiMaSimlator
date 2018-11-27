package de.c1bergh0st.visual;

import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BottomBar extends JPanel {
    public JButton oneStep;
    public JButton start;
    private Steuerwerk mima;
    private MemoryEditor memEdit;


    public BottomBar(Steuerwerk mima, MemoryEditor memEdit){
        this.mima = mima;
        this.memEdit = memEdit;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        oneStep = new JButton("One Step");
        oneStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.step();
                memEdit.revalidate();
            }
        } );
        add(oneStep);

        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.stepTill(10000);
                memEdit.revalidate();
            }
        } );
        add(start);
    }

}
