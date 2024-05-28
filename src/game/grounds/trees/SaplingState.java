package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.items.consumables.SmallFruit;

import java.util.Random;

public class SaplingState implements TreeState {
    private static final int GROWTH_PERIOD = 6;
    private int tickCount = 0;
    private static final double PLANT_CHANCE = 0.3;

    @Override
    public void tick(Inheritree context, Location location) {
        tickCount++;
        if (tickCount >= GROWTH_PERIOD) {
            context.setState(new YoungInheritreeState());
        } else {
            if (Math.random() <= PLANT_CHANCE) {
                dropFruit(location, new SmallFruit());
            }
        }
    }

    @Override
    public char getDisplayChar() {
        return 't';
    }

    private void dropFruit(Location location, SmallFruit fruit) {
        Random rand = new Random();
        Location destination = location.getExits().get(rand.nextInt(location.getExits().size())).getDestination();
        destination.addItem(fruit);
    }
}