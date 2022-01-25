package behavioral_patterns.templatemethod.before;

public class BeverageTestDrive {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();

        coffee.prepareRecipe();
        tea.prepareRecipe();
    }
}
