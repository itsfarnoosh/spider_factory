package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Sapling extends Ground{
    private int age = 0;

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

        if (age >= 5){
            location.setGround(new Mature());
            }
        else {
            if (random <= 0.3) {
                destination.addItem(new SmallFruit());
            }

        }
    }
}