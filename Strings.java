import java.util.*;
public class Strings {
    //Letters Printing
public static void printletters(String str){
    for(int i =0;i<str.length();i++){
        System.out.print(str.charAt(i) + " ");
    }
    System.out.println();
}
    //Palindrome sequence
public static boolean ispalindrome(String str){
    for(int i=0;i<str.length()/2;i++)
    {
        int n = str.length();
        if(str.charAt(i) != str.charAt(n-1-i)){
            return false;
        }
    }
    return true ;
}
    //Shortest Path To reach
public static double isshortestpath(String path){
    int x=0,y=0;
for(int i=0;i<path.length();i++){
     char dir = path.charAt(i);
     //south
     if(dir=='S'){
         y--;
     }
     //north
     else if (dir=='N'){
        y++;
     }
     //west
     else if(dir=='W'){
        x--;
     } else if(dir=='E'){x++;}
}
float X2=x*x;
float Y2=y*y;
return Math.sqrt(X2 + Y2);
}
    //Substring
public static String substring(String str , int si ,int ei){
    String substr=""; //empty chhor diya
    for(int i=0;i<ei;i++){
        substr+=str.charAt(i);
    }
    return substr;
}
    //to uppercase the first letter of the word in a sentence
    public static String touppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    //to compress
    public static String compress(String str){
     String newStr=" ";
     for(int i=0;i<str.length();i++){
        Integer count=1;
        while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
            count++;
            i++;
        }
        newStr += str.charAt(i);
        if(count>1){
            newStr += count.toString();
        }
     }
     return newStr;
    }
    public static void main(String[] args){
        String str = "aaaabbcc";
        System.out.println(compress(str));
    }
}