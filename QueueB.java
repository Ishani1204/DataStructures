import java.util.*;
public class QueueB {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        
        public void push(int data){
            deque.addLast(data);
        }
    

       public int pop(){
        return deque.removeLast(); 
       }  
       
       public int peek(){
        return deque.getLast();
       }
}

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public void remove(){
            deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String args[]){

        //Implementing the Queues using Deque
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("The queue's first element is " + q.peek());
        
        
        //Implementing the Stacks using Deque
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Peek the first el " + s.peek());

        //Implementing the Deque
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1); //1
        deque.addFirst(2); //2 1
        deque.addLast(3); // 2 1 3
        deque.addLast(4); // 2 1 3 4
        System.out.println(deque);
        deque.removeFirst(); // 1 3 4
        deque.removeLast(); // 1 3
        System.out.println(deque);
        System.out.println("The first el = " + deque.getFirst());
        System.out.println("The last el is = " + deque.getLast());
    } 
}


