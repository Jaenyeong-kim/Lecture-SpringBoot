package examples.boot.firstweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 컴포넌트 스캔이 내부에 존재
public class FirstwebApplication {
//    @Bean
//    public HelloController helloController() {
//        return new HelloController(helloService());
//    }
//
//    @Bean
//    public HelloController helloController2() {
//        return new HelloController(helloService());
//    }
//
//    @Bean
//    public HelloService helloService() {
//        System.out.println(getClass().getName());
//        return new HelloService();
//    }

    public static void main(String[] args) {
        SpringApplication.run(FirstwebApplication.class, args);
    }
}
