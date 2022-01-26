package behavioral_patterns.strategy.before.ex_inheritance;

public class RubberDuck extends Duck {
    @Override
    void display() {
        System.out.println("rubberDuck");
    }
    @Override
    void quack() { System.out.println("squeak"); }
    @Override
    void fly() { System.out.println("not fly"); }
}
