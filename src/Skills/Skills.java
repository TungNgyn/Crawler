package Skills;

import javax.swing.*;

public class Skills {
    String name;
    String mod;
    int kraft;
    int genauigkeit;
    ImageIcon bild;


    public Skills(String name, String mod, int kraft, int genauigkeit, ImageIcon bild) {
        this.name = name;
        this.mod = mod;
        this.kraft = kraft;
        this.genauigkeit = genauigkeit;
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

    public static Skills skillAngriff = new Skills("Angriff", "str", 100,90, new ImageIcon("res/Skills/Ritter/active1.png"));
    public static Skills skillAnsturm= new Skills("Ansturm", "str", 85, 95,new ImageIcon("res/Skills/Ritter/active2.png"));
    public static Skills skillBlitzschlag = new Skills("Blitzschlag", "str", 90,100, new ImageIcon("res/Skills/Ritter/active3.png"));
    public static Skills skillStampfer = new Skills("Stampfer", "str", 60, 150,new ImageIcon("res/Skills/Ritter/active4.png"));
    public static Skills skillBrutalerSchlag = new Skills("Brutaler Schlag", "str", 150,60, new ImageIcon("res/Skills/Ritter/active5.png"));


}
