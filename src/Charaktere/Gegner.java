package Charaktere;

import javax.swing.*;

public class Gegner extends Charaktere{


    public Gegner() {

    }
    public Gegner(String name, int maxHp, int maxSp, int exp, int lvl, int str, int dex, int kno, int wis, ImageIcon bild) {
        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis, bild);
    }

    @Override
    public boolean amLeben() {
        return hp>0;
    }

    @Override
    public double angriff(String modifier, int kraft) {
        return 5;
    }

    public static Gegner fledermaus = new Gegner("Fledermaus", 10,0,5,1,1,4,1,2,new ImageIcon("res/Gegner/Fledermaus.png"));
    public static Gegner schneemann = new Gegner("Schneemann", 20,0,10,1,3,2,3,1,new ImageIcon("res/Gegner/Schneemann.png"));
}
