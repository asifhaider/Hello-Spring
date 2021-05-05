package asif.myquickstart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // one kind of @Component
public class HelloController {

    @RequestMapping("/hello") // default method is GET
    public String sayHello(){
        return "Hello Spring Boot";
    }
}
