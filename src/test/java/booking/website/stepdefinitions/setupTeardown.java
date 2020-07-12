package booking.website.stepdefinitions;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import booking.website.utilities.ConfigurationProperties;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class setupTeardown {

	private static Logger log= LoggerFactory.getLogger(setupTeardown.class);
	
	@Before
	public static void setUp() {
		String chromeDriver = ConfigurationProperties.getPropertyValueByKey("IsChromeBrowserActive");
		if(chromeDriver.equals("true")) {
			Map<String,Object> preferences = new Hashtable<String,Object>();
			preferences.put("profile.default_content_settings.popups",0);
			preferences.put("plugins.plugins_disabled",new String[] {
					"Adobe Flash Player","Chrome PDF Viewer"});
			ChromeOptions options = new ChromeOptions();
			options.addArguments("");
			System.setProperty(ConfigurationProperties.getPropertyValueByKey("chromeDriverSystemProperty"),
					ConfigurationProperties.getPropertyValueByKey("chromeDriver"));
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		}
	}
}
