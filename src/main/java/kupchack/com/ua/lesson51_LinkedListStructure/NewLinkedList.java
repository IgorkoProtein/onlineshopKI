package kupchack.com.ua.lesson51_LinkedListStructure;

public class NewLinkedList {
    private Node head;

    public NewLinkedList(Node head) {
        this.head = head;
    }

    public NewLinkedList() {
        this.head = null;
    }

    public void insertFirst(int id, int value){
        Node newNode = new Node(id, value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(int key, int id, int value){
        Node newNode = new Node(id, value);
        Node current = findNode(key);

        Node nextNode = current.next;
        current.next = newNode;
        newNode.next = nextNode;
    }



    public Node delete( int value){
        Node current = head;
        Node previous = head;
        while(current.data!=value){
            if(current.next == null){
                return  null;
            }else{
                previous = current;
                current = current.next;
            }
        }
        if(current == head){
            head = current.next;
        }else {
            previous.next = current.next;
        }
        return current;
    }

    public Node findNode(int key){
        Node current = head;
        while(current.data!=key){
            if(current.next == null){
                return  null;
            }else{
                current = current.next;
            }
        }
        return current;
    }



    public void showList(){
        System.out.println("List (first-->last) : ");
        Node current = head;
        while(current!=null){
            System.out.println(current.toString());
            current = current.next;
        }

        System.out.println("");
    }
}
