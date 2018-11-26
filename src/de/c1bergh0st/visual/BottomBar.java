package de.c1bergh0st.visual;

import javax.swing.*;
import java.awt.*;

public class BottomBar extends JPanel {
    public JButton oneStep;
    private JLabel speedLabel;
    public JSlider stepspeed;
    private JLabel stepLabel;
    public JSpinner stepsToTake;
    public JButton start;
    public JButton stop;


    public BottomBar(){
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        oneStep = new JButton("One Step");
        add(oneStep);

        speedLabel = new JLabel("Speed:");
        add(speedLabel);

        stepspeed = new JSlider(1,5,3);
        stepspeed.setMajorTickSpacing(1);
        stepspeed.setPaintLabels(true);
        add(stepspeed);

        stepLabel = new JLabel("Steps:");
        add(stepLabel);

        stepsToTake = new JSpinner(new SpinnerNumberModel(100, //initial value
                1, //min
                1000, //max
                1));
        add(stepsToTake);

        start = new JButton("Start");
        add(start);

        stop = new JButton("Stop");
        add(stop);
    }

}
