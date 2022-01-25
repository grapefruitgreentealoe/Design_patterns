# 템플릿 메소드 패턴

- 특정 작업을 처리하는 일부분을 서브 클래스로 캡슐화함
- 전체적인 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내용을 바꾸는 패턴
- 프레임워크에 많이 사용된다.
- 중복 코드를 줄이고 확장 용이

## 다이어그램

<div align="center">

![templatemethod](https://user-images.githubusercontent.com/50051656/150974858-65f764cd-6504-4397-a37c-caf1ad90d665.png)

</div>
- AbstractClass : 공통으로 처리하는 작업을 구현, 변경되는 부분 추상 메소드 선언
- ConcreteClass : 변경되는 부분 추상 메소드 구현

## 문제점

- 음료를 준비하는데 물을 끓이고 컵을 따르는 과정은 같음
- **하지만,** 우려내는 과정과 조미료가 다르다.
- 코드를 그대로 복붙하여 일부만 수정하여 코드 중복이 발생

```java
public class Tea {
    final void prepareRecipe(){
        System.out.println("물 끓이는 중");
        System.out.println("차 우려내는 중"); // 다름
        System.out.println("컵에 따르는 중");
        if(customerWantsCondiments()){
            System.out.println("레몬을 추가하는 중"); // 다름
        }
    }
    boolean customerWantsCondiments() {
        return true;
    }
}

public class Coffee {
    final void prepareRecipe(){
        System.out.println("물 끓이는 중");
        System.out.println("필터로 커피를 우려내는 중"); // 다름
        System.out.println("컵에 따르는 중");
        if(customerWantsCondiments()){
            System.out.println("설탕 추가하는 중"); // 다름
        }
    }
    boolean customerWantsCondiments() {
        return true;
    }
}
```

## 구현

### AbstractClass

- 동일 로직은 구현 (변경 방지를 위해 final)
- 그 외 변경되는 로직은 추상 메소드 선언 (서브 클래스에서 구현)

```java
public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    boolean customerWantsCondiments() {
        return true;
    }
}
```

### ConcreteClass1

- 구현

```java
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
```

### ConcreteClass2

- 구현

```java
public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("차를 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가하는 중");
    }
}
```