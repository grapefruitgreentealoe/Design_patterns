package creational_patterns.singleton.before;

public class App {
    public static void main(String[] args) {
        Settings settings = new Settings();
        Settings settings2 = new Settings();
        System.out.println(settings != settings2);
    }
}
