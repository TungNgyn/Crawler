package Charaktere;

public abstract class Charaktere {
    String name;
    int hp, maxHp, sp, maxSp, exp, lvl, str, dex, kno, wis;

    public Charaktere(String name, int maxHp, int maxSp, int exp, int lvl,
                      int str, int dex, int kno, int wis) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxSp = maxSp;
        this.sp = maxSp;
        this.exp = exp;
        this.lvl = lvl;
        this.str = str;
        this.dex = dex;
        this.kno = kno;
        this.wis = wis;
    }

    public abstract int amLeben();
}
