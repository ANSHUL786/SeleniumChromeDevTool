package cdpPractice;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;
import org.testng.annotations.Test;

public class Networkemulatorspeed {

	@Test
	public void emulateLatency() {
		WebDriver driver=new ChromeDriver();
		DevTools devtool =((ChromeDriver)driver).getDevTools();
		devtool.createSession();
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtool.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		//Network fail
		devtool.addListener(Network.loadingFailed(), loadingfailed->{
			String a=loadingfailed.getErrorText();
			System.out.println(a);
		});
		
		driver.get("https://www.amazon.in");
		
		
	}
	
}
