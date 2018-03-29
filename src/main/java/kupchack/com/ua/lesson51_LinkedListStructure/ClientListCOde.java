package kupchack.com.ua.lesson51_LinkedListStructure;

public class ClientListCOde {
    public static void main(String[] args) {
        NewLinkedList someList = new NewLinkedList();
        someList.insertFirst(1, 25);
        someList.insertFirst(2, 55);
        someList.insertFirst(3, 20);
        someList.insertFirst(4, 27);
        someList.insertFirst(7, 29);

        someList.showList();

       // someList.insertAfter(20, 8, 99);
        someList.delete(20);
        someList.showList();



        //Node foundNode = someList.findNode(20);
        //System.out.println("Founded node is :"+foundNode.toString());




    }
}
