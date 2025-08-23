public class Backtracking {
    //Change array
   public static void changeArr(int arr[] , int i , int val){
   //base case
    if(i==arr.length){
        printArr(arr);
        return;
    }

   //recusrion
   arr[i]=val;
   changeArr(arr, i+1, val+1); //fxn call step
   arr[i]=arr[i]-2; //backtracking
   }

   public static void printArr(int arr[]){
    for(int i=0 ; i<arr.length ; i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
   }

   //find subsets
   public static void findSubsets(String str , String ans , int i){
    //base case
     if(i== str.length()){
        if(ans.length()== 0){
            System.out.println("null");
        } else {
        System.out.println(ans);}
        return ;
     }

    //recursion
    //yes choice
    findSubsets(str, ans+str.charAt(i), i+1);
    //no choice
    findSubsets(str, ans, i+1);
   }

   //Permutations code
   public static void findPermuations(String str , String ans){
    //base case
    if (str.length() == 0){
        System.out.println(ans);
        return ;
    }

    //recursion
    for(int i=0 ; i<str.length() ; i++){
        char curr = str.charAt(i);
        String Newstr = str.substring(0 , i) + str.substring(i+1);
        findPermuations(Newstr, ans+curr);
    }
   }



    public static void main(String args[]){
        String str = "abc";
        findPermuations(str, " ");
    }
}