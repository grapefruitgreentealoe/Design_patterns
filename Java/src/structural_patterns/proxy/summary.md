# 프록시 패턴

- 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴
- 객체의 생성 비용이 많이 들어 실제 사용 시점에 객체를 생성하거나, 실제 객체에 접근을 제한 및 제어를 해야 할 때 사용
  - 초기화 지연, 접근 제어, 로깅, 캐싱

## 다이어그램

<div align="center">

![proxy](https://user-images.githubusercontent.com/50051656/149619520-74302485-b39e-4b8a-bf68-316213a6af0c.png)

</div>

- Subject : Proxy, RealSubject가 구현해야 하는 인터페이스
- RealSubject : 실제 수행되는 주 기능
- Proxy : RealSubject와 Client 요청 사이에 존재하는 객체

## 구현

### Subject

- 현재 서비스엔 게임 시작이라는 기능이 존재

```java
public interface GameService {

    void startGame();
}
```

### RealSubject

- 실제 객체에서 게임 시작 기능을 구현

```java
public class DefaultGameService implements GameService{

    @Override
    public void startGame() {
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
    }
}
```

### Proxy

- Subject가 구현된 RealSubject를 인자로 주입받거나 사용 시에 초기화
- 게임 시작할 때 걸리는 시간을 알기 위해서 로깅을 추가

```java
public class GameServiceProxy implements GameService {

    private GameService gameService;

    public GameServiceProxy(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        long before = System.currentTimeMillis();
//        lazy-initialization
//        if (this.gameService == null) {
//            this.gameService = new DefaultGameService();
//        }
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
```

### Client

- 프록시에 실제 기능을 구현을 객체를 주입하고 프록시 객체에서 게임 시작을 실행
- 게임 시작에 걸리는 시간이 측정됨

```java
public class Client {

    public static void main(String[] args) {
        GameServiceProxy gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
```