package game;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Mature extends Ground{
    private int age = 5;
    private final double PLANT_CHANCE = 0.2;

    /**
     * Constructor.
     *
     */
    public Mature() {
        super('T');
    }

    /**
     * Allow the mature tree to count turns
     * Will add Large fruit onto it's surrounding if the chance is met.
     *
     * @param location location of the mature tree.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        double random = Math.random();
        Random rand = new Random();
        Location destination = location.getExits().get(rand.nextInt(location.getExits().size()))
                .getDestination();
        if (random <= PLANT_CHANCE) {
                destination.addItem(new LargeFruit());
            }

        }
    }