package Charaktere;

public class Spieler extends Charaktere{

    public Spieler(String name, int maxHp, int maxSp, int exp, int lvl,
                   int str, int dex, int kno, int wis) {
        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis);
    }



    @Override
    public boolean amLeben() {
        return hp>0;
    }

    @Override
    public double angriff(String modifier, int anzahlAngriffe) {
        for (int i = 0; i < anzahlAngriffe; i++) {
            switch (modifier) {
                case "str":
                    return str*0.1+10;
                    break;
                case "dex":
                    return dex*0.1+10;
                    break;
                case "kno":
                    return kno*0.1+10;
                    break;
                case "wis":
                    return wis*0.1+10;
                    break;
            }
        }
        return 0;
    }
}
