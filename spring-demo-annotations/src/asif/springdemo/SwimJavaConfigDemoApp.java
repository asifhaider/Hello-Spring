package asif.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring java config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SportConfig.class
        );

        // get the bean from spring container
//        Coach theCoach = context.getBean("swimCoach", Coach.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on driver bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method to get helper service
        System.out.println(theCoach.getDailyFortune());

        // new methods for value property injection check
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        // close context
        context.close();
    }
}
