//Copyright (C) 2018  Philipp Berdesinski
// A MiMa Simulator with GUI
// The Copyright outlined in the File LICENSE applies
package de.c1bergh0st.visual;

import de.c1bergh0st.debug.Debug;
import de.c1bergh0st.mima.Register;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("WeakerAccess")
public class VisualRegister extends JPanel {
    public static final int FULLVALUE = 0;
    public static final int ADRESS = 1;
    public static final int INSTRUCTION = 2;
    private Register register;
    private JLabel registerName;
    private JLabel binary;
    private JLabel meaning;
    private int type;

    public VisualRegister(Register register, String name, int type){
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        int height = 0;
        switch (type){
            case FULLVALUE:
                height = 60;
                break;
            case ADRESS:
                height = 40;
                break;
            case INSTRUCTION:
                height = 40;
                break;
        }
        this.setPreferredSize(new Dimension(300, height));
        this.register = register;
        this.type = type;
        registerName = new JLabel(" "+name);
        registerName.setBackground(Color.ORANGE);
        add(registerName);
        meaning = new JLabel("PLACEHOLDER");
        add(meaning);
        binary = new JLabel(ParseUtil.toBinaryString(1));
        if(type != INSTRUCTION && type != ADRESS){
            add(binary);
        }
    }

    public void refresh(){
        int i = register.getValue();
        if(type == FULLVALUE){ //Only the Decimal Representation
            String decimal = " " + ParseUtil.getDisplayValue(i, false);
            meaning.setText(decimal);
        } else if(type == ADRESS){
            String decimal = " " + ParseUtil.getDisplayValue(i,true);
            meaning.setText(decimal);
        } else if(type == INSTRUCTION){
            String decimal = ParseUtil.code(i);
            meaning.setText(" "+decimal);
        } else{
            Debug.sendErr("Wrong type in VisualRegister",1);
        }
        String binary = ParseUtil.toBinaryString(i);
        binary = binary.substring(binary.length()-register.getSize());
        this.binary.setText(" "+binary);
    }
}
