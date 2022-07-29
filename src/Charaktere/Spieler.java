package Charaktere;

import java.util.Random;

public class Spieler extends Charaktere {

    public Spieler() {
        super();
    }

//    public Spieler(String name, int maxHp, int maxSp, int exp, int lvl,
//                   int str, int dex, int kno, int wis) {
//        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis);
//    }



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
        System.out.println("spielerAtk1 " + range1);
        System.out.println("spielerAtk2 " + range2);
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
        System.out.println("spielerdef1 " + range1);
        System.out.println("spielerdef2 " + range2);
        return (int) verteidigung;
    }
}
