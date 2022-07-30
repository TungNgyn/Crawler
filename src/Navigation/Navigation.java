package Navigation;

import javax.swing.*;

public class Navigation {
    String name;
    ImageIcon bild;


    public Navigation(String name, ImageIcon bild) {
        this.name = name;
        this.bild = bild;
    }

    public String getName() {
        return name;
    }
    public ImageIcon getBild() {
        return bild;
    }



    public static Navigation naviLager = new Navigation("Lager",new ImageIcon("res/Icons/Lager.png"));
    public static Navigation naviKampf = new Navigation("Kampf",new ImageIcon("res/Icons/Kampf.png"));
    public static Navigation naviEvent = new Navigation("Event",new ImageIcon("res/Icons/Event.png"));
    public static Navigation naviBoss = new Navigation("Boss",new ImageIcon("res/Icons/Boss.png"));
}
