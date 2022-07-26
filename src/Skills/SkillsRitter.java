package Skills;

import javax.swing.*;

public class SkillsRitter extends Skills{
    public SkillsRitter(String name, String mod, int kraft, ImageIcon bild) {
        super(name, mod, kraft, bild);
    }

    public static SkillsRitter skillAngriff = new SkillsRitter("Angriff", "str", 100, new ImageIcon("res/Skills/Ritter/active1.png"));
    public static SkillsRitter skillSchuss = new SkillsRitter("Schuss", "dex", 90, new ImageIcon("res/Skills/Ritter/active2.png"));
}
