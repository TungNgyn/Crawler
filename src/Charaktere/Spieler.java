package Charaktere;

public class Spieler extends Charaktere{

    public Spieler(String name, int maxHp, int maxSp, int exp, int lvl,
                   int str, int dex, int kno, int wis) {
        super(name, maxHp, maxSp, exp, lvl, str, dex, kno, wis);
    }

    @Override
    public int amLeben() {
        return hp;
    }
}
