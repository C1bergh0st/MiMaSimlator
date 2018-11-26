package de.c1bergh0st.visual;

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
        String trimmedString = binaryString.trim();
        while(trimmedString.length() < 25){
            trimmedString = "0"+trimmedString;
        }
        if(trimmedString.matches("^([1,0]{24})") && trimmedString.length() == 24){
            return true;
        }
        return false;
    }


}
