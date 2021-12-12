package creational_patterns.singleton.after;

public class Settings3 {

    /*
    * 기본적으로 변수의 값은 메인 메모리에서 읽어들이고
    * 멀티스레드 어플리케이션에서는 task를 수행하는 동안 성능 향상을 위해
    * Main Memory에 읽은 변수 값을 CPU cache에 저장하게 된다.
    * volatile을 이용하면 해당 변수를 메인 메모리에 저장하겠다는 것이고
    * 그렇게 저장하지 않으면 해당 변수가 캐싱되어 값이 불일치될 수 있다.
    * */
    private static volatile Settings3 instance;

    private Settings3() {}

    /* Double checked locking */
    public static Settings3 getInstance() {
        if (instance == null) {
            synchronized (Settings3.class) {
                if (instance == null) {
                    instance = new Settings3();
                }
            }
        }
        return instance;
    }
}
