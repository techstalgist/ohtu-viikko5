
package ohtu;

import java.util.List;

public abstract class GameStatus {
    
    String name;
    List<Integer> scores;
    
    public GameStatus(String name, List<Integer> scores) {
        this.name = name;
        this.scores = scores;
    }
    
    int getLeadingPlayerId() {
        if (scores.get(0) > scores.get(1)) { return 1; }
        if (scores.get(1) > scores.get(0)) { return 2; }
        return 0;
    }
    
    String getPlayerScoreAsString(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
    
    abstract String getAsString();
}
