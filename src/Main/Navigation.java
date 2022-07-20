package Main;

public class Navigation {
    String name;

    public Navigation(String name) {
        this.name = name;
    }


    static Navigation lager = new Navigation("Lager");
    static Navigation kampf = new Navigation("Kampf");
    static Navigation event = new Navigation("Event");
    static Navigation boss = new Navigation("Boss");
}
