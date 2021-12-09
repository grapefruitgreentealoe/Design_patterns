package creational_patterns.proxy.after;

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
