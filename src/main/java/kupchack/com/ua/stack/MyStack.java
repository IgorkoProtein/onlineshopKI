package kupchack.com.ua.stack;

public class MyStack {
    private Node head = null;
    private int maxSize;
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
    }

    public void add(int data) {
        if (!isFull()){
        Node n = new Node(data);
        n.next = head;
        head = n;
        top++;
        }else System.out.println("Stack is full");
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        top--;
        return temp;
    }

    public Node peek() {
        Node temp = head;
        return temp;
    }

    public void show() {
        Node current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public Node search(int value){
        Node current = head;
        while(current.data!=value){
            if(current.next == null){
                return  null;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    public boolean empty() {
        if (head == null){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(top < maxSize){
            return false;
        }
        return true;
    }
}
