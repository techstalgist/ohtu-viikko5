
package ohtu;

public class Player {

    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public void incrementScore() {
        score++;
    } 
}
