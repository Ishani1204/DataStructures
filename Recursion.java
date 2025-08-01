public class Recursion {
//Printing number in decreasing order
public static void printDec(int n){
    if (n== 1){
        System.out.print(n);
        return;
    }
    System.out.print(n+ " ");
    printDec(n-1);
}
//Printing number in increasing order
public static void printInc(int n){
    if(n==10){
        System.out.print(n);
        return;
    }
    System.out.print(n+ " ");
     printInc(n+1);
}
//Printing factorial of n
public static int fact(int n){
    if(n==0){
        return 1;
    }
    int fnm1 = fact(n-1);
    int fn = n * fact(n-1);
    return fn;
}
//sum of n natural numbers
public static int sum(int n){
    if(n==1){
        return 1;
    }
    int Snm1 = sum(n-1);
    int Sn = n + sum(n-1);
    return Sn;
}
//fibonacci numbers
public static int Fib(int n){
 if(n==0 || n==1){
    return n;
 }
 int fnm1 = Fib(n-1);
 int fnm2 = Fib(n-2);
 int fn = fnm1 + fnm2 ;
 return fn;
}
//sorted array
public static boolean isSorted(int arr[] , int i){
    if(i== arr.length-1){
        return true ;
    }
    if (arr[i]>arr[i+1])
    {return false;}

    return isSorted(arr , i+1);
}
//First occurence
public static int FirstOccurence(int arr[] , int key , int i){
    if(i==arr.length-1){
        return -1;
    }
    if(arr[i]==key){
        return i;
    }
    return FirstOccurence(arr, key, i+1);
}//last occurence
public static int lastOccurence(int arr[] , int key , int i){
    if(i == arr.length-1){
        return -1;
    }
    int isFound = lastOccurence(arr, key, i+1);
    if(isFound == -1 && arr[i] == key){
        return i;
    }
    return isFound;
}
//power x raised to n
public static int power(int x , int n){
   if(n==0){
    return 1 ;
   }
    //int xnm1 = power(x ,n-1);
    //int xn = x * xnm1;
    //return xn;
  return x*power(x , n-1);
}
//Optimized code for this power function
public static int optimizedPower(int a , int n){ // here TC = O(n) only
    if(n==0){
        return 1 ;
    }
    int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n/2);
    //n is odd
    if(n % 2 != 0){
        halfPowerSq = a * halfPowerSq;
    }
    return halfPowerSq;
}
//more optimized to O(log n) time complexity 
// we save the value of recusive function in a variable 
//instead of calling it again.
public static int optimizedPowermore(int a , int n){ 
    if(n==0){
        return 1 ;
    }
    int halfPower = optimizedPowermore(a, n/2);
    int halfPowerSq = halfPower * halfPower;
    //n is odd
    if(n % 2 != 0){
        halfPowerSq = a * halfPowerSq;
    }
    return halfPowerSq;
}
//Tiling Problem
public static int tilingProblem(int n){
    //base case
    if(n==0 || n==1){
        return 1;
    }
    //kaam
    //vertical choice
    int fnm1 = tilingProblem(n-1);

    //horizontal choice
    int fnm2 = tilingProblem(n-2);

    int totWays = fnm1 + fnm2 ;
    return totWays;
} 
//Duplicate in strings
public static void removeDuplicates(String str , int idx , StringBuilder newStr , boolean map[]){
    //base case
    if(idx == str.length()-1){
        System.out.println(newStr);
        return;
    }

    //kaam
    char currChar = str.charAt(idx);
    if(map[currChar-'a']== true){
        //duplicate
        removeDuplicates(str, idx+1, newStr, map);
    }else {
        map[currChar - 'a'] = true;
        removeDuplicates(str, idx+1, newStr.append(currChar), map);
    }
}
//Friends Pairs
public static int friendsPairing(int n){
    //Base Case
    if(n==1 || n==2){
        return n;
    }
    //choice
    //single
    int fnm1 = friendsPairing(n-1);

    //pair
    int fnm2 = friendsPairing(n-2);
    int pairWays = (n-1)* fnm2 ;

    //totways
    int totways = fnm1 + pairWays;
    return totways;
}
//binary strings
public static void PrintBinStrings(int n , int lastPlace , String str){
     //Base case
     if(n==0){
        System.out.println(str);
        return ; 
    }
     //kaam
     //if (lastPlace==0) {
        //sit 0 on chair n
       // PrintBinStrings(n-1 , 0, str.append("0"));
        //PrintBinStrings(n-1 , 0, str.append("1"));
    //} else {
       // PrintBinStrings(n-1 , 0, str.append("0"));
    //}//better way to write
    PrintBinStrings(n-1 , 0 , str+"0");
    if(lastPlace==0){
        PrintBinStrings(n-1 , 1, str+"1");
    }
}
    public static void main(String args[]){
       PrintBinStrings(3, 0, "");
    }
}
