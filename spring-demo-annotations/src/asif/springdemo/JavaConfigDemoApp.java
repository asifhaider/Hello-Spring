package asif.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring java config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SportConfig.class
        );

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on driver bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method to get helper service
        System.out.println(theCoach.getDailyFortune());

        // close context
        context.close();
    }
}
