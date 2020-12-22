package br.com.apdata.cliente;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingTasksApDataApplication.class);
	}
}
