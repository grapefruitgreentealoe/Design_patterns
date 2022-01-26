package behavioral_patterns.strategy.before.ex_interface;

public class RedheadDuck extends Duck implements Flyable, Quackable {
    @Override
    void display() {
        System.out.println("redheadDuck");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void quack() {
        System.out.println("quack");
    }
}
