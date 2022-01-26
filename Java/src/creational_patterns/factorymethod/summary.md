# 팩토리 메소드 패턴

- 객체를 만드는 공장
- 객체의 생성을 서브 클래스가 수행하도록 함
- 어떤 상황에서 조건에 따라 객체를 다르게 생성할 수 있도록 함

## 다이어그램

<div align="center">

![factorymethod](https://user-images.githubusercontent.com/50051656/149655409-606f9036-e9a4-47ec-b6c9-0e9583206111.png)

</div>

- Creator : 공통된 처리 작업을 구현하고 변경이 필요한 부분은 추상 메소드로 구현하여 따로 구현될 수 있도록 함
- ConcreteCreator : 하위 클래스에서 변경된 부분을 구체적으로 구현할 수 있도록 함
- Product: 공장에서 만드는 제품의 형태이고 다양한 형태를 가질 수 있도록 인터페이스로 구현
- ConcreteProduct : 구체적인 제품의 형태

## 문제점

- 배를 만드는 공장이 있다고 가정
- 새로운 색깔, 로고가 있어야 하는 배가 들어올 경우 기존 소스 코드를 변경해야 함 (OCP 위배)
- 다른 상태와 기능을 가지는 배가 생겼을 경우 코드가 난잡해짐

```java
package creational_patterns.factorymethod.before;

public class ShipFactory {

    public static Ship orderShip(String name, String email) {
        Ship ship = new Ship();
        ship.setName(name);

        if (name.equalsIgnoreCase("whiteship")) {
            ship.setLogo("white");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setLogo("black");
        }

        if (name.equalsIgnoreCase("whiteship")) {
            ship.setColor("white");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setColor("black");
        }
        
        return ship;
    }
}
```

## 구현

### Creator

- 만들어 낼 객체의 공정을 만듦
- 제작 과정에 중복되는 부분들은 함수를 구현함
- java8 부터는 default 메소드로 함수 구현을 할 수 있기에 추상 클래스를 사용하지 않아도 됨
- java9 부터는 private 메소드로 함수 구현이 가능하여 추상 클래스 사용하지 않아도 됨
- 변경이 필요한 부분은 추상 메소드로 구현

```java
public interface ShipFactory {
    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    }

    private static void prepareFor(String name) { System.out.println(name + " 만들 준비 중"); }

    private static void sendEmailTo(String email, Ship ship) { System.out.println(ship.getName() + " 다 만들었습니다."); }

}
```

### ConcreteCreator

- 본 공정을 구현하여 검정, 흰색의 서로 다른 두 공정이 필요한 로직을 구현

```java
public class BlackShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
```

```java
public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
```

### Product

- 만들어야 할 제품 클래스

```java
public class Ship {

    private String name;
    private String color;
    private String logo;

    // get, set
}

```

### ConcreteProduct

- 각 배에 맞는 구체적인 제품 클래스

```java
public class BlackShip extends Ship {

    public BlackShip() {
        setName("BlackShip");
        setLogo("black");
        setColor("black");
    }
}
```

```java
public class WhiteShip extends Ship {

    public WhiteShip() {
        setName("WhiteShip");
        setLogo("white");
        setColor("white");
    }
}
```