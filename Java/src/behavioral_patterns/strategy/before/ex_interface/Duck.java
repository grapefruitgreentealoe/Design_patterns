package behavioral_patterns.strategy.before.ex_interface;

public abstract class Duck {

    void quack() {
        System.out.println("quack");
    }

    abstract void display();
}
