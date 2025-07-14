import java.util.*;
public class LinearSearch {
    public static int linearsearch(int numbers[] , int key){
        for(int i=0;i<numbers.length;i++){ //i is the index of the array//
            if(numbers[i]==key){
                return i;
            }
        }
        return -1; //this tells that the key doesn't exists in our array.
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numbers[]= {2,4,6,8,10,12,14,16};
        System.out.print("Enter the value of key you want to search ");
        int key = sc.nextInt();
        int index =linearsearch(numbers , key);
        if(index==-1){
            System.out.print("Not the valid key");
        }else{
        System.out.print("The key found on the index " + index);}

    }
    
}
