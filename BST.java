import java.util.*;
public class BST {
    //Binary Search Tree : Building the tree
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    public static Node insert(Node root, int val){
        if(root == null){
          root = new Node(val);
          return root;  
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        } else {
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    //to search in a binary tree
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left, key);
        } else{
            return search(root.right, key);
        }
    }

    //print in range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1){
            printInRange(root.left, k1, k2);
        } else{
            printInRange(root.right, k1, k2);
        }
    }


    //root to leaf path
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
       if(root == null){
        return;
       }
        path.add(root.data);
       if(root.left == null && root.right == null){
        printPath(path);
       }
       printRoot2Leaf(root.left, path); 
       printRoot2Leaf(root.right, path);
       path.remove(path.size() - 1);
    }


    //Delete the node from the tree
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
        //viola
        //case 1 : leaf node
        if(root.left == null && root.right == null){
                return null;
        }
        //case 2 : single child
        if(root.left == null){
            return root.right;
        } 
        else if(root.right == null){
            return root.left;
        }
        //case 3 : both children
        Node IS = findInorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, val);
        }
        return root;
    }


    //Validate the BST
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root)
            && isValidBST(root.left, min, max);
    }


    //Mirror of BST
    public static Node CreateMirror(Node root){
       if(root == null){
        return null;
       }
       Node leftS = CreateMirror(root.left);
       Node rightS = CreateMirror(root.right);
       root.left = root.right;
       root.right = leftS;

       return root;

    }


    //Sorted array to BST - O(n)
    public static Node CreatBST(int arr[], int st, int end){
        if(st >= end){
            return null;
        }
        int mid =(st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = CreatBST(arr, st, mid-1);
        root.right = CreatBST(arr, mid+1, end);
        return root;
        
    }

    //Convert BST to balanced BST
    public static Node creatBST(ArrayList<Integer> inorder, int st, int end){
        if(st >= end){
            return null;
        }
        int mid =(st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = creatBST(inorder, st, mid-1);
        root.right = creatBST(inorder, mid+1, end);
        return root;
        
    }
    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node balanceBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();

        //sorted inorder -> balanced BST
        root = creatBST(inorder, 0, inorder.size()-1);
        return root;
    }
    

    //Size of largest BST in BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if (root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size +1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info( false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }


    //Merge 2 BSTs' - O(n+m)
    public static void GetInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public static Node mergeBSTs(Node rootA, Node rootB){
        //step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        GetInorder(rootA, arr1);

        //step 2
         ArrayList<Integer> arr2 = new ArrayList<>();
        GetInorder(rootB, arr2);

        //step 3
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            } else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }
        
        //step 4 
        return creatBST(finalArr, 0, finalArr.size() -1);
    }

    public static void main(String[] args) {
      int values[] ={8, 5, 3, 1, 4, 6, 10, 11, 14};
      Node root = null;  
      //traversing the values array and adding the values to the tree
      for(int i=0; i<values.length; i++){
        root = insert(root, values[i]);
      }
      inorder(root);
      System.out.println();

      if(search(root, 1)){
        System.out.println("found");
      } else{
        System.out.println("Not found");
      }
      printInRange(root, 5, 12);
      printRoot2Leaf(root, new ArrayList<>());

      root = delete(root, 1);
      System.out.println();

      inorder(root);
      if(isValidBST(root, null, null)){
        System.out.println("Valid");
      } else {
        System.out.println("Not valid");
      }
      root = CreateMirror(root);

      int arr[] = {3, 5, 6, 8, 10, 11, 12};
      Node root1 = CreatBST(arr, 0, arr.length-1);

      Node root2 = new Node(8);
      root2.left = new Node (6);
      root2.left.left = new Node(5);
      root2.left.left.left = new Node(3);
      root2.right = new Node(10);
      root2.right.right = new Node(11);
      root2.right.right.right = new Node(12);

      root2 = balanceBST(root2);


      Node root3 = new Node(50);
      root3.left = new Node (30);
      root3.left.left = new Node(5);
      root3.left.left.left = new Node(20);
      root3.right = new Node(60);
      root3.right.left = new Node(45);
      root3.right.right= new Node(70);
      root3.right.right.left = new Node(65);
      root3.right.right.right = new Node(80);
      
      Info info = largestBST(root2);
      System.out.println("Largest BST size = "+maxBST);

      
      Node root4 = mergeBSTs(root2, root3);
    }
}
