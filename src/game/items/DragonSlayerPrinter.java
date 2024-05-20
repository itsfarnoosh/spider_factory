package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class DragonSlayerPrinter implements Printer {

    // I would love to call this class Godot. RIP.

    private final DragonSlayer item = new DragonSlayer();
    private final int credit;
    private final int successChance; // chance of DragonSlayer printing.

    /**
     * Constructor
     *
     * @param credit the price of the Dragon-slayer. GRIFFITH!!!
     * @param chance  the chance of the sword being print.
     */
    public DragonSlayerPrinter(){
        this.credit = 50;
        this.successChance = 50;
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
     * Provide the price of the Dragon-Slayer
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
