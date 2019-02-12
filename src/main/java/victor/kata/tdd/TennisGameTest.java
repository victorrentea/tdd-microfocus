package victor.kata.tdd;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {

    @Test
    public void start() {
        Assert.assertEquals("Love-Love", getLabel(0, 0));
    }

    @Test
    public void loveFifteen() {
        Assert.assertEquals("Love-Fifteen", getLabel(0, 1));
    }

    @Test
    public void fifteenLove() {
        Assert.assertEquals("Fifteen-Love", getLabel(1, 0));
    }

    @Test
    public void loveThirty() {
        Assert.assertEquals("Love-Thirty", getLabel(0, 2));
    }

    @Test
    public void fortyLove() {
        Assert.assertEquals("Forty-Love", getLabel(3, 0));
    }

    @Test
    public void deuce() {
        Assert.assertEquals("Deuce", getLabel(3, 3));
    }

    @Test
    public void advantage1 () {
        Assert.assertEquals("Advantage player 1", getLabel(4, 3));
    }

    @Test
    public void advantage2 () {
        Assert.assertEquals("Advantage player 2", getLabel(4, 5));
    }

    @Test
    public void game1 () {
        Assert.assertEquals("Game Won Player 1", getLabel(4, 0));
    }

    @Test
    public void game2 () {
        Assert.assertEquals("Game Won Player 2", getLabel(5, 7));
    }

    @Test
    public void game1bis () {
        Assert.assertEquals("Game Won Player 1", getLabel(7, 5));
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
