package creational_patterns.singleton.after;

import java.io.Serializable;

public class Settings implements Serializable {

    private static Settings instance;

    private Settings() {}
    /*
    * synchronized 키워드 사용
    * - 간단하게 멀티 쓰레드 환경에서 인스턴스가 여러 개 생성되는 것을 막을 수 있지만
    * - getInstance 함수를 호출할 때마다 락을 검사하기 때문에 약간의 성능 문제가 발생
    */
    public static synchronized Settings getInstance() {
        if (instance == null)
            instance = new Settings();

        return instance;
    }

    /* 역직렬화할 때 이 메소드를 거치게 된다. */
    protected Object readResolve() {
        return getInstance();
    }
}
