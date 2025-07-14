import java.util.Arrays;
import java.util.Collections;
public class BasicSorting {
 public static void BubbleSort(Integer arr[]){
    for(int i=0;i<(arr.length-1);i++)// for the number of turns we performed the swapping (i here denotes turns)
    {
     int swap=0;
        for(int j=0;j<(arr.length-1-i);j++)//for swapping between elements!!
        {
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swap++;
        }
         }
   System.out.println(" the value of swaps used " + swap);
   if(swap==0){
    break;
   }
}
   
 }

 public static void selectionSort(Integer arr[]){
    for(int i=0;i<arr.length-1;i++){
        int minPos = i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[minPos] < arr[j]) //If we have to push greater number forward then we will just update the 
                                    //condition given under the "if statement" just "minPos < arr[j]".
            {
                minPos = j ;
            }
        }
        //swap
        int temp = arr[minPos];
        arr[minPos]=arr[i];
        arr[i]=temp;
    }
 }
public static void insertionSort(Integer arr[]){
    for(int i=1;i<arr.length;i++){
        int curr=arr[i];
        int prev=i-1;
        //finding the correct position to insert
        while(prev>=0 && arr[prev]<curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        //insertion
        arr[prev+1] = curr;
    }
}

public static void CountSort(int arr[]){
    int largest = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        largest = Math.max(largest , arr[i]);
    }
    int count[]= new int[largest+1];
    for(int i=0;i<arr.length;i++){
        count[arr[i]]++;
    }
    //sort
    int j=0;
    for(int i=0;i<count.length;i++){
      while(count[i]>0){
        arr[j]=i;
        j++;
        count[i]--;
      }
    }
}
public static void printarr(int arr[]){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + " ");

    }
    
}
public static int diagnolsum(int arr[][]){
    int sum=0;
    for(int i=0;i<arr.length;i++) //Time Complexity=O(n^2) (Brute foce code hai yeh!!!!)
    {
        for(int j=0;j<arr[0].length;j++){
         if(i==j){
            sum +=arr[i][j];
         }
         else if(i+j==arr.length-1){
            sum+=arr[i][j];
         }
        }
    }
    return sum;
    }
public static int diagnolsum1(int arr[][]){
    int sum = 0; //Time Complexity = o(n) : Linear Complexity
    for(int i=0;i<arr.length;i++){
        //pd
        sum += arr[i][i];
        //sd
        if(i!= arr.length-i-1)
                sum =+ arr[i][arr.length-1-i];
    }
    return sum;
}
public static boolean staircasesearch(int arr[][] , int key){
    int row = 0 ,col=arr[0].length-1;
     while(row<arr.length && col>=0){
        if(arr[row][col]==key){
            System.out.println("Key found at " + "(" + row + "," + col + ")");
            return true;
        }
        else if(key<arr[row][col]){
            col--;
        }
        else{
            row++;
        }
     }
     System.out.println("Key not found");
     return false;
}

    public static void main(String args[]){
    int arr[][] = {{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
    int key = 100;
    staircasesearch(arr, key);

    } } 
