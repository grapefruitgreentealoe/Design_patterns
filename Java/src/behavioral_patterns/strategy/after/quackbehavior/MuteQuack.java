package behavioral_patterns.strategy.after.quackbehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("not quack");
    }
}
