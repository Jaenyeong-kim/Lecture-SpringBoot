package examples.boot.web1;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    public HelloController(){
        System.out.println("HelloController!");
    }

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "hello";
    }

    //   /hello2?name=kim&age=5
    @GetMapping(path = "/hello2")
    public String sayHello2(@RequestParam(name = "name", required = true)String name,
                            @RequestParam(name = "age", required = false, defaultValue = "0")int age){
        return "hello " + name + " , " + age;
    }

    @GetMapping(path = "/hello3")
    public String sayHello3(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "hello " + name + " , " + age;
    }

    @GetMapping(path = "/hello4")
    public String sayHello4(@ModelAttribute HelloDTO helloDTO){
        return "hello " + helloDTO.getName() + " , " + helloDTO.getAge();
    }

    @PostMapping(path = "/hello5")
    public String sayHello5(){
        return "hello";
    }

    @PostMapping(path = "/hello6")
    public String sayHello6(@RequestParam(name = "name", required = true)String name,
                            @RequestParam(name = "age", required = false, defaultValue = "0")int age){
        return "hello " + name + " , " + age;
    }

    @PostMapping(path = "/hello7")
    public String sayHello7(@RequestBody HelloDTO helloDTO){
        return "hello " + helloDTO.getName() + " , " + helloDTO.getAge();
    }

    @GetMapping(path = "/hello8")
    public HelloDTO sayHello8(){
        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setName("lee");
        helloDTO.setAge(40);
        return helloDTO;
    }
}


















