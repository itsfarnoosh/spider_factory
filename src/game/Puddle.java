package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Puddle extends Ground {
    public Puddle() {
        super('~');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        if (location.containsAnActor() && (location.getActor()).equals(actor)) {
            return new ActionList(new DrinkAction());
        }
        return new ActionList();
    }
}
