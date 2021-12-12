package creational_patterns.singleton.after;

/*
* Reflection, Deserialization 에 안전하며
* Thread-safe를 보장한다.
* */
public enum Settings5 {

    INSTANCE;

    Settings5() {}

    public Settings5 getInstance() {
        return INSTANCE;
    }

}
