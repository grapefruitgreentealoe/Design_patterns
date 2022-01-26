package behavioral_patterns.strategy.before.ex_inheritance;

public abstract class Duck {

    void quack() {
        System.out.println("quack");
    }

    void swim() {
        System.out.println("swim");
    }

    void fly() {
        System.out.println("fly");
    }

    abstract void display();
}
