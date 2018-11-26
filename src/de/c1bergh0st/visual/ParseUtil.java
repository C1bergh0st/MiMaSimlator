package de.c1bergh0st.visual;

import de.c1bergh0st.debug.Debug;

public class ParseUtil {
    /**
     *  Just a Utility Class to convert from Strings to binary and vice versa
     */


    /**
     *
     * @param binaryString A String to Test
     * @return Wheter the String only contains 1's and 0's and is max 24 'bits' long
     */
    public static boolean validBinary(String binaryString){
        String trimmedString = binaryString.replaceAll("\\s","");
        while(trimmedString.length() < 24){
            trimmedString = "0" + trimmedString;
        }
        Debug.send(trimmedString);

        if(trimmedString.matches("^([1,0]{24})") && trimmedString.length() == 24){
            return true;
        }
        return false;
    }

    public static boolean validCommand(String commandString){
        String s = commandString.replaceAll("\\s","");
        if(s.matches("^(LDC|LDV|STV|ADD|AND|OR|XOR|EQL|JMP|JMN|LDIV|STIV|RAR|NOT|EMPTY|HALT)[0-9]+$")){
            return true;
        }
        Debug.send("Regex didnt match: "+s);
        return false;
    }

    public static int parseCommand(String command){
        String s = command.trim();
        //We Remove characters until we only have a number left.
        while(!s.matches("^[0-9]+$") && s.length() > 1){
            s = s.substring(1);
        }
        //we take bits 0 to 19    Nicely prevents bigger values
        int result = maskAdr(Integer.parseInt(s));
        //we add bits 20 to 23 to it
        result += getOpCode(command)<<20;
        return maskValue(result);
    }

    public static int getOpCode(String command){
        int i = 0;
        String[] commands = {"LDC", "LDV", "STV", "ADD", "AND", "OR", "XOR", "EQL", "JMP", "JMN", "LDIV", "STIV", "RAR", "NOT", "EMPTY", "HALT"};

        while(!command.contains(commands[i]) && i < 16){
            i++;
        }

        if(i == 16){
            i = 0;
        }
        return i;
    }

    public static String toBinaryString(int i){
        String s = Integer.toBinaryString(i);
        while(s.length() < 24){
            s = "0" + s;
        }
        return s;
    }

    public static int maskValue(int i){
        return i & 0b00000000111111111111111111111111;
    }

    public static int maskAdr(int i){
        return i & 0b00000000000011111111111111111111;
    }

    public static String code(int value){
        int safeValue = maskValue(value);
        byte b = (byte)(safeValue>>>20);
        safeValue &= 0b00000000000011111111111111111111;
        String[] commands = {"LDC", "LDV", "STV", "ADD", "AND", "OR", "XOR", "EQL", "JMP", "JMN", "LDIV", "STIV", "RAR", "NOT", "EMPTY", "HALT"};
        if(b >= 0 && b < 16){
            String s =  commands[b] +" ";
            if(b < 12){
                s += safeValue;
            }
            return s;
        }
        return "Error";
    }
}
