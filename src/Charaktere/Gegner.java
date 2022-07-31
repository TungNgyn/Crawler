package Charaktere;

import javax.swing.*;
import java.util.Random;

public class Gegner extends Charaktere{


    public Gegner() {

    }
    public Gegner(String name, int maxHp, int maxSp, String mod, int exp, int lvl, int atk, int def, int str, int dex, int kno, int wis, int gold, ImageIcon bild) {
        super(name, maxHp, maxSp, mod, exp, lvl, atk, def, str, dex, kno, wis, gold,bild);
    }

    @Override
    public boolean amLeben() {
        return hp>0;
    }

    @Override
    public int angriff(String mod, int kraft) {
        double angriffsWert = 0;

        switch (mod) {
            case "str":
                angriffsWert = (atk + str * ((double) kraft/100));
                break;
            case "dex":
                angriffsWert = (atk + dex * ((double) kraft/100));
                break;
            case "kno":
                angriffsWert = (atk + kno * ((double) kraft/100));
                break;
            case "wis":
                angriffsWert = (atk + wis * ((double) kraft/100));
                break;
        }
        double range1 =  angriffsWert-(angriffsWert/(10));
        double range2 =  angriffsWert+(angriffsWert/(10));
        Random rng = new Random();
        angriffsWert = rng.nextDouble(range1,range2);
        return (int) angriffsWert;
    }
    public int verteidigung(String mod) {
        double verteidigung = 0;
        switch (mod) {
            case "str":
                verteidigung = str + def;
                break;
            case "dex":
                verteidigung = dex + def;
                break;
            case "kno":
                verteidigung = kno + def;
                break;
            case "wis":
                verteidigung = wis + def;
                break;
        }
        double range1 =  verteidigung-(verteidigung/(10));
        double range2 =  verteidigung+(verteidigung/(10));
        Random rng = new Random();
        verteidigung = rng.nextDouble(range1,range2);
        return (int) verteidigung;
    }

    public static Gegner gegnerFledermaus = new Gegner("Fledermaus", 10,0,"dex",
            10,1,15,15,1,4,1,2,3,new ImageIcon("res/Gegner/Fledermaus.png"));
    public static Gegner gegnerSchneemann = new Gegner("Schneemann", 20,0,"str",
            20,1,15,15,3,2,3,1,5,new ImageIcon("res/Gegner/Schneemann.png"));
    public static Gegner gegnerBehemoth = new Gegner("Behemoth", 20,0,"str",
            50,1,45,40,12,4,6,3,50,new ImageIcon("res/Gegner/Behemoth.png"));
}
