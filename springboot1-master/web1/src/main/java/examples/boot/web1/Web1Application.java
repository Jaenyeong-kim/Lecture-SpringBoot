package examples.boot.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class Web1Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Web1Application.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}
}
