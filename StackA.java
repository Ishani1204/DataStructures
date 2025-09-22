import java.util.*;
public class StackA {
    //implementing stack using Arraylist
    static class Stack1{
        static ArrayList<Integer> list = new ArrayList<>();
        //isEmpty function
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push
        public static void push(int data){
           list.add(data);
        }
        
        //pop
        public static int pop(){
            //corner case 
            if(isEmpty()){
                return -1;
            }
           int top = list.get(list.size() - 1);
           list.remove(list.size() - 1);
           return top;
        }

        //peek
        public static int peek(){
            //corner case 
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    //implementing stack using linked list
    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack2{
        static Node head = null ;

        public static boolean isEmpty(){
            return head == null;
        }

        //push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    //push at bottom of the stack (amazon)
    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    //reverse a string using stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");    
        while(!s.isEmpty()){
              char curr = s.pop();
              result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    //stockspan
    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1 ; i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                  s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }

            s.push(i);
        }
    }
    public static void main(String[] args){ 
        //when using java collection framework
        //Stack<Integer> = new Stack();
        //now this implements the all function   
         /* Stack2 s = new Stack2();
         s.push(1);
         s.push(2);
         s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop(); */
       /*  Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
         pushAtBottom(s, 4);
         while(!s.isEmpty()){
            System.out.println(s.pop());
         }
        
        String str = "abc";
        String result = reverseString(str);
        System.out.println(result); */

       /*  Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

    
        reverseStack(s);
        printStack(s); */

    /* int stocks[] = {100,80,60,70,60,85,100};
    int span[] = new int [stocks.length];
    stockSpan(stocks, span);
    for(int i =0 ; i<span.length;i++){
        System.out.println(span[i]+ "");
         } */
    //next greater element from right
    int arr[] = {6,8,0,1,3};
    Stack<Integer> s = new Stack<>();
    int nxtGreater[] = new int[arr.length];

    for(int i= arr.length-1; i>=0 ;i--){
        //1 while loop
        while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
            s.pop();
        }

        //2 if-else
        if(s.isEmpty()){
            nxtGreater[i] = -1;
        } else {
            nxtGreater[i] = arr[s.peek()];
        }
        //3 push is s
        s.push(i);
        }
    for(int i=0 ; i<nxtGreater.length;i++){
        System.out.print(nxtGreater[i] + " ");
        }
        System.out.println(); 

    //next greater element from left
    //condition of loop changes to for(int i=n; i<=0 ;i++)

    //next smaller element from right side
    //condition changes to while(!s.isEmpty() && arr[s.peek()] >= arr[i])

    //next smaller element from left side
    /*condition of loop changes to for(int i=n; i<=0 ;i++)
      condition changes to while(!s.isEmpty() && arr[s.peek()] >= arr[i])
   */
    }

}

