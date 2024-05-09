package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.Random;

public class DragonSlayerPrinter implements Printer{

    // I would love to call this class Godot. RIP.

    private final DragonSlayer item = new DragonSlayer();
    private int credit;
    private int successChance; // chance of dragonslayer printing.

    /**
     * Constructor
     *
     * @param credit the price of the Dragon-slayer. GRIFFITH!!!
     * @param chance  the chance of the sword being print.
     */
    public DragonSlayerPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    /**
     * Provide the Dragon-Slayer.
     *
     * @return defensive copy / replica of Dragon-Slayer.
     */
    public Item getItem() {
        return new DragonSlayer();
    }

    /**
     * Porvide the price of the Dragon-Slayer
     *
     * @return the price of the Dragon-Slayer
     */
    public int creditPayable() {
        return credit;
    }

    /**
     * Process the chance of printing dragon-slayer
     *
     * @return whether the dragon-slayer is printable.
     */
    public boolean printsItem(){
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            return false;
        }
        return true;
    }

    /**
     * provide the name of the sword (which is Dragon Slayer / chunk of metal.)
     *
     * @return Dragon-Slayer in string
     */
    @Override
    public String toString() {
        return "Dragon Slayer";
    }
}
