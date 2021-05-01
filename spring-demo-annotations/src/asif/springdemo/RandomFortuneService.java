package asif.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    // trying out random message to display
    private String[] data = {
        "Hello Spring",
        "My name is Asif",
        "Pacchis Din main Paisa Double"
    };

    // creating a random number generator
    private Random myRandom = new Random();


    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }
}
