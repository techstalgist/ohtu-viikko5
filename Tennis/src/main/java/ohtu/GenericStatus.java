
package ohtu;

import java.util.List;

public class GenericStatus extends GameStatus {

    public GenericStatus(List<Integer> scores) {
        super("Generic status", scores);
    }

    @Override
    String getAsString() {
        return this.getPlayerScoreAsString(scores.get(0)) + "-" + this.getPlayerScoreAsString(scores.get(1));
    }
}
