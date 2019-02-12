package victor.kata.tdd;

public class TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;
    private static final String[] VALUES = {"Love","Fifteen","Thirty","Forty"};

    public String score() {

        if(player1Score >=3 && player2Score >= 3) {
            if (player1Score == player2Score) {
                return "Deuce";
            }
            if (player1Score - player2Score == 1) {
                return "Advantage player 1";
            }
            if (player2Score - player1Score == 1) {
                return "Advantage player 2";
            }
        }

        if(player1Score - player2Score >= 2 && player1Score >=4) {
            return "Game Won Player 1";
        }
        if(player2Score - player1Score >= 2 && player2Score >=4) {
            return "Game Won Player 2";
        }

        return VALUES[player1Score]
                + "-"
                + VALUES[player2Score];
    }

    public void scorePoint(int playerNo) {
        if(playerNo==2) {
            player2Score++;
        }
        else{
            player1Score++;
        }
    }
}
