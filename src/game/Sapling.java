package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sapling extends Ground{
    private int age = 0;
    double matureAge = 5;
    double PLANT_CHANCE = 0.3;

    /**
     * Constructor.
     *
     */
    public Sapling() {
        super('t');
    }

    /**
     * Allow the sapling to count turns
     * Will turn mature when the age of the sapling met their given matureAge
     * Otherwise, will add small fruit if the chance is met.
     *
     * @param location location of the sapling.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        double random = Math.random();
        Random rand = new Random();
        Location destination = location.getExits().get(rand.nextInt(location.getExits().size()))
                .getDestination();
        if (age >= matureAge){
            location.setGround(new Mature());
            }
        else {
            if (random <= PLANT_CHANCE) {
                destination.addItem(new SmallFruit());
            }

        }
    }
}