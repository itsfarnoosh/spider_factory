package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.items.Printer;
import game.items.ToiletPaper;

import java.util.Random;

public class ToiletPaperPrinter implements Printer {
    private final ToiletPaper item = new ToiletPaper();
    private int credit;
    private int successChance; // chance of intern paying 1 credit

    /**
     * Constructor
     *
     * @param credit the original price of the drink
     * @param chance chance of the drink to be double priced
     */
    public ToiletPaperPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    /**
     * Provide the item (the toilet paper)
     *
     * @result defensive copy of toilet paper.
     */
    public Item getItem() {
        return new ToiletPaper();
    }

    /**
     * Process the price for the toilet paper.
     * if the chance is met, the price will be deducted to 1.
     *
     * @return the price in integer for the energy drink
     */
    public int creditPayable() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            this.credit = 1;
        }
        return credit;
    }

    /**
     * Provide eligibility to print the drink
     *
     * @return grant boolean.
     */
    public boolean printsItem(){
        return true;
    }

    /**
     * provide the name of product
     *
     * @return Energy Drink in string
     */
    @Override
    public String toString() {
        return "Toilet Paper";
    }
}
