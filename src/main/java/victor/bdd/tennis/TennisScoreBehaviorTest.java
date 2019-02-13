package victor.bdd.tennis;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:tennis-score.feature"}, glue={"victor.bdd.tennis"})
public class TennisScoreBehaviorTest {

}
