package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class TheseusPrinter implements Printer {
    private final Theseus item = new Theseus();
    private int credit;

    /**
     * Constructor
     */
    public TheseusPrinter() {
        this.credit = 100;

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
