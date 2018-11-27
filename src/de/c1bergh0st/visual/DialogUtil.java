package de.c1bergh0st.visual;

import javax.swing.*;

public class DialogUtil {

    public static void showErrorToUser(String title,String message){
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

}
