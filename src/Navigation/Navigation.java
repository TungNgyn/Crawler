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



    public static Navigation naviLager = new Navigation("Lager",new ImageIcon("res/Icons/Instagram_2.png"));
    public static Navigation naviKampf = new Navigation("Kampf",new ImageIcon("res/Icons/Battle.png"));
    public static Navigation naviEvent = new Navigation("Event",new ImageIcon("res/Icons/Reddit.png"));
    public static Navigation naviBoss = new Navigation("Boss",new ImageIcon("res/Icons/TikTok.png"));
}
