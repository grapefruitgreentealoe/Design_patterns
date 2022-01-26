package behavioral_patterns.strategy.before.ex_interface;

public class RubberDuck extends Duck implements Quackable {
    @Override
    void display() {
        System.out.println("rubberDuck");
    }

    @Override
    public void quack() {
        System.out.println("squeak");
    }
}
