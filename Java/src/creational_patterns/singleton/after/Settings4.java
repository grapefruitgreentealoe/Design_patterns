package creational_patterns.singleton.after;

public class Settings4 {

    private Settings4() {}

    /* static inner class 사용 */
    private static class SettingsHolder {
        private static final Settings4 INSTANCE = new Settings4();
    }

    public static Settings4 getInstance() {
        return SettingsHolder.INSTANCE;
    }

}
