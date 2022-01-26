package behavioral_patterns.strategy.after.client;

import behavioral_patterns.strategy.after.flybehavior.FlyBehavior;
import behavioral_patterns.strategy.after.flybehavior.FlyWithWings;
import behavioral_patterns.strategy.after.quackbehavior.MuteQuack;
import behavioral_patterns.strategy.after.quackbehavior.QuackBehavior;

public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck() {
            @Override
            public void display() {
                System.out.println("duck");
            }
        };
        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackBehavior(new MuteQuack());
        Duck duck2 = new Duck() {
            @Override
            public void display() {
                System.out.println("duck2");
            }
        };
        duck2.setFlyBehavior(new FlyBehavior() {
            @Override
            public void fly() {
                System.out.println("fast fly");
            }
        });
        duck2.setQuackBehavior(new QuackBehavior() {
            @Override
            public void quack() {
                System.out.println("QQQQQQQQQuack");
            }
        });
    }
}
