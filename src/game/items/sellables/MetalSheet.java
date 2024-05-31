package game.items.sellables;

import java.util.Random;

/**
 * A class representing a Metal Sheet item in the game.
 */
public class MetalSheet extends SellableScrap {

    /***
     * Constructor.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true, 20, 60);
    }

    public MetalSheet(int price, int chance) {
        super("Metal Sheet", '%', true, price, chance);
    }

    @Override
    public int getPrice() {
        int percentage = new Random().nextInt(100);

        if (percentage < super.getChance()){
            super.setPrice(10);
        }

        return super.getPrice();
    }
}

