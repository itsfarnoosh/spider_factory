package game.items;

import edu.monash.fit2099.engine.items.Item;

public class AstleyPrinter implements Printer {
    private final int price;

    public AstleyPrinter(int price) {
        this.price = price;
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
