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
    public static void main(String args[]){
        int n = 3;
        System.out.println(sum(n));
    }
}
