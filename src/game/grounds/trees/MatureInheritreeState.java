package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.items.consumables.LargeFruit;

import java.util.Random;

public class MatureInheritreeState implements TreeState {
    private static final double PLANT_CHANCE = 0.2;

    @Override
    public void tick(Inheritree context, Location location) {
        if (Math.random() <= PLANT_CHANCE) {
            dropFruit(location, new LargeFruit());
        }
    }

    @Override
    public char getDisplayChar() {
        return 'T';
    }

    private void dropFruit(Location location, LargeFruit fruit) {
        Random rand = new Random();
        Location destination = location.getExits().get(rand.nextInt(location.getExits().size())).getDestination();
        destination.addItem(fruit);
    }
}