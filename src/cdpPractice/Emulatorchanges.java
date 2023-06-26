package cdpPractice;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;



public class Emulatorchanges {

	
	@Test
	public void switchToMobile() {
		ChromeDriver driver=new ChromeDriver();
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		//devtool.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("width", 600);
		map.put("height", 1000);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
		driver.get("https://flowace.ai");	
	}
}


