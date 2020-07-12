package booking.website.stepdefinitions;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features"},
		monochrome=true,
		snippets=SnippetType.UNDERSCORE,
		tags = "@test",
		glue= {"stepdefinition path"},
		plugin= {}
		)
public class RunCukes {

	@BeforeClass
	public static void setupProperties() {
		System.setProperty("classname", "RunCukes");
	}
}
