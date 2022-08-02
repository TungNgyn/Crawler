package Equip.Waffe;

import Equip.Equip;

import javax.swing.*;

public class Waffe extends Equip {

    public Waffe() {
        super();
    }

    public Waffe(String name, int atk, int def, int str, int dex, int kno, int wis, int wert, ImageIcon bild) {
        super(name, atk, def, str, dex, kno, wis, wert, bild);
    }

    public static Waffe mainWaffe = new Waffe();
}
