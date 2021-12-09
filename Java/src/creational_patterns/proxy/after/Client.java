package creational_patterns.proxy.after;

public class Client {

    public static void main(String[] args) {
        GameServiceProxy gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
