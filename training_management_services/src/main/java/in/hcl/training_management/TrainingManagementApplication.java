package in.hcl.training_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrainingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingManagementApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate reattemplate() {
		return new RestTemplate();
	}
	
	
	
	
}
