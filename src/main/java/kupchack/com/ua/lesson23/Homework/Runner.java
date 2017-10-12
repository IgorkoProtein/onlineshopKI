package kupchack.com.ua.lesson23.Homework;

public class Runner {
    public static void main(String[] args) {
        Store store1 = new Store(new Chooser(), new BuyerCard());
        Store store2 = new Store(new Chooser(), new BuyerCash());

        store1.startShop();
        store2.startShop();
    }
}
