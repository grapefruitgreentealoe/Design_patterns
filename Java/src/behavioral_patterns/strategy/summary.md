# 전략 패턴(Strategy Pattern)

- 실행 중에 알고리즘을 선택할 수 있게 하는 행위 소프트웨어 디자인 패턴이다.
- 동일 계열의 알고리즘 군을 정의하고, 각 알고리즘을 캡슐화한다.
- 알고리즘을 사용하는 클라이언트와 상관없이 독립적으로 알고리즘을 다양하게 변경할 수 있어야 한다.
- 특정 기능이 추가될 때, 전략 객체를 생성 후 주입하는 방식으로 유연하게 기능을 확장할 수 있다.
- ex) Comparator

## 문제점

### 상속(Inheritance)

<div align="center">

![strategypatttern drawio](https://user-images.githubusercontent.com/50051656/151175581-00e1b7a1-59ef-4046-834a-7f6911013d2d.png)

</div>

- 오리라는 슈퍼 클래스를 만들고 오리 울음소리(quack), 수영하기(swim) 등 오리가 할 수 있는 공통 메소드를 구현한다.
- 오리의 생김새(display)는 추상 메소드로 만들어 각 오리의 특색을 나타낸다.
- 만약에 오리가 날 수 있게 된다면(fly) 추가 하되 RubberDuck과 같이 날 수 없는 오리가 있을 경우 따로 오버로딩을 해주어 재 정의해야한다.
- DecoyDuck이라는 새로 오리가 생기게 되었을 때 이 오리는 날거나 울음소리를 낼 수 없었기에 둘 다 오버로딩을 해주어야 한다.
- 서브 클래스에 코드가 중복되고 행동을 추가하기가 꺼려지고 실행 시에 특징을 바꾸기 어렵다.
- 유지 보수에 어려움을 겪는다.

### 인터페이스(Interface)

<div align="center">

![strategypattern2 drawio](https://user-images.githubusercontent.com/50051656/151175597-11ddaf05-186f-4cac-a162-da6ad0ce6ae8.png)

</div>

- 슈퍼 클래스에 공통된 기능을 담고 나머지 변경이 가능한 기능들을 인터페이스로 분리한다.
- 인터페이스로 분리해 오리 각각은 해당하는 기능을 가져다 구현할 수 있다.
- 행위 코드의 재사용이 불가능해지기 때문에 코드 중복이 발생한다.
- 만약 fly, quack에 대한 요구 사항이 변할 경우에 이걸 구현한 서브 클래스는 모두 변해야 한다.
- 이 또한 유지 보수에 어려움을 겪는다.

## 구현

<div align="center">

![strategypattern3 drawio](https://user-images.githubusercontent.com/50051656/151175609-1277a7fc-0296-492a-9615-b20b67e4a658.png)

</div>

- 행위들을 interface로 정의하고, 이 행위를 구현하는 구체적인 클래스를 정의하였다.
- 더는 행위가 추가되어도 모든 서브 클래스를 확인할 필요가 없어졌다.
- 또한 중복 코드 또한 발생하지 않고 오리가 할 수 있는 행위가 유연해졌다.