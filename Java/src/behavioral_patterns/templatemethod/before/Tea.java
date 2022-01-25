package behavioral_patterns.templatemethod.before;

public class Tea {
    final void prepareRecipe(){
        System.out.println("물 끓이는 중");
        System.out.println("차 우려내는 중");
        System.out.println("컵에 따르는 중");
        if(customerWantsCondiments()){
            System.out.println("레몬을 추가하는 중");
        }
    }
    boolean customerWantsCondiments() {
        return true;
    }
}
