package examples.boot.jpaexam.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {
    @GetMapping("/api/test")
    public String test(){
        if(1==1)
            throw new RuntimeException("1==1 !!!");
        return "test";
    }
}