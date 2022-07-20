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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getMaxSp() {
        return maxSp;
    }

    public void setMaxSp(int maxSp) {
        this.maxSp = maxSp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getKno() {
        return kno;
    }

    public void setKno(int kno) {
        this.kno = kno;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public abstract boolean amLeben();
    public abstract double angriff(String modifier, int anzahlAngriffe);
}
