
package ohtu;

import java.util.List;

public class Advantage extends GameStatus {

    public Advantage(List<Integer> scores) {
        super("Advantage", scores);
    }

    @Override
    String getAsString() {
        return "Advantage player" + this.getLeadingPlayerId();
    }
}
