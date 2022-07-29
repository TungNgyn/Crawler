package Charaktere;

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
    public int angriff(String modifier, int kraft) {
        int angriffsWert = 0;

        switch (modifier) {
            case "str":
                angriffsWert = (atk + str * (kraft/100));
                break;
            case "dex":
                angriffsWert = (atk + dex * (kraft/100));
                break;
            case "kno":
                angriffsWert = (atk + kno * (kraft/100));
                break;
            case "wis":
                angriffsWert = (atk + wis * (kraft/100));
                break;
        }

        return angriffsWert;
    }
}
