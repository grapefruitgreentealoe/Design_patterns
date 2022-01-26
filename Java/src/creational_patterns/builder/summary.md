# 빌더 패턴

- 복잡한 객체를 생성하는 방법을 캡슐화하여 객체 생성을 유연하게 해주는 패턴
- 멤버 변수가 많을 경우 유용함
  - 객체 생성 시에 필요한 인자의 경우의 수가 많을 경우 (경우의 수 만큼 생성자를 만들어줘야 됨)
  - 생성자 인자가 많아 순서나 타입이 헷갈릴 수 있음

# 다이어그램

<div align="center">

![builder](https://user-images.githubusercontent.com/50051656/149618979-84e3ce78-4bc6-474e-8fb6-dc04a4e2cd22.png)

</div>

- Builder : 인스턴스 생성을 위한 인터페이스
- ConcreteBuilder : Builder 인터페이스를 구현
- Director : 자주 사용되는 조합일 경우 미리 생성
- Product : 상품의 상태와 기능
- Client : 만들어지는 제품 사용

## 구현

### Builder

- 여행 계획을 만들 때 필요한 요소를 인터페이스로 구현

```java
public interface TourPlanBuilder {

    TourPlanBuilder title(String title);
    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder startDate(LocalDate startDate);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);
    TourPlan getPlan();

}
```

### ConcreteBuilder

- Builder 인터페이스를 구현
- 각 함수는 반환형으로 자기 자신을 반환
- addPlan()을 시작으로 getPlan()을 끝으로 제품을 생성함

```java
public class DefaultTourBuilder implements TourPlanBuilder{

    private String title;
    private int nights;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans;

    @Override
    public TourPlanBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.nights = nights;
        this.days = days;
        return this;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
        if (this.plans == null) {
            this.plans = new ArrayList<>();
        }
        this.plans.add(new DetailPlan(day, plan));
        return this;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title, nights, days, startDate, whereToStay, plans);
    }
}
```

## Product

- 제품 상태와 기능 정의

```java
package creational_patterns.builder.after;

import java.time.LocalDate;
import java.util.List;

public class TourPlan {

    private String title;
    private int nights;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans;

    public TourPlan(String title, int nights, int days, LocalDate startDate, String whereToStay, List<DetailPlan> plans) {
        this.title = title;
        this.nights = nights;
        this.days = days;
        this.startDate = startDate;
        this.whereToStay = whereToStay;
        this.plans = plans;
    }
    
    // get, set

    public void addPlan(int day, String plan) {
        this.plans.add(new DetailPlan(day, plan));
    }

}
```

## Director

- 자주 사용되는 여행 패키지를 미리 생성

```java
public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan japanTrip() {
        return tourPlanBuilder.title("일본 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2016, 7, 20))
                .whereToStay("콘도")
                .addPlan(0, "체크인 & 짐풀기")
                .addPlan(0, "텐진 캐널시티")
                .addPlan(1, "다자이후 신사")
                .addPlan(1, "후코오카 타워 & 모모치해변")
                .getPlan();
    }

    public TourPlan taiwanTrip() {
        return tourPlanBuilder.title("대만 여행")
                .startDate(LocalDate.of(2015, 7, 17))
                .getPlan();
    }

}
```

### Client

- 직접 일정을 조율할 수 있고 director를 통해서 만들어진 여행 패키지를 볼 수 있음

```java
public class App {
    public static void main(String[] args) {
        DefaultTourBuilder builder = new DefaultTourBuilder();

        TourPlan shortTrip = builder.title("대만 여행")
                .startDate(LocalDate.of(2015, 7, 17))
                .getPlan();

        TourPlan plan = builder.title("일본 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2016, 7, 20))
                .whereToStay("콘도")
                .addPlan(0, "체크인 & 짐풀기")
                .addPlan(0, "텐진 캐널시티")
                .addPlan(1, "다자이후 신사")
                .addPlan(1, "후코오카 타워 & 모모치해변")
                .getPlan();

        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan japanPlan = director.japanTrip();
        TourPlan taiwanPlan = director.taiwanTrip();
    }
}
```