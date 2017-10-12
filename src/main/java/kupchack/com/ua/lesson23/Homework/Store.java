package kupchack.com.ua.lesson23.Homework;

public class Store {
    private IChoose choose;
    private IPay pay;


    public Store(IChoose choose, IPay pay){
        this.choose = choose;
        this.pay = pay;
    }

    public void startShop (){
        pay.payForProduct();
        choose.choose();
    }

}
