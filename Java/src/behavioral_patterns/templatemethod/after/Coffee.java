package behavioral_patterns.templatemethod.after;

public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕 추가하는 중");
    }
}
