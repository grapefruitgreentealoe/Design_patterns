package creational_patterns.proxy.before;

public class GameServiceProxy extends GameService {

    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - before);
    }
}
