package cdpPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.testng.annotations.Test;

public class Geolocationchange {

	
	@Test
	public void setGeoToFrance() {
		
		ChromeDriver driver=new ChromeDriver();
		DevTools devtool= driver.getDevTools();
		devtool.createSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("latitude", 40);
		map.put("longitude", -3);
		map.put("accuracy", 1);
		
		devtool.send(Emulation.setGeolocationOverride(Optional.of(40),Optional.of(3), Optional.of(1)));
		
		//driver.executeCdpCommand("Emulation.setGeolocationOverride", map);
		driver.get("https://www.netflix.com");
		
	}
}
