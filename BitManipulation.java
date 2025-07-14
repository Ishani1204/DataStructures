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

    public static int ClearIthBit(int n , int i){
        int BitMask = ~(1<<i);
        return n & BitMask ;
    }

    public static void main(String[] args){
    System.out.println(ClearIthBit(10 , 1)); }
}
