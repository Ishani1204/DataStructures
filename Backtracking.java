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
   //sudoku part
   //is safe function for sudoku
   public static boolean isSafe(int sudoku[][], int row , int col, int digit){
   //column condition
   for(int i=0 ; i<=8; i++){
    if(sudoku[i][col] == digit){
        return false;
    }
   }

   //row
   for(int j=0 ; j<=8; j++){
    if(sudoku[row][j] == digit){
        return false;
    }
   }

   //grid
   int sr = (row/3)*3;
   int sc = (col/3)*3;

   for(int i=sr; i<sr+3;i++){
    for(int j=sc; j<sc+3; j++){
        if(sudoku[i][j] == digit){
            return false;
        }
    }
  }
  return true;
}
    //print sudoku
public static void printSudoku(int sudoku[][]){
    for(int i=0 ; i<9; i++){
        for(int j=0 ; j<9 ;j++){
            System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
    }
}
    //Sudoku code
    public static boolean sudokuSolver(int sudoku[][] , int row , int col){
        //base case
    if(row == 9 ){
        return true;
    } 
    
        //recursion
        int nextRow = row , nextCol= col+1;
        if(col+1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }
    //if the digits are placed well before then we have to call for another situation
    if(sudoku[row][col] != 0){
        return sudokuSolver(sudoku , nextRow , nextCol);
    }
    //for placing the elements
        for(int digit=1; digit<=9 ; digit++){
        if(isSafe(sudoku , row , col , digit)){
            sudoku[row][col]= digit;
            if(sudokuSolver(sudoku , nextRow , nextCol)){
                //soln exists
                return true;
            }
            sudoku[row][col] = 0;
        }
    }
 return false;    
}
 //n queens
    public static void nQueens(char board[][] , int row){
        // base case
        if(row == board.length){
            //printBoard(board);
            count++;
            return;
        }
        // try placing queen in each column of current row
        for(int j =0 ; j<board.length ; j++){
            if(isSafe(board , row , j)){
                board[row][j] = 'Q'; // place queen
                nQueens(board, row+1); // recurse to next row
                board[row][j] = 'x' ; // backtrack
            }
        }
    }

    // check if safe to place queen
    public static boolean isSafe(char board[][] , int row , int col){
        // vertical up
        for(int i=row-1; i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // diagonal left up
        for(int i=row-1 , j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // diagonal right up
        for(int i=row-1, j=col+1 ; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    // print board in box format
    public static void printBoard(char board[][]){
        System.out.println("Solution:");
        for(int i =0 ; i<board.length; i++){
            for(int j=0 ; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
    //to print the total number of solutions
    static int count = 0; //We used static kyunki recurrence call by value hota h to har baar stack call main value add hoti jaayegi
                          //isliye we created a static variable

    public static void main(String args[]){
        System.out.println("------Chess Board Solutions------");
        int n = 5;
        char board[][] = new char[n][n];
        // initialize board
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                board[i][j] = 'x' ;
            }
        }
        nQueens(board, 0);
        System.out.println("Total number of ways are : " + count);
    }
}
