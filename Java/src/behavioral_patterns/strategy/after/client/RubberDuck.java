package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyNoWay;
import behavioral_patterns.strategy.after.quackbehavior.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("rubberduck");
    }
}
