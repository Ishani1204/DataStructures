import java.util.*;
public class GreedyAlgo2 {
    public static void main(String args[]){
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W= 50;
        //2d array to sort the ratio in descending or ascending order
        //0th colu => idx; 1st col stores => ratio
        double ratio[][] = new double[val.length][2];
        
        for(int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //ascending order sort 
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
       
        int capacity = W;
        int finalVal = 0;
        for(int i= ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                //include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else{
                //include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
    System.out.print("Final Value " + finalVal);
    }
}
