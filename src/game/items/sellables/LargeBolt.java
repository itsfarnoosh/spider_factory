package game.items.sellables;

/**
 * A class representing a Large Bolt item in the game.
 */
public class LargeBolt extends SellableScrap {

    /***
     * Constructor.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true, 25);

    }

    /***
     * Non-default Constructor.
     *
     * @param price of the item
     */
    public LargeBolt(int price) {
        super("Large Bolt", '+', true, price);
    }
}