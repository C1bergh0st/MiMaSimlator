package de.c1bergh0st.main;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.Steuerwerk;
import de.c1bergh0st.visual.BottomBar;
import de.c1bergh0st.visual.MemoryEditor;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Steuerwerk mima = new Steuerwerk();
        Debug.send("Done");
        JFrame frame = new JFrame("MiMa Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel background = new JPanel();
        background.setLayout(new BorderLayout());
        background.setPreferredSize(new Dimension(800,600));

        background.add(new BottomBar(), BorderLayout.PAGE_END);
        background.add(new MemoryEditor(mima.getSpeicher()).getPanel(), BorderLayout.WEST);

        frame.add(background);
        frame.pack();
        frame.setVisible(true);
    }
}
