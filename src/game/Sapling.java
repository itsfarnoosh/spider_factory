package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sapling extends Ground{
    private int age = 0;
    double matureAge = 5;
    double PLANT_CHANCE = 0.3;

    public Sapling() {
        super('t');
    }


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