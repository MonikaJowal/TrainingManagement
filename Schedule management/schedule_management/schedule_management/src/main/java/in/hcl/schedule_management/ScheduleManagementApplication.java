package in.hcl.schedule_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ScheduleManagementApplication {

	public static void main(String[] args ) {
		SpringApplication.run(ScheduleManagementApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
	
}
	
}













