package cdpPractice;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class Blockurls {

	@Test
	public void blockIImages() {
		WebDriver driver=new ChromeDriver();
		DevTools devtool =((ChromeDriver)driver).getDevTools();
		devtool.createSession();
		
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtool.send(Network.setBlockedURLs(ImmutableList.of("*jpg","*css")));
		driver.get("https://www.amazon.in");
	}
	
}
