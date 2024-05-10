package game.items.consumables;

import edu.monash.fit2099.engine.actors.Actor;

public class GoldPot extends Consumable {
    private final int INCREASE_AMOUNT = 10;

    /**
     * Constructor.
     *
     */
    public GoldPot() {
        super("Pot of Gold", '$', true);
    }

    /**
     * Add the amount of gold to the actor's balance / wallet
     *
     * @param actor the Actor.
     */
    @Override
    public String consume(Actor actor) {
        actor.addBalance(INCREASE_AMOUNT);
        return "Wallet amount is increased by " + INCREASE_AMOUNT + " points!";
    }
}
