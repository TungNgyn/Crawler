package Equip;

import javax.swing.*;

public abstract class Equip {
    String name;
    int atk, def, str, dex, kno, wis, wert;
    ImageIcon bild;

    public Equip() {

    }


    public Equip(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.str = str;
        this.dex = dex;
        this.kno = kno;
        this.wis = wis;
        this.wert = wert;
        this.bild = bild;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getKno() {
        return kno;
    }

    public int getWis() {
        return wis;
    }

    public int getWert() {
        return wert;
    }

    public ImageIcon getBild() {
        return bild;
    }
}
