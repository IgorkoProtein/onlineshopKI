package kupchack.com.ua.Lesson23Generics;

public class Runner {
    public static void main(String[] args) {
        SimpleGenerics<Integer> generic1 = new SimpleGenerics<Integer>(4, 3);
        System.out.println(generic1.toString());

        SimpleGenerics<String> generic2 = new SimpleGenerics<String>("first word", "second word");
        System.out.println(generic2.toString());


    }
}
