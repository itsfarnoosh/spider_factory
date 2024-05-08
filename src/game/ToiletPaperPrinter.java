package game;

import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class ToiletPaperPrinter implements Printer{
    private final ToiletPaper item = new ToiletPaper();
    private int credit;

    private int successChance; // chance of intern paying double

    /**
     * Constructor
     *
     */
    public ToiletPaperPrinter(int credit, int chance){
        this.credit = credit;
        this.successChance = chance;
    }

    public boolean printsItem(){
        return true;
    }

    public Item getItem() {
        return item;
    }

    public int creditPayable() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.successChance){
            this.credit = 1;
        }
        return credit;
    }

    @Override
    public String toString() {
        return "Toilet Paper";
    }
}
