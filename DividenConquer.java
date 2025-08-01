public class DividenConquer {
     //Print the array
     public static void printArr(int arr[]){
        for(int i=0 ; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
     }
    //Merge Sort
   public static void MergeSort(int arr[] , int si , int ei){
    //base case
    if(si>=ei){
        return;
    }
    //kaam
    int mid = si + (ei - si)/2;
    MergeSort(arr , si , mid);//left part
    MergeSort(arr , mid+1 , ei);//right part
    merge(arr , si , mid , ei);

   }

   public static void merge(int arr[] , int si , int mid , int ei){
    //temporary array to merge
    int temp[] = new int[ei-si+1];
    int i = si; //iterator for left part
    int j = mid+1; //iterator for right part
    int k = 0; //iterator for temp arr

    while(i<= mid && j <=ei){
        if(arr[i]<arr[j]){
            temp[k] = arr[i];
            i++; 
        } else{
            temp[k]= arr[j];
            j++;
        }
        k++;
        }
    //for second part elements jo kuchh bacha h left part main
    while(i<=mid){
        temp[k++]= arr[i++];
    }
    
    //for right part
    while(j <= ei){
        temp[k++]=arr[j++];
    }
    // copy temp to my original array
    for(k=0 , i =si ; k<temp.length; k++ , i++){
      arr[i]=temp[k];
    }
   }


//Quick sort
public static void quickSort(int arr[] , int si , int ei){
if(si>=ei){
    return;
}
//pivot = last element
int pidx = partition (arr , si , ei);
quickSort(arr, si, pidx-1); //left
quickSort(arr, pidx+1, ei); //right
}

public static int partition(int arr[] , int si , int ei){
    int pivot = arr[ei];
    int i = si-1;

    for(int j=si ; j<ei ; j++){
        if(arr[j] <= pivot){
        i++;
        //swap
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        }
    }
    // for pivot to be at right place
    i++;
    int temp = arr[i];
    arr[i]= arr[ei]; //pivot = arr[i]
    arr[ei] = temp;
    return i;

}


public static void main(String args[]){
    int arr[] = {6 , 3 , 9 , 5 , 2 , 8};
    quickSort(arr, 0, arr.length-1);
    printArr(arr);
}

}
