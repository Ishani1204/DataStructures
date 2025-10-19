public class QueueA {
   //Queue implemented using Linked List
   static class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
   }
   static class Queue{
    static Node head = null ;
    static Node tail = null ;
    public static boolean isEmpty(){
        return head == null && tail == null;
    }

    public static void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("empty queue");
            return-1;
        }
        int front = head.data;
        //single element
        if(tail == head){
            tail = head = null;
        } else {
            head = head.next;
        }
        return front;
    }

    public static int peek(){
         if(isEmpty()){
             System.out.println("empty queue");
             return -1;
         }
         return head.data;
       }
}


    //Queue and circular queue implemented using Array
//     static class Queue{
//         static int arr[];
//         static int size;
//         static int rear;
//         static int front;


//         Queue(int n){
//             arr = new int[n];
//             size = n;
//             rear = -1;
//             front = -1;
//         }

//     public static boolean isEmpty(){
//         return rear == -1 && front == -1;
//     }    


//     //check full
//     public static boolean isFull(){
//         return (rear+1) % size == front;
//     }
    
//     //add in circular queue
//     public static void addIncircularQueue(int data) //O(1)
//    {
//         if(isFull()){
//             System.out.println("Queue is full");
//             return;
//         }
//         //add first element
//         if(front == -1){
//             front = 0;
//         }
//         rear = rear + 1 % size;
//         arr[rear] = data;
//     }

//     //remove in circular queue
//     public static int removeIncircularQueue() //O(n)
//    {
//     if(isEmpty()){
//         System.out.println("Empty is the queue");
//         return -1;
//     }

//     int result  =  arr[front];
//     front = (front + 1)% size ;
//     //last element delete
//     if(rear == front){
//         rear = front = -1;
//     } else{
//         front = (front + 1) % size;
//     }
//     return result;

//         }

//     //peek in circular queue
//     public static int peekIncircularQueue(){
//         if(isEmpty()){
//             System.out.println("empty queue");
//             return -1;
//         }

//         return arr[front];
//         }
     
//    //add
//    public static void add(int data) //O(1)
//    {
//         if(rear == size-1){
//             System.out.println("Queue is full");
//             return;
//         }
//         rear = rear + 1;
//         arr[rear] = data;
//     }

//    //remove
//    public static int remove() //O(n)
//    {
//     if(isEmpty()){
//         System.out.println("Empty is the queue");
//         return -1;
//     }

//     int front = arr[0];
//     for(int i=0; i<rear; i++){
//         arr[i]= arr[i+1];
//     }
//     rear = rear -1 ;
//     return front;

//         }
    
//     //peek
//     public static int peek(){
//         if(isEmpty()){
//             System.out.println("empty queue");
//             return -1;
//         }

//         return arr[0];
//         }
//     }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
