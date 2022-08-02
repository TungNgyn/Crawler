package Equip.Ruestung;

import javax.swing.*;

public class Helm extends Ruestung{

    public Helm() {
        super();
    }

    public Helm(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name,atk,def,str,dex,kno,wis,wert,bild);
    }

    public static Helm eisenhelm = new Helm("Eisenhelm",0,10,5,0,0,0,100,new ImageIcon("src/res/Equip/Ruestung/Eisenhelm.jpeg"));
}
