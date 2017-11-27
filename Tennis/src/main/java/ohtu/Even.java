
package ohtu;

import java.util.List;

public class Even extends GameStatus {
    
    public Even(List<Integer> scores) {
        super("Even", scores);
    }

    @Override
    String getAsString() {
        int score = scores.get(0);
        String scoreAsString = this.getPlayerScoreAsString(score);
        if (score < TennisGame.MINIMUM_WINNING_SCORE) {
            return scoreAsString + "-All";
        } else {
            return scoreAsString;
        }
    }
}
