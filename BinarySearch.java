import java.util.*;
public class BinarySearch {
    public static int binarySearch(int numbers[] , int key){
        int start = 0; //0th index
        int end = numbers.length-1; //last index  
        while(start<=end){
            int mid=(start+end)/2;
            if(numbers[mid]==key) //Found condition  | numbers[mid] means ki numbers array ki mid wale index
            {                                          // par stored value
                return mid; //At this index that is index of mid our key exists;
            }
            if(numbers[mid]<key) //right case  
            {
                start = mid+1;
            }else{end = mid-1;}
        }
        return -1;
    }
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numbers[]={2,4,6,8,10,12,14};
        int key=10;
        System.out.println("The key is found at index " + binarySearch(numbers , key));
    }
}
