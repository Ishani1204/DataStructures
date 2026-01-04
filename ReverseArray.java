import java.util.*;
public class ReverseArray {
     public static void reverse(int numbers[]){
        int first =0 , last=numbers.length-1;
        while(first<last){
            //swap
            int temp= numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;
            first++;
            last--;
            }
        }
    public static void main(String args[]){
     Scanner sc = new Scanner(System.in);

     int numbers[] ={2,4,6,8,10};
     reverse(numbers);
      //To print
      for(int i=0;i<numbers.length;i++){
        System.out.print(numbers[i] + " ");
     }
       System.out.println();
    }
}
