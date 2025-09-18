public class LinkedList {
    //initialisation of the class node
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){ // Time Complexity - O(1)
        //step 1 - Creating the new node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2
        newNode.next = head ;// linking

       //step 3
       head = newNode ; //head updated
    }

    public void addLast(int data){ // Time Complexity - O(1)
        //step 1
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2
        tail.next = newNode ;
        //step 3 - tail ko update karke next ko point kiya
        tail = newNode;

    }

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3); 
        ll.addLast(4);
        ll.addLast(5);
    }
}
