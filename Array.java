import java.util.*;
public class Array {
    //Function to update the marks //
    public static void update(int marks[]){
        //Now this loop is very important because here we are traversing the array
       //Yahan hum loop chala rhe h from 0 index till the length of array like
       //uppose array is of size of 3 then loop will work from index 0 to 2 
     for(int i=0;i<marks.length;i++){
        marks[i]=marks[i]+1;} }


       //Function to find largest in array
     public static int getLargest(int numbers[]){
       int largest = Integer.MIN_VALUE;
       int smallest = Integer.MAX_VALUE; //Signifies minus infinity
       for(int i=0;i<numbers.length;i++){
            if(largest<numbers[i]){
                largest=numbers[i];
            }
            if (smallest>numbers[i]){
                smallest=numbers[i];
            }
       }
       System.out.println("The smallest value in array is " + smallest);
       return largest;
     }


     //Pairs In array
     public static void pairs(int numbers[]){
      int tp=0; //tp=total pairs
      for(int i=0;i<numbers.length;i++){
       int curr=numbers[i];
       for(int j=i+1;j<numbers.length;j++){
        System.out.print( "(" + curr + "," + numbers[j] + ")");
        tp++;
       }
       System.out.println();
      }
      System.out.println("The number of total pairs are " + tp);
     }


     //Print Subarrays
     public static void subarrays(int numbers[]){
      int ts=0; //ts=total subarrays
      for(int i=0;i<numbers.length;i++){
        for(int j=i;j<numbers.length;j++){
          for(int k=i;k<=j;k++){
            System.out.print(numbers[k]);
            
          }
          ts++;
          System.out.println();
        }
        System.out.println(); 
      }
      System.out.println("Total subarrays are " + ts);
     }


     //Max Subarray Sum (Not very optimum approach as the time complexity is n^3 which is not a good T.C.)
     public static void maxSubarraySum(int numbers[]){
      int CurrSum=0;
      int maxSum=Integer.MIN_VALUE;
   
       for(int i=0;i<numbers.length;i++){
           int start=i;
         for(int j=i;j<numbers.length;j++){
           int end=j;
           CurrSum=0;
           for(int k=start;k<=end;k++){
   
             CurrSum += numbers[k];
             
           }
           System.out.println(CurrSum);
           if(maxSum<CurrSum){
               maxSum = CurrSum;
           }
         }
       }
       System.out.println("max sum = " + maxSum);
      }


      public static void maxSubarraySum1(int numbers[]){
        int CurrSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]= numbers[0];
        //calculate the prefix array
        for(int i=1;i<prefix.length;i++){
          prefix[i]=prefix[i-1]+numbers[i];
        }
        for(int i=0;i<numbers.length;i++){
             int start=i;
           for(int j=i;j<numbers.length;j++){
             int end=j;
             CurrSum= start==0 ? prefix[end] : prefix[end]-prefix[start-1];
             
             if(maxSum<CurrSum){
                 maxSum = CurrSum;
             }
           }
         }
         System.out.println("max sum = " + maxSum);
        }
     
    //kadane's algorithm
    public static void kadanes(int numbers[]){
      int ms=Integer.MIN_VALUE;
      int cs =0;
      for(int i=0;i<numbers.length;i++){
        cs=cs+numbers[i];
        if(cs<0){
          cs=ms;
        }
        ms=Math.max(cs,ms);
      }
      System.out.println("the max out of sum is " + ms);
    }

    //modified kadane's algorithm
    public static void modifiedkadanes(int numbers[]) {
      int ms = numbers[0]; // Initialize max sum to the first element
      int cs = numbers[0]; // Initialize current sum to the first element
  
      for (int i = 1; i < numbers.length; i++) {
          // Update current sum: take the maximum between the current element or current sum + element
          cs = Math.max(numbers[i], cs + numbers[i]);
          // Update maximum sum
          ms = Math.max(ms, cs);
      }
  
      System.out.println("The maximum sum of the subarray is " + ms);
  }
  
      
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numbers[]={-1,-2,-6,-9,-3};
        modifiedkadanes(numbers);
    } } 
    

