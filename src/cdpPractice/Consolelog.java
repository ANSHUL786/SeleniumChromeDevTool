package cdpPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;

public class Consolelog {

	@Test
	public void basicAuth() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		driver.get("https://qa.flowace.in");
		driver.findElement(By.name("email")).sendKeys("anshul@flowace.in");
		driver.findElement(By.name("password")).sendKeys("anshul@123");
		driver.findElement(By.className("sign-in")).click();
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> ls = logs.getAll();
		for (LogEntry log : ls) {
			System.out.println(log.getMessage());
		}

	}
}
