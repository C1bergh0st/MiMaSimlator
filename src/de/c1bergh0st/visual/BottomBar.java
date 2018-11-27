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
    private RegisterView registerView;


    public BottomBar(Steuerwerk mima, MemoryEditor memEdit, RegisterView registerView){
        this.mima = mima;
        this.memEdit = memEdit;
        this.registerView = registerView;
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        oneStep = new JButton("One Step");
        oneStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.step();
                memEdit.revalidate();
                registerView.refresh();
            }
        } );
        add(oneStep);

        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mima.stepTill(10000);
                memEdit.revalidate();
                registerView.refresh();
            }
        } );
        add(start);
    }

}
