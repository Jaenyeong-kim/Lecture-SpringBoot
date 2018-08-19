package examples.boot.firstweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController(){
        System.out.println("HelloController 생성자");
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "hello!";
    }
}
