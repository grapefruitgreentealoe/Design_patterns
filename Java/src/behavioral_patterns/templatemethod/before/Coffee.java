package behavioral_patterns.templatemethod.before;

public class Coffee {
    final void prepareRecipe(){
        System.out.println("물 끓이는 중");
        System.out.println("필터로 커피를 우려내는 중");
        System.out.println("컵에 따르는 중");
        if(customerWantsCondiments()){
            System.out.println("설탕 추가하는 중");
        }
    }
    boolean customerWantsCondiments() {
        return true;
    }
}