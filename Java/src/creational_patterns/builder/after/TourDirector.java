package creational_patterns.builder.after;

import java.time.LocalDate;

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
