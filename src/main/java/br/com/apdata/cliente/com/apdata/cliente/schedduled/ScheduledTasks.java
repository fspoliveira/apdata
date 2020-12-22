package br.com.apdata.cliente.com.apdata.cliente.schedduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.apdata.cliente.com.apdata.cliente.automation.RelogioVirtual;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private RelogioVirtual relogioVirtual;

	//Entrada as 09:30 am
	@Scheduled(cron = "00 30 09 * * MON-FRI")
	public void checkIn() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		relogioVirtual.callMarcacao();	
		
	}
	
	//Saída as 18:30
	@Scheduled(cron = "00 30 18 * * MON-FRI")
	public void checkOut() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		relogioVirtual.callMarcacao();	
	}
}
