package game;

import edu.monash.fit2099.engine.items.Item;

import javax.xml.stream.events.EntityReference;
import java.util.Random;

public class EnergyDrinkPrinter implements Printer{
    private final EnergyDrink item = new EnergyDrink(1);
    private int credit;

    private int successChance; // chance of intern paying double

    /**
     * Constructor
     *
     */
    public EnergyDrinkPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    public Item getItem() {
        return item;
    }

    public int creditPayable() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            credit = credit * 2;
        }
        return credit;
    }

    public boolean printsItem(){
        return true;
    }

    @Override
    public String toString() {
        return "Energy Drink";
    }
}
