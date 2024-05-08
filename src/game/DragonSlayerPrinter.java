package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.Random;

public class DragonSlayerPrinter implements Printer{
    private final DragonSlayer item = new DragonSlayer();
    private int credit;
    private int successChance; // chance of intern paying double
    public Item getItem() {
        return item;
    }

    public int creditPayable() {
        return credit;
    }

    /**
     * Constructor
     *
     */
    public DragonSlayerPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    public boolean printsItem(){
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dragon Slayer";
    }
}
