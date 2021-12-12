package structural_patterns.proxy.before;

public class GameService {

    public void startGame() throws InterruptedException {
        // 앞 뒤로 코드를 넣지않고 구현
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
        Thread.sleep(1000L);
        // 앞 뒤로 코드를 넣지않고 구현
    }
}
