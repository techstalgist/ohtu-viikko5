package ohtu;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TennisGame {
    
    private HashMap<String, Player> players;
    public static int MINIMUM_WINNING_SCORE = 4;
    public static int MINIMUM_WINNING_SCORE_DIFFERENCE = 2;
    
    public TennisGame(String player1Name, String player2Name) {
        this.players = new HashMap();
        this.players.put(player1Name, new Player(player1Name));
        this.players.put(player2Name, new Player(player2Name));
    }

    public void wonPoint(String playerName) {
        players.get(playerName).incrementScore();
    }
    
    public GameStatus getStatus() {
        List<Integer> scores = players.values().stream().map(p -> p.getScore()).collect(Collectors.toList());
        GameStatus status;
        int first = scores.get(0);
        int second = scores.get(1);
        if (first == second) {
            status = new Even(scores);
        } else if (first >= MINIMUM_WINNING_SCORE || second >= MINIMUM_WINNING_SCORE) {
            if (Math.abs(first-second) >= MINIMUM_WINNING_SCORE_DIFFERENCE) {
                status = new Win(scores);
            } else {
                status = new Advantage(scores);
            }
        } else {
            status = new GenericStatus(scores);
        }
        return status;
    }

    public String getScore() {
        GameStatus status = getStatus();
        return status.getAsString();
    }
}