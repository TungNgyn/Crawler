package Equip.Schmuck;

import Equip.Ruestung.Helm;

import javax.swing.*;

public class Ring extends Schmuck{


    public Ring(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name,atk,def,str,dex,kno,wis,wert,bild);
    }

    public static Ring ring = new Ring("Ring",0,10,5,0,0,0,100,new ImageIcon("src/res/Equip/Schmuck/OPRing.jpeg"));
    public static Ring opRing = new Ring("OPRing",999,999,999,999,999,999,9999999,new ImageIcon("src/res/Equip/Schmuck/OPRing.jpeg"));

}
