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


    //diameter of the tree = O(n^2) : APPROACH 1
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int ldiam = diameter(root.left);
        int rdiam = diameter(root.right);
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        int selfdiam = lh + rh + 1;
        return Math.max(selfdiam, Math.max(ldiam, rdiam));
    }

    
    //diameter of the tree = O(n) : APPROACH 2
    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0, 0);
        }
       Info leftInfo = diameter2(root.left);
       Info rightInfo = diameter2(root.right);

       int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
       int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

       return new Info(diam, ht);
    }

    //Subtree of another tree
    public static boolean isTdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(isTdentical(node.left, subRoot.left)){
            return false;
        } 
        if(isTdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root.data == subRoot.data){
            if(isTdentical (root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }

    //Top view of a tree
    static class InfoOfTree{
        Node node;
        int hd;

        public InfoOfTree(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }

    }
    public static void Topview(Node root){
        //level order traversal
        Queue<InfoOfTree> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new InfoOfTree(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            InfoOfTree curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            }
            if(!map.containsKey(curr.hd)){
                //first time my hd is occuring
                map.put(curr.hd, curr.node);
            }
            if(curr.node.left != null){
                q.add(new InfoOfTree(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new InfoOfTree(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
   public static void main(String args[]){
   int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1,};
/*     
    *            1
               /   \
              2     3
            /  \     \
           4    5     6
*/
   BinaryTree tree = new BinaryTree();
   Node root = tree.buildTree(nodes);
   System.out.println(root.data);
   tree.preorder(root);
   tree.inorder(root);
   tree.postorder(root);
   tree.levelOrder(root);
   System.out.println(count(root));
   System.out.println(diameter2(root).diam);

// /*                 2
//                   / \
//                  4   5
// */

   Node subRoot = new Node(2);
   subRoot.left = new Node(4);
   subRoot.right = new Node(5);
   System.out.println(isSubtree(root, subRoot));
   Topview(root);
   } 
}
