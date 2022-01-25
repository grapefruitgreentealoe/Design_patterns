package behavioral_patterns.templatemethod.after;

public class BeverageTestDrive {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        coffee.prepareRecipe();
        tea.prepareRecipe();
    }
}
