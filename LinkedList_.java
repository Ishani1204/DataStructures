//import java.util.LinkedList;
public class LinkedList_ {
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
    public static int size;

    public void addFirst(int data){ // Time Complexity - O(1)
        //step 1 - Creating the new node
        Node newNode = new Node(data);
        size++;
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
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2
        tail.next = newNode ;
        //step 3 - tail ko update karke next ko point kiya
        tail = newNode;

    }

    public void print() { // Time Complexity - O(n)
        if(head == null){
            System.out.println("LL is empty.");
            return ;
        }
        Node temp = head; //temporary variable main head store karwa liya
        while(temp != null){
            System.out.print(temp.data+"->");
            //temp ko update kiya
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx , int data){ //Time Complexity - O(n)
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head ;
        int i = 0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        // i = idx-1 ; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) // head or tail dono same h
        {
            int val = head.data;
            head = tail = null ;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0 ;
            return val;
        }
        //prev : i = size-2
        Node prev = head ;
        for(int i=0; i<size-2; i++){
            prev= prev.next;
        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    
    public int iterativeSearch(int key ){ //iterative approach tha ye
        Node temp = head ;
        int i =0;

         while(temp !=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;

    }
    //helper function
    public int helper(Node head , int key){ //O(n)
        if(head == null){
            return-1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }
    public int recursiveSearch(int key){
        return helper(head , key);
    }

    public void reverse(){ //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthFromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next; //removeFirst operation
            return;
        }
        //sz-n
        int i =1;
        int itoFind = sz-n;
        Node prev = head;
        while(i< itoFind){
          prev = prev.next;
          i++;
        }

        prev.next = prev.next.next; 
        return;
    }

    //Slow Fast technique
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1 jump
            fast = fast.next.next; //+2 jump
        }
        return slow; //slow is my midNode
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1 - find mid
        Node midNode = findMid(head);

        //step 2 - revrse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = head;

        //step 3 - check left half & right half
        while(right != null){
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;

    }

    //detect loop or cycle in linked list -> Flloyd's Cycle Finding Algo
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) // normal ll w/t cycle wala
        {
            slow = slow.next; //+1 jump
            fast = fast.next.next; //+2 jump
            if(slow == fast){
                return true; //cycle
            }
        }
        return false;
    }

    //remove cycle
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false ;
        while(fast != null && fast.next != null) // normal ll w/t cycle wala
        {
            slow = slow.next; //+1 jump
            fast = fast.next.next; //+2 jump
            if(slow == fast){
           cycle = true;
           break;
            }
        }
    if(cycle == false){
        return;
    }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast) {
          prev = fast;
          slow = slow.next;
          fast = fast.next;
        }
        //remove cycle -> last.next = null
          prev.next = null;
    }

    public Node mergeSort(Node head){
        //base case
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
       //left and right half call merge sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
       //call merge
       return merge(newLeft , newRight);
    }

     private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1 jump
            fast = fast.next.next; //+2 jump
        }
        return slow; 
    }

    private Node merge(Node head1 , Node head2){
            Node mergedLL = new Node(-1);
            Node temp = mergedLL;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       Node left = head;
       Node right = prev;
       Node nextL , nextR;
       
       //alt merge - zig-zag merge
       while(left != null && right!= null){
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next= nextL;
        
        left = nextL;
        right = nextR;

       }
    }
    public static void main(String[] args) {
        LinkedList_ ll = new LinkedList_();
        ll.addFirst(2);
        ll.addFirst(1); 
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2,3);
        ll.print();
        //System.out.println(ll.size);
        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
       // System.out.println(ll.recursiveSearch(3));
       // System.out.println(ll.recursiveSearch(10));
       ll.reverse();
       ll.print();
       ll.deleteNthFromEnd(3);
       ll.print();
       System.out.println(ll.checkPalindrome());

       // using linked list framewroks
       //LinkedList<Integer> ll = new LinkedList<>();
       //to add ll.addFirst(); ll.addLast();
       //to remove ll.removeFirst(); ll.removeLast;
       //print syso(ll)
    }
}
