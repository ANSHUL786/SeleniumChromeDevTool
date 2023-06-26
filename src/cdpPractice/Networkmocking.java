package cdpPractice;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.fetch.Fetch;
import org.openqa.selenium.devtools.v113.fetch.model.RequestId;
import org.openqa.selenium.devtools.v113.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v113.network.model.ErrorReason;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.testng.annotations.Test;

public class Networkmocking {

	@Test
	public void networkMock() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		DevTools devtool = ((ChromeDriver) driver).getDevTools();

		devtool.createSession();
		
		devtool.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devtool.addListener(Fetch.requestPaused(), request ->{
			
			Request req=request.getRequest();
			
			if(req.getUrl().contains("shetty")) {
				String mockedUrl=req.getUrl().replaceAll("=shetty", "=badGuy");
				
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(req.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			else {
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			
		});
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
		Thread.sleep(10000);
		driver.quit();
	}
	
	
	@Test
	public void netWorkRequestFailed() {
		WebDriver driver = new ChromeDriver();

		DevTools devtool = ((ChromeDriver) driver).getDevTools();

		devtool.createSession();
		Optional<List<RequestPattern>> pattern= Optional.of(Arrays.asList(new RequestPattern(Optional.of("*getPro*"),Optional.empty(),Optional.empty()) ));
		devtool.send(Fetch.enable(pattern,Optional.empty()));
		
		devtool.addListener(Fetch.requestPaused(), request ->{
			System.out.println(request.getRequest().getUrl());
			
			devtool.send(Fetch.failRequest(request.getRequestId(), ErrorReason.CONNECTIONREFUSED));
			
		});
		
		driver.get("https://qa.flowace.in");
		driver.findElement(By.name("email")).sendKeys("anshul@flowace.in");
		driver.findElement(By.name("password")).sendKeys("anshul@123");
		driver.findElement(By.className("sign-in")).click();
	}
	
	
	
}
