package game.items.printers;

import edu.monash.fit2099.engine.items.Item;
import game.items.Astley;

/**
 * A Printer for creating Astley items.
 */
public class AstleyPrinter implements Printer {
    private final int price;
    /**
     * Constructor for the AstleyPrinter.
     */
    public AstleyPrinter() {
        this.price = 50;
    }
    /**
     * Indicates whether this printer prints items.
     *
     * @return true, indicating that this printer can print items.
     */
    @Override
    public boolean printsItem() {
        return true;
    }
    /**
     * Creates and returns a new Astley item.
     *
     * @return A new Astley item.
     */
    @Override
    public Item getItem() {
        return new Astley();
    }
    /**
     * Returns the price of the item printed by this printer.
     *
     * @return The price of the Astley item.
     */
    @Override
    public int creditPayable() {
        return price;
    }
    /**
     * Returns a string representation of the printer.
     *
     * @return A string representing the printer.
     */
    @Override
    public String toString() {
        return "Astley";
    }
}
