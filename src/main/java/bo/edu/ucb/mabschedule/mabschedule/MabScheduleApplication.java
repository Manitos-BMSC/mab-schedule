package bo.edu.ucb.mabschedule.mabschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MabScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MabScheduleApplication.class, args);
	}

}
