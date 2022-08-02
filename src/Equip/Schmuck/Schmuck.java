package Equip.Schmuck;

import Equip.Equip;

import javax.swing.*;

public class Schmuck extends Equip {
    public Schmuck() {
        super();
    }

    public Schmuck(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name,atk,def,str,dex,kno,wis,wert,bild);
    }
    public static Schmuck mainSchmuck = new Schmuck();
}
