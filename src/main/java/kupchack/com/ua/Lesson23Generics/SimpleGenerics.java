package kupchack.com.ua.Lesson23Generics;

public class SimpleGenerics<T> {
    private T firstValue;
    private T secondValue;

    public SimpleGenerics(T firstValue, T secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public T getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(T secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "SimpleGenerics{" + "firstValue=" + firstValue + ", secondValue=" + secondValue + '}';
    }
}
