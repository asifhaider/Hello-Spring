package asif.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // retrieve bean from container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if they are pointing to same reference
        boolean result = theCoach == alphaCoach;

        System.out.println("Pointing to same object: " + result);
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);
    }
}
