package de.c1bergh0st.main;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.Steuerwerk;
import de.c1bergh0st.visual.BottomBar;
import de.c1bergh0st.visual.MemoryEditor;
import de.c1bergh0st.visual.RegisterView;
import de.c1bergh0st.visual.TopBar;

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

        MemoryEditor memEdit = new MemoryEditor(mima.getSpeicher(),mima);
        background.add(memEdit.getPanel(), BorderLayout.WEST);
        RegisterView regView = new RegisterView(mima);
        background.add(regView, BorderLayout.CENTER);
        background.add(new BottomBar(mima, memEdit, regView), BorderLayout.PAGE_END);
        background.add(new TopBar(mima, memEdit) ,BorderLayout.PAGE_START);



        frame.add(background);
        frame.pack();
        frame.setVisible(true);


    }
}
