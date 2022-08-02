package Equip.Ruestung;

import Equip.Equip;

import javax.swing.*;

public class Ruestung extends Equip {

    public Ruestung() {
        super();
    }

    public Ruestung(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name,atk,def,str,dex,kno,wis,wert,bild);
    }

    public static Ruestung mainRuestung = new Ruestung();
}
