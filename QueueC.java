import java.util.*;
public class QueueC {
// queue implemented using two stacks   
    static class QueueA {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }

            return s1.pop();
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }

            return s1.peek();
        }
    }        
//Stacks implemented using two queues
static class StackC{
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>(); 

    public static boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void push(int data){
        if(!q1.isEmpty()){
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    public static int pop(){
        if(isEmpty()){
            System.out.println("Empty stack");
            return -1;
        }  
        int top = -1;
        //case 1 : q1 is fill so we empty it
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()) {
                    break;
                }
                q2.add(top);
            }
        } else{  //case 2 : q2 is now full so we perform the operation on q1
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()) {
                    break;
                }
                q1.add(top);
            }

        }
        return top;
    }

    public static int peek(){
      if(isEmpty()){
            System.out.println("Empty stack");
            return -1;
        }  
        int top = -1;
        //case 1 : q1 is fill so we empty it
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
        } else{  //case 2 : q2 is now full so we perform the operation on q1
            while(!q2.isEmpty()){
                top = q2.remove();
                q1.add(top);
            }

        }
        return top;  
    }
}
//Queue Reversal
    public static void reverse(Queue<Integer> q1){
        Stack<Integer> s = new Stack<>();

        while(!q1.isEmpty()){
            s.push(q1.remove());
        }

        while(!s.isEmpty()){
            q1.add(s.pop());
        }
}

//First Non - Repeating letters in the stream of alphabets
    public static void printNonRepeating(String str){
        int freq[] = new int [26]; //'a'- 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0 ; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++ ;

        while(!q.isEmpty() && freq[q.peek()-'a']>1){
            q.remove();
        }
        if(q.isEmpty()){
            System.out.print(-1 + "");
        } else{
            System.out.print(q.peek() + "");
        }
    }
    System.out.println();
}

//Interleafing of queues
public static void interLeave(Queue<Integer> q2){
    Queue<Integer> firstHalf = new LinkedList<>();
    int size = q2.size();

    for(int i=0; i<size/2; i++){
        firstHalf.add(q2.remove());
    }

    while(!firstHalf.isEmpty()){
        q2.add(firstHalf.remove());
        q2.add(q2.remove());
    }
}


    public static void main(String args[]){
        QueueA q = new QueueA();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        StackC s = new StackC();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        reverse(q1);
    while(!q1.isEmpty()){
            System.out.println(q1.remove() + " ");
        }
    System.out.println();
    String str = "aabccxb";
    printNonRepeating(str);


    Queue<Integer> q2 = new LinkedList<>();
    q2.add(1);
    q2.add(2);
    q2.add(3);
    q2.add(4);
    q2.add(5);
    q2.add(6);
    q2.add(7);
    q2.add(8);
    q2.add(9);
    q2.add(10);
    interLeave(q2);
    while(!q2.isEmpty()){
            System.out.println(q2.remove() + " ");
        }
    System.out.println();
    }
}
