package br.com.apdata.cliente.com.apdata.cliente.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RelogioVirtual {
	
	private static final String PORTAL_DE_RH = "https://cliente.apdata.com.br/dicon/";
	private static final String USER = "*********";
	private static final String PASSWORD = "*********";
	private static final Logger log = LoggerFactory.getLogger(RelogioVirtual.class);

	private static WebDriver driver;
	
	public void callMarcacao() {
		
		this.initDrivers();
		
		log.info("Call marcação");
		
		log.info("Preenche o usuário");
		driver.findElement(By.id("ext-131")).sendKeys(USER);
		
		log.info("Preenche a senha");
		driver.findElement(By.id("ext-133")).sendKeys(PASSWORD);
		
		log.info("Clica no botão Marcação");
		driver.findElement(By.id("ext-135")).click();
		
	}
	
	public void initDrivers() {

		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);

		System.out.println("Setting webdriver for Google Chrome, find file chromedriver.exe in directory" + currentDir);
		System.setProperty("webdriver.chrome.driver", currentDir.concat("\\chromedriver.exe"));

		driver = new ChromeDriver();	
		
		log.info("Go to home page");
		driver.get(PORTAL_DE_RH);
		
		//Accept Cookie LOL
		moveToLastWindowsHandle();
		
		log.info("Clica no botão confirmar preferências");
		driver.findElement(By.id("button-1020")).click();
		

	}
	
	public static void moveToLastWindowsHandle() {
		driver.switchTo().window(
				driver.getWindowHandles().stream().skip(driver.getWindowHandles().size() - 1).findFirst().get());
	}
}
