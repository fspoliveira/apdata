package br.com.apdata.cliente.com.apdata.cliente.automation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.apdata.cliente.calendar.AppDataCalendar;
import br.com.apdata.cliente.com.apdata.cliente.system.OSValidator;

@Service
public class RelogioVirtual {

	@Value("${apdata.url}")
	private String PORTAL_DE_RH;

	@Value("${apdata.user}")
	private String USER;

	@Value("${apdata.password}")
	private String PASSWORD;
	private static final Logger log = LoggerFactory.getLogger(RelogioVirtual.class);

	private static WebDriver driver;

	public void callMarcacao() throws InterruptedException {

		log.info("ZzZzZzZzZZ por " + AppDataCalendar.returnDayOfWeek()
				+ " minutos, pro apontamento nao ficar igual todos os dias");
		
		Thread.sleep(TimeUnit.MINUTES.toMillis(AppDataCalendar.returnDayOfWeek()));

		this.setup();
		this.openPageAndConfirmCookies();

		log.info("Call marcacao");

		log.info("Preenche o usuario");
		driver.findElement(By.id("ext-133")).sendKeys(USER);

		log.info("Preenche a senha");
		driver.findElement(By.id("ext-135")).sendKeys(PASSWORD);

		log.info("Clica no botão Marcacao");
		driver.findElement(By.id("ext-137")).click();
		
		log.info("Marcacao feita com sucesso");

	}

	private void openPageAndConfirmCookies() {

		log.info("Go to home page");
		driver.get(PORTAL_DE_RH);

		// Accept Cookie LOL
		moveToLastWindowsHandle();
		log.info("Clica no botão confirmar preferências");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1020")));

		driver.findElement(By.id("button-1020")).click();

	}

	private void setup() {

		String currentDir = System.getProperty("user.dir");
		log.info("Current dir using System:" + currentDir);

		log.info("Setting webdriver for Google Chrome, find file chromedriver.exe in directory" + currentDir);

		currentDir = OSValidator.isWindows() ? currentDir.concat(File.separator + "chromedriver.exe")
				: currentDir.concat(File.separator + "chromedriver");

		log.info("Current Dir" + currentDir);

		System.setProperty("webdriver.chrome.driver", currentDir);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
		chromeOptions.setHeadless(true);

		driver = new ChromeDriver(chromeOptions);

	}

	public static void moveToLastWindowsHandle() {
		driver.switchTo().window(
				driver.getWindowHandles().stream().skip(driver.getWindowHandles().size() - 1).findFirst().get());
	}
}
