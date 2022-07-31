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
}
