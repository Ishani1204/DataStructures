package Practice;

public class arrays {
    //duplicate values
    public static boolean duplicate(int num[]){
        for(int i=0; i<num.length;i++){
            for(int j=i+1 ; j<num.length ; j++){
                if (num[i]==num[j]){
                    return true;
                } 
            }
        }
        return false;
    }
     // Correct Kadanes Algo
     // This is correct kadanes algo that works for both set of only negative numbers and both negative and posotive number
    public static int maxSubArray(int[] nums) {
        int ms = nums[0];
        int cs = nums[0] ;
        for(int i= 1 ; i<nums.length ; i++){
            int num = nums[i];
           cs = Math.max(num, cs+num);
           ms = Math.max(ms , cs);
    }
    return ms;}


    //Printing subarrays
     public static void subarrays(int num[]){
    for(int i=0;i<num.length;i++){
        for(int j=i;j<num.length;j++){
            for(int k=i ; k<=j ; k++){
                if(((num[i] != num[j])&& (num[j]!=num[k]) && (num[k]!= num[i]))&& (num[i]+num[j]+num[k]==0)){
                 System.out.println(num[k] + " ");
                }
            }
        }
        System.out.println();
    }
    
}
    
    
    
    
    public  static void main(String args[]){
     int num[] = {-1, 0, 1, 2, -1, -4};
     subarrays(num);
    }
}
