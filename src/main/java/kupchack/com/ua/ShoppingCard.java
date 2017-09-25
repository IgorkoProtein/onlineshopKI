package kupchack.com.ua;

import java.util.ArrayList;

public class ShoppingCard {
    private static int nextCardId = 100;
    private int cardId;
    private int quantity;
    private int dateAdded;
    private Product product;

    public ShoppingCard() {
        this.cardId = -1;
        this.quantity = -1;
        this.dateAdded = -1;
        setCardId();
        product = new Product();
    }

    public ShoppingCard(int cardId, int productId, int quantity, int dateAdded, String description, double price, int itemID) {
        this.cardId = cardId;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
        setCardId();
        product = new Product(description, price, itemID);
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(int dateAdded) {
        this.dateAdded = dateAdded;
    }

    public static ArrayList<ShoppingCard> createArrayList(){ return new ArrayList<ShoppingCard>();}

    public void setCardId(){
        cardId = nextCardId;
        nextCardId++;
    }

}
