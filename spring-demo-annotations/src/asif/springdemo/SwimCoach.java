package asif.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${asif.email}") // value property injection from custom sport.properties file
    private String email;

    @Value("${asif.team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public SwimCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
