package victor.bdd.tennis;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import victor.kata.tdd.TennisGame;

public class TennisScoreBehaviorSteps {
	private TennisGame game;
	
	@Given("^An empty game$")
	public void an_empty_game() throws Throwable {
		game = new TennisGame();
	}

	@Then("^The score is \"([^\"]*)\"$")
	public void the_score_is(String expectedString) throws Throwable {
	   assertEquals(expectedString, game.score()); 
	}
	
	@When("^Player(\\d+) scores (\\d+) point$")
	public void player_scores_point(int playerNo, int points) throws Throwable {
		for (int i = 0; i < points; i++) {
			game.scorePoint(playerNo);
		}
	}


}
