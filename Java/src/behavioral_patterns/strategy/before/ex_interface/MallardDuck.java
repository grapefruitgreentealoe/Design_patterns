package behavioral_patterns.strategy.before.ex_interface;

public class MallardDuck extends Duck implements Flyable, Quackable{
    @Override
    void display() {
        System.out.println("mallardDuck");
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
