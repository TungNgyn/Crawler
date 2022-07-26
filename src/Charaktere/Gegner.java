package Charaktere;

public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxSp, int exp, int lvl, int str, int dex, int kno, int wis) {
        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis);
    }

    @Override
    public boolean amLeben() {
        return hp>0;
    }

    @Override
    public double angriff(String modifier, int kraft) {
        return 5;
    }
}
