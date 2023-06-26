package cdpPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Response;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.testng.annotations.Test;

public class Networkactivitytrack {

	
	@Test
	public void setGeoToFrance() {
		
		ChromeDriver driver=new ChromeDriver();
		DevTools devtool= driver.getDevTools();
		devtool.createSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtool.addListener(Network.requestWillBeSent(),request->{
			Request req=request.getRequest();
			System.out.println(req.getUrl()+">>>>>>>>>>>>>>>>>>>>>>>>");
			
		});
		
		devtool.addListener(Network.responseReceived(),response ->{
			Response res=response.getResponse();
			System.out.println(res.getUrl() + "======>>" +res.getStatus());
		});
		
		
		driver.get("https://www.netflix.com/");
		
	}
}
