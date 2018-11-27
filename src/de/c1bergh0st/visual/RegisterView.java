package de.c1bergh0st.visual;

import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;

public class RegisterView extends JPanel {
    private Steuerwerk mima;
    private VisualRegister akku;
    private VisualRegister ir;
    private VisualRegister iar;


    public RegisterView(Steuerwerk mima){
        this.mima = mima;
    }

    public void refresh(){
        akku.refresh();
        ir.refresh();
        iar.refresh();
    }

}
