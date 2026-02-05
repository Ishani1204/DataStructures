import java.util.*;
public class Array {
    //Function to update the marks //
    public static void update(int marks[]){
        //Now this loop is very important because here we are traversing the array
       //Yahan hum loop chala rhe h from 0 index till the length of array like
       //suppose array is of size of 3 then loop will work from index 0 to 2 
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
           //int start=i;
         for(int j=i;j<numbers.length;j++){
           //int end=j;
           CurrSum=0;
           for(int k=i;k<=j;k++){
   
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
             //int start=i;
           for(int j=i;j<numbers.length;j++){
             //int end=j;
             CurrSum= i==0 ? prefix[j] : prefix[j]-prefix[i-1];
        //means :  variable = if ki condition ? if ka print(statement 1) or (:) else ka print(statement 2)
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

  //Trapping Rainwater - BRUTE FORCE O(n^2)
    public static int TrappedRainwater (int height[]){
      int n = height.length;
      int ans = 0;

      for(int i =0; i<=n; i++){
        int left_max = height[i];
        //find the maximaum of the left
      for(int j = i-1; j>=0; j++){
        left_max = Math.max(left_max, height[j]);
      }

      int right_max = height[i];

       //find the maximum of the right
       for(int j = i+1; j<n; j++){
        right_max = Math.max(right_max, height[j]);
       }

       ans += Math.min(left_max, right_max) - height[i];
    }

    return ans;
  }
  
  //Trapping Rainwater BETTER APPROACH-O(n)
  public static int Trappedrainwater(int height[]){
    int n = height.length;
    if (n == 0) {
      return 0;
  }


  int[] left_max = new int[n];
  left_max[0] = height[0];


  // Fill left_max array
  for (int i = 1; i < n; i++) {
      left_max[i] = Math.max(left_max[i - 1], height[i]);
  }


  int[] right_max = new int[n];
  right_max[n - 1] = height[n - 1];


  // Fill right_max array
  for (int j = n - 2; j >= 0; j--) {
      right_max[j] = Math.max(right_max[j + 1], height[j]);
  }


  int ans = 0;


  // Calculate trapped water
  for (int i = 1; i < n - 1; i++) {
      ans += Math.min(left_max[i], right_max[i]) - height[i];
  }
  return ans;
  }

  //Trapped Rainwater - OPTIMZED APPROACH -O(1)
  public static int trappedrainwater(int height[]){
    int n = height.length;
      
       int ans = 0;
       int lmax = height[0];  // Maximum height on the left
       int rmax = height[n - 1];  // Maximum height on the right
       int low = 1;  // Pointer from the left
       int high = n - 2;  // Pointer from the right


       while (low <= high) {
           lmax = Math.max(lmax, height[low]);
           rmax = Math.max(rmax, height[high]);


           if (lmax < rmax) {
               ans += lmax - height[low];
               low++;
           } else {
               ans += rmax - height[high];
               high--;
           }
       }
       return ans;
  }
      
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numbers[]={1,-2,6,-1,3};
        maxSubarraySum1(numbers);

        int height[] = {4, 2, 0, 3, 2, 5};
        System.out.println(TrappedRainwater(height));
    } } 
    

