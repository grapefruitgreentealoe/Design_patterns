package behavioral_patterns.strategy.after.flybehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("not fly");
    }
}
