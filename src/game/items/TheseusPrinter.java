package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class TheseusPrinter implements Printer {
    private final Theseus item = new Theseus();
    private int credit;
    private int successChance; // chance of reducing price

    /**
     * Constructor
     */
    public TheseusPrinter() {
        this.credit = 100;
        this.successChance = 50; // 50% chance to reduce price for example
    }

    /**
     * Provide the item (THESEUS)
     *
     * @return a new THESEUS item.
     */
    public Item getItem() {
        return new Theseus();
    }

    /**
     * Process the price for THESEUS.
     * If the chance is met, the price will be deducted.
     *
     * @return the price in integer for THESEUS
     */
    public int creditPayable() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance) {
            this.credit = 50; // Reduced price if success chance is met
        }
        return credit;
    }

    /**
     * Provide eligibility to print the item
     *
     * @return always true.
     */
    public boolean printsItem() {
        return true;
    }

    /**
     * Provide the name of product
     *
     * @return THESEUS Teleporter in string
     */
    @Override
    public String toString() {
        return "THESEUS Teleporter";
    }
}
