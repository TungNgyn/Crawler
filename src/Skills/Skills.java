package Skills;

import javax.swing.*;

public class Skills {
    String name;
    String mod;
    int kraft;
    int genauigkeit;
    int anzahl;
    int spKosten;
    int hpKosten;
    ImageIcon bild;

    public Skills() {

    }

    public Skills(String name, String mod, int kraft, int genauigkeit,  int spKosten, int hpKosten, int anzahl, ImageIcon bild) {
        this.name = name;
        this.mod = mod;
        this.kraft = kraft;
        this.spKosten = spKosten;
        this.hpKosten = hpKosten;
        this.genauigkeit = genauigkeit;
        this.anzahl = anzahl;
        this.bild = bild;
    }


    //main Skills
    public static Skills skill1 = new Skills();
    public static Skills skill2 = new Skills();
    public static Skills skill3 = new Skills();
    public static Skills skill4 = new Skills();
    public static Skills skill5 = new Skills();

    //str <html><font color='#ff0000'>
    public static Skills skillAngriff = new Skills("Angriff", "str", 100,90,
            0,0,1, new ImageIcon("src/res/Skills/Ritter/active1.png"));
    public static Skills skillAnsturm= new Skills("Ansturm", "str", 85, 95,
            5,0,1,new ImageIcon("src/res/Skills/Ritter/active2.png"));
    public static Skills skillDoppelschlag = new Skills("Doppelschlag", "str", 90,100,
            10,0,2, new ImageIcon("src/res/Skills/Ritter/active3.png"));
    public static Skills skillStampfer = new Skills("Stampfer", "str", 60, 150,
            4,0,1,new ImageIcon("src/res/Skills/Ritter/active4.png"));
    public static Skills skillSchlaghagel = new Skills("Schlaghagel", "str", 150,60,
            15,0,3, new ImageIcon("src/res/Skills/Ritter/active5.png"));


    //dex <html><font color='#3cb371'>
    public static Skills skillSchuss = new Skills("Schuss", "dex", 100,90,
            0,0,1, new ImageIcon("src/res/Skills/Ritter/active6.png"));
    public static Skills skillGezielterSchuss = new Skills("Gezielter Schuss", "dex", 85,95,
            5,0, 1, new ImageIcon("src/res/Skills/Ritter/active7.png"));
    public static Skills skillMehrfachSchuss = new Skills("Merfachschuss", "dex", 90,100,
            10,0,2, new ImageIcon("src/res/Skills/Ritter/active8.png"));
    public static Skills skillAutomatischerSchuss = new Skills("Auto. Schuss", "dex", 60,150,
            4,0,1, new ImageIcon("src/res/Skills/Ritter/active9.png"));
    public static Skills skillWyvernSchuss = new Skills("Wyvernschuss", "dex", 150,60,
            15,0,1, new ImageIcon("src/res/Skills/Ritter/active10.png"));

    //kno <html><font color='#94d0ff'>
    //wis <html><font color='#ffe400'>


    public int getGenauigkeit() {
        return genauigkeit;
    }

    public void setGenauigkeit(int genauigkeit) {
        this.genauigkeit = genauigkeit;
    }
    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public int getHpKosten() {
        return hpKosten;
    }

    public void setHpKosten(int hpKosten) {
        this.hpKosten = hpKosten;
    }

    public int getSpKosten() {
        return spKosten;
    }

    public void setSpKosten(int spKosten) {
        this.spKosten = spKosten;
    }
    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }
    public int getKraft() {
        return kraft;
    }

    public void setKraft(int kraft) {
        this.kraft = kraft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getBild() {
        return bild;
    }

    public void setBild(ImageIcon bild) {
        this.bild = bild;
    }
}
