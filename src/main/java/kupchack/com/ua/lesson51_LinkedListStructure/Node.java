package kupchack.com.ua.lesson51_LinkedListStructure;

public class Node {
    public int index;
    public int data;
    public Node next;


    public Node(int index, int data) {
        this.index = index;
        this.data = data;
    }

    public Node( int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "index=" + index + ", data=" + data +'}';
    }
}
