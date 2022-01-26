package behavioral_patterns.strategy.after.quackbehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}
