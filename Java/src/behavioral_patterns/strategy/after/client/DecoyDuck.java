package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyNoWay;
import behavioral_patterns.strategy.after.quackbehavior.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }
    @Override
    public void display() {
        System.out.println("decoyduck");
    }
}
