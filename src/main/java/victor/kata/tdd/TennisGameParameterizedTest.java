package victor.kata.tdd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TennisGameParameterizedTest {

    private final int player1Score;
    private final int player2Score;
    private final String expectedScoreString;

    public TennisGameParameterizedTest(int player1Score, int player2Score, String expectedScoreString) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScoreString = expectedScoreString;
    }

    @Parameters(name = "Scor({0},{1}) = {2}")
    static public Object[][] dateDeBagatInConstructor() {
        return new Object[][]{
                {0, 0, "Love-Love"},
                {0, 1, "Love-Fifteen"},
                {1, 0, "Fifteen-Love"},
                {0, 2, "Love-Thirty"},
                {3, 0, "Forty-Love"},
                {3, 3, "Deuce"},
                {4, 3, "Advantage player 1"},
                {3, 4, "Advantage player 2"}
        };
    }

    @Test
    public void testulUnicDeAplicatPeFiecareCombinatieDedate() {
        assertEquals(expectedScoreString, getLabel(player1Score, player2Score));
    }


    private String getLabel(int i1, int i2) {
        TennisGame game= new TennisGame();
        setScore(game, i1, i2);
        return game.score();
    }

    private void setScore(TennisGame game, int player1Score, int player2Score) {
        scorePoints(game, 1, player1Score);
        scorePoints(game, 2, player2Score);
    }

    private void scorePoints(TennisGame game, int playerNo, int points) {
        for(int i = 0 ; i < points ; i++) {
            game.scorePoint(playerNo);
        }
    }

}
