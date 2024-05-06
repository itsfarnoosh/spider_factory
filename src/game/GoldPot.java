package game;

import edu.monash.fit2099.engine.actors.Actor;

public class GoldPot extends Consumable {

    public GoldPot() {
        super("Pot of Gold", '$', true, 10);
    }
    @Override
    public String consume(Actor actor) {
        actor.addBalance(points);
        return "Wallet amount is increased by " + this.getPoints() + " points!";
    }
}
