package de.c1bergh0st.mima;

import de.c1bergh0st.debug.Debug;

public class Speicher {
    Register sdr, sar;
    int[] hauptSpeicher;

    public Speicher(Register sdr, Register sar){
        if(sdr != null && sar != null && sar.getSize() == 20){
            this.sdr = sdr;
            this.sar = sar;
        } else {
            Debug.sendErr("SDR OR SAR IS NULL OR INVALID SIZE",2);
        }
        hauptSpeicher = new int[1048576];
    }

    public void updateSDR(){
        sdr.setValue(hauptSpeicher[sar.getValue()]);
    }

    public void write(){
        hauptSpeicher[sar.getValue()] = sdr.getValue();
    }

    public void setMem(int adr, int value){
        if(adr >= 0 && adr <= Steuerwerk.MAX_ADRESS){
            hauptSpeicher[adr] = value;
        }
    }

    public int getMem(int adr){
        if(adr >= 0 && adr <= Steuerwerk.MAX_ADRESS){
            return hauptSpeicher[adr];
        }
        return 0;
    }

    public void clear(){
        for(int i = 0; i < hauptSpeicher.length; i++){
            setMem(i,0);
        }
    }

}
