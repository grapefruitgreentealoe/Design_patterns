package creational_patterns.proxy.before;

/**
 * startGame() 의 시간을 재고 싶다.
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameService();
        // 앞 뒤로 코드를 넣지않고 구현
        gameService.startGame();
        // 앞 뒤로 코드를 넣지않고 구현
    }
}
