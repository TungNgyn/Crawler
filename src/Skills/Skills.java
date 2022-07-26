package Skills;

import javax.swing.*;

public class Skills {
    String name;
    String mod;
    int kraft;
    ImageIcon bild;


    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public Skills(String name, String mod, int kraft, ImageIcon bild) {
        this.name = name;
        this.mod = mod;
        this.kraft = kraft;
        this.bild = bild;
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
