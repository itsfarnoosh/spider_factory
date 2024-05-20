package game.items;

import edu.monash.fit2099.engine.items.Item;

public class AstleyPrinter implements Printer {
    private final int price;

    public AstleyPrinter() {
        this.price = 50;
    }

    @Override
    public boolean printsItem() {
        return true;
    }

    @Override
    public Item getItem() {
        return new Astley();
    }

    @Override
    public int creditPayable() {
        return price;
    }
    @Override
    public String toString() {
        return "Astley";
    }
}
