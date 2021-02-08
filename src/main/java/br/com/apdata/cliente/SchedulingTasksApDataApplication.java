package br.com.apdata.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.apdata.cliente.com.apdata.cliente.automation.RelogioVirtual;

@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApDataApplication {

	/*
	 * @Autowired private RelogioVirtual relogioVirtual;
	 */

	public static void main(String[] args) {
		SpringApplication.run(SchedulingTasksApDataApplication.class);
	}

	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> { relogioVirtual.callMarcacao(); }; }
	 */
}
