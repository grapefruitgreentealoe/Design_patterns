package behavioral_patterns.strategy.after.flybehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly");
    }
}
