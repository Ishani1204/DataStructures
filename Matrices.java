import java.util.*;
public class Matrices {
    public static boolean search(int matrix[][] , int key){
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    System.out.println("The key found at index " + "(" + i +" , "+ j + ")");
                    return true;
                }
            }
        }
        System.out.print("Key not found"); 
    return false;
    }
    public static void main(String arg[]){
        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int n = matrix.length , m = matrix[0].length ;
        //input
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        //output
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the value of key to be searched");
        int key = sc.nextInt();
    
        search(matrix , key);

    }
}
