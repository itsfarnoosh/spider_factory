package game.items.consumables;

import edu.monash.fit2099.engine.items.Item;
import game.items.Printer;
import game.items.consumables.EnergyDrink;

import java.util.Random;

public class EnergyDrinkPrinter implements Printer {

    private int healingPoints = 1;
    private final EnergyDrink item = new EnergyDrink(healingPoints);
    private int credit;

    private int successChance; // chance of intern paying double

    /**
     * Constructor
     *
     * @param credit the original price of the drink
     * @param chance chance of the drink to be double priced
     */
    public EnergyDrinkPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    /**
     * Provide the item (the energy drink)
     *
     * @return defensive copy of the item (drink)
     */
    public Item getItem() {
        return new EnergyDrink(healingPoints);
    }

    /**
     * Process the price for the energy drink.
     * if the chance is met, the price will be double.
     *
     * @return the price in integer for the energy drink
     */
    public int creditPayable() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            credit = credit * 2;
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
        return "Energy Drink";
    }
}
