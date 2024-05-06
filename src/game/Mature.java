package game;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Mature extends Ground{
    private int age = 5;
    /**
     * Constructor.
     *
     */
    public Mature() {
        super('T');
    }


    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        double random = Math.random();
        Random rand = new Random();
        Location destination = location.getExits().get(rand.nextInt(location.getExits().size()))
                .getDestination();

        double plantChance = 0.2;
        if (random <= plantChance) {
                destination.addItem(new LargeFruit());
            }

        }
    }