package kupchack.com.ua.lesson23;

public class Renner {
    public static void main(String[] args) {
        Replacer obj1 = new Replacer(new ConsoleReader(), new InfoShower());
        //obj1.replace();

        Replacer obj2 = new Replacer(new FileReader(), new InfoShower());
        obj2.replace();
    }
}
