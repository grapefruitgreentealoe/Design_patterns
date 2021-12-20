package creational_patterns.builder.before;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        TourPlan shortTrip = new TourPlan();
        shortTrip.setTitle("대만 여행");
        shortTrip.setStartDate(LocalDate.of(2015, 7, 17));

        TourPlan tourPlan = new TourPlan();
        tourPlan.setTitle("일본 여행");
        tourPlan.setNights(2);
        tourPlan.setDays(3);
        tourPlan.setStartDate(LocalDate.of(2016, 7, 20));
        tourPlan.setWhereToStay("콘도");
        tourPlan.addPlan(0, "체크인 & 짐풀기");
        tourPlan.addPlan(0, "텐진 캐널시티");
        tourPlan.addPlan(1, "다자이후 신사");
        tourPlan.addPlan(1, "후쿠오카 타워 & 모모치해변");
        tourPlan.addPlan(2, "유후인 긴린코 호수");
        tourPlan.addPlan(2, "백화점 쇼핑");
        tourPlan.addPlan(2, "체크아웃");
    }
}
