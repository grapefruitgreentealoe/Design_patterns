package behavioral_patterns.strategy.before.ex_inheritance;

public class DecoyDuck extends Duck{
    @Override
    void display() { System.out.println("decoyduck"); }
    @Override
    void quack() { System.out.println("not quack"); }
    @Override
    void fly() { System.out.println("not fly"); }
}
