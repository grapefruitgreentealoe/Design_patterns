package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyWithWings;
import behavioral_patterns.strategy.after.quackbehavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("mallardduck");
    }
}
