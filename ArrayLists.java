import java.util.ArrayList;
import java.util.Collections;
 public class ArrayLists{

    public static void swap(ArrayList<Integer> list , int idx1 , int idx2){
    int temp = list.get(idx1);
    list.set(idx1, list.get(idx2));
    list.set(idx2, temp);

    }

    public static int storeWater(ArrayList<Integer> height){
        //brute force = O(n)
        int maxWater = 0 ;
        for(int i= 0; i<height.size(); i++){
          for(int j=i+1; j<height.size(); j++){
            int ht = Math.min(height.get(i), height.get(j));
            int width = j-i;
            int currWater = ht * width;
            maxWater = Math.max(maxWater , currWater);
          }
        }
        return maxWater;
    }

    public static int storeTheWater(ArrayList<Integer> height){
        int maxTheWater = 0;
        int lp =0;
        int rp = height.size()-1;

        while(lp < rp){
            //calculate the area
            int ht = Math.min(height.get(lp) , height.get(rp));
            int width = rp-lp;
            int currTheWater = ht * width ;
            maxTheWater = Math.max(maxTheWater ,currTheWater );
            //update the ptr
            if(height.get(lp) < height.get(rp)){
                lp++;
            } else {
                rp--;
            }
        }
     return maxTheWater;
    }

    public static boolean pairSum1(ArrayList<Integer> listD , int target){
        int lp = 0;
        int rp = listD.size() - 1;

        while(lp!=rp){
            //case 1
            if(listD.get(lp) + listD.get(rp) == target){
                return true;
            }

            //case 2
            if(listD.get(lp) + listD.get(rp) < target){
                lp++ ;
            } else { 
            // case 3 
            rp--;    
        }
    }
    return false;
}

    public static boolean pairSum2(ArrayList<Integer> list5 , int targetSum){
        int bp = -1 ; //bp=breaking point of sorted array
        int n = list5.size();
        for(int i=0 ; i<list5.size();i++){
            if(list5.get(i) > list5.get(i+1)){ //breaking point
                bp = i;
                break;
            }
        }

        int lp = bp+1; //smallest
        int rp = bp; //largest

        while(lp != rp){
            //case 1
            if(list5.get(lp) + list5.get(rp) ==  targetSum){
                return true;
            }

            //case 2
            if(list5.get(lp) + list5.get(rp) < targetSum){
                lp = (lp+1) % n;
            } else {
                //case 3
                rp = (n+rp-1)% n;
            }

        }
        return false;
    }
    public static void main(String args[]){
    //ArrayList syntax
    //-> ArrayList<datatype/class of datatype> = "new" keyword ArrayList()
    
        ArrayList<Integer> list =  new ArrayList<>(); //integer datatype
        ArrayList<String>  list1 = new ArrayList<>(); //string datatype
        
    //add operation - O(1)
        list.add(10); //list arraylist ka variable usme humne add function 
                     //ko call kiya aur dot operator se value ko fretch and add kiya
        list.add(2); 
        list.add(3);
        list.add(14);
        list.add(25);
    System.out.println(list);    

    //get operation - O(1)
    int element = list.get(2);
    System.out.println(element);

    //remove element - O(n)
    list.remove(2);
    System.out.println(list);

    //set element - O(n)
    list.set(1,15);
    System.out.println(list);

    //contains _ O(n)
    System.out.println(list.contains(1));
    System.out.println(list.contains(11));

    //directly adding on the index - O(n)
    list.add(1 , 9);

    //size of arraylist
    System.out.println(list.size());

    //print the arraylist
    for(int i=0 ; i<list.size() ; i++){
        System.out.print(list.get(i) + " ");
    }
    System.out.println();

    //print reverse of the arraylist - O(n)
    for(int i=list.size()-1 ; i>=0 ; i--){
        System.out.print(list.get(i)+" ");
    }
    System.out.println();

    //maximum element in arraylist - O(n)
    int max = Integer.MIN_VALUE;
    for(int i=0 ; i<list.size() ; i++){
        //if(max < list.get(i)){
            //max = list.get(i);
        //}
        max = Math.max(max , list.get(i));
    }
    System.out.println("Maximum Element = " + max);

    //swap 2 numbers
    int idx1 = 1 , idx2 = 3; //values of index
    System.out.println(list);
    swap(list, idx1 , idx2);
    System.out.println(list);

    //sorting an arraylist
    Collections.sort(list);//ascending order
    System.out.println(list);
    
    //descending order
    Collections.sort(list , Collections.reverseOrder());
    System.out.println(list);  //descending order ke liye 
                               //we have that comparator function logic
    
    //Multi dimensionl Arraylist
    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(11); list3.add(22);
    mainList.add(list3);

    ArrayList<Integer> list4 = new ArrayList<>();
    list4.add(33) ; list4.add(44);
    mainList.add(list4);
    
    for(int i=0 ; i<mainList.size(); i++)//this loop main list se baically other list ke references and elements nikalne ke liye
    {
        ArrayList<Integer> currList = mainList.get(i); // elements store karne ke liye
        for(int j=0 ; j<currList.size(); j++){
            System.out.print(currList.get(j) + " ");
        }
        System.out.println();
    }
        System.out.println(mainList);

     ArrayList<ArrayList<Integer>> mainList1 = new ArrayList<>();
    ArrayList<Integer> listA = new ArrayList<>();
    ArrayList<Integer> listB = new ArrayList<>();
    ArrayList<Integer> listC = new ArrayList<>();

    for(int i=1 ;i<=5 ; i++){
        listA.add(i*1); // 1 2 3 4 5
        listB.add(i*2); //2 4 6 8 10
        listC.add(i*3); //3 6 9 12 15 

    }
    mainList1.add(listA);
    mainList1.add(listB);
    mainList1.add(listC);

    System.out.println(mainList1);

    //nested loops chalana h to get the lements out of the main list
    for(int i=0 ; i<mainList1.size(); i++)//this loop main list se baically other list ke references and elements nikalne ke liye
    {
        ArrayList<Integer> currList1 = mainList1.get(i); // elements store karne ke liye
        for(int j=0 ; j<currList1.size(); j++){
            System.out.print(currList1.get(j) + " ");
        }
        System.out.println();
    }

    //Container with most water problem
    // a) brute force
    ArrayList<Integer> height = new ArrayList<>();
    //1, 8, 6, 2, 5, 4, 8, 3, 7
    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);
    
    System.out.println(storeWater(height));

    //b) 2 pointer approach - O(n)
    System.out.println(storeTheWater(height));

    //pair sum in a sorted arraylist (2 pointer approach)
    ArrayList<Integer> listD = new ArrayList<>();
    //1, 2, 3, 4, 5, 6
    listD.add(1);
    listD.add(2);
    listD.add(3);
    listD.add(4);
    listD.add(5);
    listD.add(6);
    int target = 5;
    System.out.println(pairSum1(listD,target));

    //pair sum2 in a sorted and rotated array - O(n)
    ArrayList <Integer> list5 = new ArrayList<>();
    //11, 15, 6, 8, 9, 10
    list5.add(11);
    list5.add(15);
    list5.add(6);
    list5.add(8);
    list5.add(9);
    list5.add(10);
    int targetSum = 16;
    System.out.println(pairSum2(list5, targetSum));
    
}
   
 }