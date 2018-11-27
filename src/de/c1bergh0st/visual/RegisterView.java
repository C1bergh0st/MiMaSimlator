package de.c1bergh0st.visual;

import de.c1bergh0st.mima.Steuerwerk;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JPanel {
    private Steuerwerk mima;
    private VisualRegister akku;
    private VisualRegister ir;
    private VisualRegister iar;


    public RegisterView(Steuerwerk mima){
        this.mima = mima;
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        akku = new VisualRegister(mima.getAkku(),"Akku",VisualRegister.FULLVALUE);
        add(akku);
        iar = new VisualRegister(mima.getIAR(),"IAR (Next step)",VisualRegister.ADRESS);
        add(iar);
        ir = new VisualRegister(mima.getIR(),"IR",VisualRegister.INSTRUCTION);
        add(ir);
        refresh();
    }

    public void refresh(){
        akku.refresh();
        ir.refresh();
        iar.refresh();
    }

}
