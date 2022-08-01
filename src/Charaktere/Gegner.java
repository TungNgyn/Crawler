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
        double angriffsWert = switch (mod) {
            case "str" -> (atk + str + (str * ((double) kraft / 100)));
            case "dex" -> (atk + dex + (dex * ((double) kraft / 100)));
            case "kno" -> (atk + kno + (kno * ((double) kraft / 100)));
            case "wis" -> (atk + wis + (wis * ((double) kraft / 100)));
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
            case "str" -> str*0.5 + def;
            case "dex" -> dex*0.5 + def;
            case "kno" -> kno*0.5 + def;
            case "wis" -> wis*0.5 + def;
            default -> 0;
        };
        double range1 =  verteidigung-(verteidigung/(10));
        double range2 =  verteidigung+(verteidigung/(10));
        Random rng = new Random();
        verteidigung = rng.nextDouble(range1,range2);
        return (int) verteidigung;
    }
    //Schneemann
    public static Gegner schneemann = new Gegner("Schneemann", 20,0,"str",
            20,1,15,15,3,2,3,1,5,new ImageIcon("src/res/Gegner/Schneemann.png"));

    //Mimic
    public static Gegner mimic = new Gegner("Mimic", 40,0,"wis",
            30,1,25,25,5,5,5,5,15,new ImageIcon("src/res/Gegner/Mimic.png"));

    //Mobs
    public static Gegner fledermaus = new Gegner("Fledermaus", 10,0,"dex",
            5,1,5,10,1,4,1,2,3,new ImageIcon("src/res/Gegner/Fledermaus.png"));

    public static Gegner hornisse = new Gegner("Hornisse", 15,0,"dex",
            5,1,5,13,2,5,1,2,4,new ImageIcon("src/res/Gegner/Hornisse.png"));
    public static Gegner ratte = new Gegner("Ratte", 10,0,"dex",
            5,1,5,10,1,5,1,1,7,new ImageIcon("src/res/Gegner/Ratte.png"));
    public static Gegner schlange = new Gegner("Schlange", 20,0,"str",
            10,1,10,15,6,5,1,2,15,new ImageIcon("src/res/Gegner/Schlange.png"));
    public static Gegner skorpion = new Gegner("Skorpion", 30,0,"str",
            15,1,8,20,8,3,2,1,15,new ImageIcon("src/res/Gegner/Skorpion.png"));
    public static Gegner zombie = new Gegner("Zombie", 30,0,"str",
            15,1,12,10,10,2,1,1,20,new ImageIcon("src/res/Gegner/Zombie.png"));

    //Mobs T2
    public static Gegner minotaurus = new Gegner("Minotaurus", 30,0,"str",
            25,1,15,30,8,4,1,1,30,new ImageIcon("src/res/Gegner/Minotaurus.png"));
    public static Gegner oger = new Gegner("Oger", 30,0,"str",
            25,1,15,30,7,4,2,2,25,new ImageIcon("src/res/Gegner/Oger.png"));
    public static Gegner werwolf = new Gegner("Werwolf", 30,0,"dex",
            25,1,20,25,5,9,2,1,25,new ImageIcon("src/res/Gegner/Werwolf.png"));
    
    //Boss
    public static Gegner daemon = new Gegner("Dämon", 40,0,"wis",
            50,1,30,20,7,3,1,8,50,new ImageIcon("src/res/Gegner/Daemon.png"));

    public static Gegner behemoth = new Gegner("Behemoth", 50,0,"str",
            50,1,30,30,10,4,6,3,50,new ImageIcon("src/res/Gegner/Behemoth.png"));

    public static Gegner drache = new Gegner("Drache", 70,0,"str",
            50,1,40,30,10,4,2,3,50,new ImageIcon("src/res/Gegner/Drache.png"));

    public static Gegner dunklerLord = new Gegner("Dunkler Lord", 30,0,"kno",
            50,1,20,15,2,2,14,5,50,new ImageIcon("src/res/Gegner/DunklerLord.png"));

}
