package kupchack.com.ua.stack;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + ", data=" + data +'}';
    }
}
