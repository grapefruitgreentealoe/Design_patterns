# 싱글톤 패턴

- 클래스의 **인스턴스를 오직 한 개만 제공**하는 클래스
- 인스턴스를 글로벌하게 엑세스할 방법
- 시스템 런타임, 환경 세팅에 대한 정보들에 사용됨
- 싱글톤 패턴을 사용하면 메모리 측면에서 이점을 얻을 수 있음
- 인스턴스가 하나이기 때문에 동시성을 조심해야 됨

## 다이어그램

![singleton](https://user-images.githubusercontent.com/50051656/149616788-cacb40e8-9e3d-4753-a00d-59a849bef0b9.png)

- 자기 자신의 인스턴스를 가짐
- 생성자를 통해 생성하지 못하도록 private으로 막혀있음
- getInstance() 함수를 통해서 인스턴스를 얻음

## 구현

### 방법 1 (synchronized keyword)

- getInstance() 함수에 synchronized 키워드를 붙여서 동시성을 해결
- **But,** 동시성에서는 안전하나 인스턴스를 얻으려고 할 때마다 락에 인한 오버헤드로 인해 처리 속도에 치명적임

```java
public class Settings {

    private static Settings instance;

    private Settings() {}
    
    public static synchronized Settings getInstance() {
        if (instance == null)
            instance = new Settings();

        return instance;
    }
}
```

### 방법 2 (eager initialization)

- 방법 1에서 synchronized를 없애고 이른 초기화를 통해서 미리 객체를 만들어두어 사용하는 방법
- 이 방법을 이용하면 락에 인한 오버헤드가 발생하지 않고 동시성을 처리할 수 있음
- **But,** 객체가 무겁다면(비용이 많이 든다면) 좋지 않은 방법

```java
public class Settings2 {
    
    private static final Settings2 INSTANCE = new Settings2();

    private Settings2() {}

    public static Settings2 getInstance() {
        return INSTANCE;
    }
}
```

### 방법 3 (double locking)

- 더블 락킹을 이용하면 지연 로딩과 동시성을 둘 다 해결
- instance가 null로 들어오게 되면 그 안에서 동시성 처리가 이루어지기 때문에 서로 다른 인스턴스가 생길 염려 X
- 함수에 동시성이 걸려있지 않아 오버헤드가 발생하지 않고 사용이 될 때 메모리 할당이 이루어지므로 효율적임

```java
package creational_patterns.singleton.after;

public class Settings3 {
    
    private static volatile Settings3 instance;

    private Settings3() {}

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
```

### 방법 4 (static inner class)

- getInstance()가 호출된 시점에 SettingHolder가 load 되기 때문에 lazy initialization의 이점을 얻을 수 있음
- thread-safe

```java
public class Settings4 {

    private Settings4() {}

    private static class SettingsHolder {
        private static final Settings4 INSTANCE = new Settings4();
    }

    public static Settings4 getInstance() {
        return SettingsHolder.INSTANCE;
    }

}
```

### 방법 5 (Enum)

- 기본적으로 thread-safe
- 구현이 단순
- 직렬화/역직렬화, 리플렉션에 안전

```java
public enum Settings5 {

    INSTANCE;

    Settings5() {}

    public Settings5 getInstance() {
        return INSTANCE;
    }

}
```

## 성능

![singleton_speed](https://user-images.githubusercontent.com/50051656/149618174-7bbc8caa-f0c5-458b-a0cd-49b43be7ce4b.png)

출처 : [바로가기](http://literatejava.com/jvm/fastest-threadsafe-singleton-jvm/)