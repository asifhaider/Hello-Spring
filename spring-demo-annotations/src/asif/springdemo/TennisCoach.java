package asif.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// adding component annotation
// Spring will now automatically register this bean for me in the application context
// myCoach is the bean id if specified:  @Component(myCoach)
// if nothing specified, default bean id 'tennisCoach' is used by spring automatically

@Component
// @Scope("prototype") // will allow TennisCoach to create more than one instances, default is singleton
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")   // qualifier specifies which interface implementation to choose over all component options
    private FortuneService fortuneService;

    // spring searches all components for me to find out which one implements fortune service
    // constructor injection

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    public TennisCoach() {
        System.out.println("Inside Default Constructor!");
    }

    // setter injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//        System.out.println("Inside Setter Function!");
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // method injection
//    @Autowired
//    public void doSomeCrazyStuffs(FortuneService fortuneService){
//        System.out.println("Inside any method!");
//    }

}
