package cdpPractice;

import org.openqa.selenium.chrome.ChromeDriver;

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

public class Basicauthwindow {

	@Test
	public void basicAuth() {
		
		WebDriver driver=new ChromeDriver();
		Predicate<URI> uripre = uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uripre,UsernameAndPassword.of("foo", "bar"));
		
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
	}
}
