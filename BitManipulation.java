import java.util.*;
public class BitManipulation {

    public static void OddorEven(int n){
        int BitMask = 1 ;
        if((n & BitMask) == 0){
         // even number
         System.out.println("Even number");
        } else
        { System.out.println("Odd number");}
    }

    public static int GetIthBit(int n , int i){
        int Bitmask = 1<<i;
        if((n & Bitmask)== 0){
         return 0 ;} else {return 1 ;}
    }
    public static int SetIthBit(int n , int i){
    int BitMask = 1<<i;
    return n | BitMask ;
    }

    public static int ClearIBit(int n , int i){
        int BitMask = ~(1<<i);
        return n & BitMask ;
    }
    
    public static int clearIBitsInRange(int n , int i , int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
    }

    public static boolean checkpowerofTwo(int n){
        if((n&(n-1))==0){
            return true;
        }
        return false;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n&1) !=0){
                count++;
            }
          n=n>>1;
        }
        return count ;
    }

    public static int fastExpo(int a , int n){
        int ans =1 ;
        while(n>0){
            if((n&1)!=0){
                ans = ans *a;
            }
            a = a*a;
            n = n>>1;}
        return ans ;
    }

    public static void main(String[] args){
    System.out.println(fastExpo(3 , 5)); }
}
