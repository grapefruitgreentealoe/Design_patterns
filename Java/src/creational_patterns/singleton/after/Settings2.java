package creational_patterns.singleton.after;

public class Settings2 {

    /*
    * eager initialization 사용
    * - 객체가 무겁다면 즉 비용이 많이 든다면 X (메모리를 많이 차지하거나 만드는데 오래 걸리지 않는 경우)
    * */
    private static final Settings2 INSTANCE = new Settings2();

    private Settings2() {}

    public static synchronized Settings2 getInstance() {
        return INSTANCE;
    }
}
