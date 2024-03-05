package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//featurefiles"},
		glue="StepDef",
		plugin= {"pretty", "html:Reports/CUCUMBER_reoprts/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",		
		},
		dryRun=false,
		monochrome=true,
		publish=true	
		)
public class testrunall {
		
}
