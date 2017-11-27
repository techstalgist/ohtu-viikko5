
package ohtu;

import java.util.List;

public class Win extends GameStatus {

    public Win(List<Integer> scores) {
        super("Win", scores);
    }

    @Override
    String getAsString() {
        return "Win for player" + this.getLeadingPlayerId();
    }
}
