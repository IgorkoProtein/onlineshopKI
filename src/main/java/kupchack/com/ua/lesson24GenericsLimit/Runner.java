package kupchack.com.ua.lesson24GenericsLimit;

public class Runner {
    public static void main(String[] args) {
        Integer intArray[] = {5, 4, 7, 45};
        Statistic<Integer> obj1 = new Statistic<>(intArray);

        Double doubleArray[] = {5.0, 4.00, 7.0, 45.0};
        Statistic<Double> obj2 = new Statistic<>(doubleArray);

        System.out.println(obj1.getAverage());
        System.out.println(obj2.getAverage());

        System.out.println( obj1.isSameAVG(obj2));


    }
}
