package sg.edu.nus.iss.vttp_day11;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class VttpDay11Application {
	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}

	public static void main(String[] args) {
		// SpringApplication.run(VttpDay11Application.class, args);
		SpringApplication app = new SpringApplication(VttpDay11Application.class);

		String port = "8080";
		ApplicationArguments argsOptions = new DefaultApplicationArguments(args);
		if (argsOptions.containsOption("port")) {
			port = argsOptions.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.println("Application started on port " + port);

		String dirFile = "";
		if (argsOptions.containsOption("file")) {
			dirFile = argsOptions.getOptionValues("file").get(0);
			System.out.println("Directory file at " + dirFile);
		}



		app.run(args);
	}

}
