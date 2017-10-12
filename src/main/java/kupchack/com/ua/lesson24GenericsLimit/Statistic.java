package kupchack.com.ua.lesson24GenericsLimit;

public class Statistic<T extends Number & Comparable> {
    private T[] numbers;

    public Statistic(T[] numbers) {
        this.numbers = numbers;
    }

    public double getAverage(){
        double result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i].doubleValue();
        }
        return result/numbers.length;
    }

    public boolean isSameAVG(Statistic<? extends Number> obj){
        if(this.getAverage() == obj.getAverage()){
            return true;
        }
        return false;
    }
}
