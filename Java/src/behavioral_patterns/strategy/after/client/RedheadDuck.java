package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyWithWings;
import behavioral_patterns.strategy.after.quackbehavior.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("redheadduck");
    }
}
