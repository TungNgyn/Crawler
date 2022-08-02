package Equip.Waffe;

import javax.swing.*;

public class Schwert extends Waffe{

    public Schwert(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name,atk,def,str,dex,kno,wis,wert,bild);
    }

    public static Schwert grossschwert = new Schwert("Großschwert",50,0,13,5,0,0,200,new ImageIcon("src/res/Equip/Waffe/Grossschwert.jpeg"));

}
