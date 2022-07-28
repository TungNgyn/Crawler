package Skills;

import javax.swing.*;

public class Skills {
    String name;
    String mod;
    int kraft;
    int genauigkeit;
    int anzahl;
    ImageIcon bild;


    public Skills(String name, String mod, int kraft, int genauigkeit, int anzahl, ImageIcon bild) {
        this.name = name;
        this.mod = mod;
        this.kraft = kraft;
        this.genauigkeit = genauigkeit;
        this.anzahl = anzahl;
        this.bild = bild;
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

    //str <html><font color='#ff0000'>
    public static Skills skillAngriff = new Skills("Angriff", "str", 100,90,1, new ImageIcon("res/Skills/Ritter/active1.png"));
    public static Skills skillAnsturm= new Skills("Ansturm", "str", 85, 95,1,new ImageIcon("res/Skills/Ritter/active2.png"));
    public static Skills skillDoppelschlag = new Skills("Doppelschlag", "str", 90,100,2, new ImageIcon("res/Skills/Ritter/active3.png"));
    public static Skills skillStampfer = new Skills("Stampfer", "str", 60, 150,1,new ImageIcon("res/Skills/Ritter/active4.png"));
    public static Skills skillBrutalerSchlag = new Skills("Brutaler Schlag", "str", 150,60,1, new ImageIcon("res/Skills/Ritter/active5.png"));


    //dex <html><font color='#3cb371'>
    public static Skills skillSchuss = new Skills("Schuss", "dex", 100,90,1, new ImageIcon("res/Skills/Ritter/active6.png"));
    public static Skills skillGezielterSchuss = new Skills("Gezielter Schuss", "dex", 85,95,1, new ImageIcon("res/Skills/Ritter/active7.png"));
    public static Skills skillMehrfachSchuss = new Skills("Merfachschuss", "dex", 90,100,2, new ImageIcon("res/Skills/Ritter/active8.png"));
    public static Skills skillAutomatischerSchuss = new Skills("Auto. Schuss", "dex", 60,150,1, new ImageIcon("res/Skills/Ritter/active9.png"));
    public static Skills skillWyvernSchuss = new Skills("Wyvernschuss", "dex", 150,60,1, new ImageIcon("res/Skills/Ritter/active10.png"));

    //kno #94d0ff
    //wis #ffe400


    public int getGenauigkeit() {
        return genauigkeit;
    }

    public void setGenauigkeit(int genauigkeit) {
        this.genauigkeit = genauigkeit;
    }
}
