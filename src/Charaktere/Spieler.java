package Charaktere;

import javax.swing.*;
import java.util.Random;

import static Main.Spiel.*;

public class Spieler extends Charaktere {

    public Spieler() {
        super();
    }

//    public Spieler(String name, int maxHp, int maxSp, int exp, int lvl,
//                   int str, int dex, int kno, int wis) {
//        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis);
//    }

    public Spieler(String name, int maxHp, int maxSp, String mod, int exp, int lvl, int atk, int def,
                      int str, int dex, int kno, int wis, int gold, ImageIcon bild) {
        super(name,maxHp,maxSp,mod,exp,lvl,atk,def,str,dex,kno,wis,gold,bild);
    }
    public static Spieler krieger = new Spieler("Krieger",30,15,
            "str",0,1,15,15,10,8,2,3,0,
            new ImageIcon("src/res/Klassen/Krieger.png"));
    public static Spieler jaeger = new Spieler("Jäger",15,20,
            "dex",0,1,15,10,3,12,4,6,0,
            new ImageIcon("src/res/Klassen/Jaeger.png"));
    public static Spieler magier = new Spieler("Magier",15,30,
            "dex",0,1,20,10,1,3,15,3,0,
            new ImageIcon("src/res/Klassen/Magier.png"));
    public static Spieler kleriker = new Spieler("Kleriker",20,20,
            "dex",0,1,15,15,3,4,3,10,0,
            new ImageIcon("src/res/Klassen/Kleriker.png"));



    @Override
    public boolean amLeben() {
        return hp>0;
    }

    @Override
    public int angriff(String mod, int kraft) {
        double angriffsWert = switch (mod) {
            case "str" -> (totalAtk + totalStr + (totalStr * ((double) kraft / 100)));
            case "dex" -> (totalAtk + totalDex + (totalDex * ((double) kraft / 100)));
            case "kno" -> (totalAtk + totalKno + (totalKno * ((double) kraft / 100)));
            case "wis" -> (totalAtk + totalWis + (totalWis * ((double) kraft / 100)));
            default -> 0;
        };

        double range1 =  angriffsWert-(angriffsWert/(10));
        double range2 =  angriffsWert+(angriffsWert/(10));
        Random rng = new Random();
        angriffsWert = rng.nextDouble(range1,range2);
        return (int) angriffsWert;
    }
    public int verteidigung(String mod) {
        double verteidigung = switch (mod) {
            case "str" -> totalStr*0.5 + totalDef;
            case "dex" -> totalDex*0.5 + totalDef;
            case "kno" -> totalKno*0.5 + totalDef;
            case "wis" -> totalWis*0.5 + totalDef;
            default -> 0;
        };

        double range1 =  verteidigung-(verteidigung/(10));
        double range2 =  verteidigung+(verteidigung/(10));
        Random rng = new Random();
        verteidigung = rng.nextDouble(range1,range2);
        return (int) verteidigung;
    }
}
