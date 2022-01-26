package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyBehavior;
import behavioral_patterns.strategy.after.quackbehavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("swim");
    }

    public abstract void display();

}
