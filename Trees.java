import java.util.*;
public class Trees {
   //build tree preorder - O(n)
   static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
   
   static class BinaryTree {
    static int idx = -1;
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
    //preorder traversal- O(n)
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder traversal - O(n)
    public static void inorder(Node root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //post order traversal - O(n)
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    //Level order traversal
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else{
                   q.add(null); 
                } 
            }   else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }   
    //count the nodes
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int lcount = count(root.left);
        int rcount = count(root.right);
        int treecount = lcount + rcount + 1;

        return treecount;
    }

    //sum of nodes
    public static int sumOfnode(Node root){
        if(root == null){
            return 0;
        }
        int lsum = sumOfnode(root.left);
        int rsum = sumOfnode(root.right);
        int treesum = lsum + rsum + root.data;
        return treesum;
    }

    //height of the tree
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int height = Math.max(lh, rh)+1;

        return height;
    }
   public static void main(String args[]){
   int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1,};
   BinaryTree tree = new BinaryTree();
   Node root = tree.buildTree(nodes);
   System.out.println(root.data);
   tree.preorder(root);
   tree.inorder(root);
   tree.postorder(root);
   tree.levelOrder(root);
   System.out.println(count(root));
   } 
}
