package behavioral_patterns.strategy.after.quackbehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}
