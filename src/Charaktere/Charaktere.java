package Charaktere;

import javax.swing.*;
import java.util.Random;

public abstract class Charaktere {
    String name, mod;
    int hp, maxHp, sp, maxSp, exp, lvl, atk, def, str, dex, kno, wis, gold;
    ImageIcon bild;

    public Charaktere(){

    };

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Charaktere(String name, int maxHp, int maxSp, String mod, int exp, int lvl, int atk, int def,
                      int str, int dex, int kno, int wis, int gold, ImageIcon bild) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxSp = maxSp;
        this.sp = maxSp;
        this.mod = mod;
        this.exp = exp;
        this.lvl = lvl;
        this.atk = atk;
        this.def = def;
        this.str = str;
        this.dex = dex;
        this.kno = kno;
        this.wis = wis;
        this.gold = gold;
        this.bild = bild;
    }

    public ImageIcon getBild() {
        return bild;
    }

    public void setBild(ImageIcon bild) {
        this.bild = bild;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
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
    public abstract int angriff(String modifier, int anzahlAngriffe);
    public abstract int verteidigung(String mod);
}
