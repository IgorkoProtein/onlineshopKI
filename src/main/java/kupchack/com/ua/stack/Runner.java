package kupchack.com.ua.stack;

public class Runner {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(433);
        stack.add(4);
        stack.add(5);
        stack.add(6);

        stack.pop();
        stack.pop();

        System.out.println(stack.peek());


        System.out.println(stack.search(433));

        System.out.println(stack.empty());

    }
}
