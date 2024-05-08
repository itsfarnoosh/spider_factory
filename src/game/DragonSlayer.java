package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.AttackAction;

public class DragonSlayer extends WeaponItem {
    public DragonSlayer(){
        super("Dragon Slayer!", 'x', 50, "Clank", 75);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(location);
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }
}

