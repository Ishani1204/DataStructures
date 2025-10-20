import java.util.* ;
public class StackB {
    //Valid Paranthesis
    public static boolean isValid(String str) // O(n)
    {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length() ; i++){
            char ch = str.charAt(i);

            //opening 
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            } else {
            //closing
            if(s.isEmpty()){
               return false;
            }
            if( (s.peek()=='(' && ch==')')
            || (s.peek()=='{' && ch == '}')
            || (s.peek()=='[' && ch == ']')
            ){
               s.pop(); 
            }else{
            return false;
            }
        }
    }

    if(s.isEmpty()){
        return true;
    } else {
        return false;
    }
}

 //Duplicate paranthesis  
    public static boolean isDuplicate(String str) // time Complexity - O(n)
    {
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);

            //closing
            if(ch== ')'){
                int count =0 ;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                  s.pop();  
                }
            } else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }

//Maximum Area In Histogram
    public static void maxArea(int arr[]) //// time Complexity - O(n)
{ 
    int maxArea = 0 ;
    int nsr[] = new int[arr.length];
    int nsl[] = new int[arr.length];    
    
    //next smaller right
    Stack<Integer> s = new Stack<>();
        for(int i= arr.length-1; i>=0 ;i--){
        //1 while loop
        while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
            s.pop();
        }

        //2 if-else
        if(s.isEmpty()){
            nsr[i] = arr.length;
        } else {
            nsr[i] = s.peek();
        }
        //3 push is s
        s.push(i);
        }
    //next smaller left
        s = new Stack<>();
    for(int i=0; i<arr.length ;i++){
        //1 while loop
        while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
            s.pop();
        }

        //2 if-else
        if(s.isEmpty()){
            nsl[i] = -1;
        } else {
            nsl[i] = s.peek();      
        }
        //3 push is s
        s.push(i);
        }
    //current area : width = j-i-1 = nsr[i] - nsl[i] - 1
    for(int i=0 ; i<arr.length; i++){
     int height = arr[i];
     int width = nsr[i]- nsl[i] - 1;
     int currArea = width * height;
     maxArea = Math.max(maxArea , currArea);
    }
    System.out.println("Max Area is " + maxArea);
}
    public static void main(String args[]){
        int arr[] ={2, 1, 5, 6, 2, 3}; //heights in histogram
        maxArea(arr);
    }
}
