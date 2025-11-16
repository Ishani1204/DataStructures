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

    //kth level - O(n)
    public static void KLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    //Least Common Ancestor = approach 1 : O(n)
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if(foundleft || foundright){
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        //least common ancestor
        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        //last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }

    //least common ancestor : approach 2
    public static Node lca2(Node root, int n1, int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        //leftlca = val rightlca = null
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        return root;
    }


    //minimum distance between two nodes = O(n)
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        } else if(leftDist == -1){
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(root, n1);
        int dist2 = lcaDist(root, n2);

        return dist1 + dist2;
    }


    //Kth ancestor of the node
    public static int KthAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }


    //Transfrom to Sum Tree
    public static int Transfrom(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = Transfrom(root.left);
        int rightChild = Transfrom(root.right);
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    } 
   public static void main(String args[]){
   int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1,};
/*     
    *     1
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

 /*       2
         / \
        4   5
 */

   Node subRoot = new Node(2);
   subRoot.left = new Node(4);
   subRoot.right = new Node(5);
   System.out.println(isSubtree(root, subRoot));
   Topview(root);

/*        1
         / \
        2   3
       / \ / \
      4  5 6  7
     
*/
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    int k =2;
    KLevel(root1, 1, k);

    int n1 = 4, n2 = 5;
    System.out.println(lca(root1, n1, n2).data);
    System.out.println(minDist(root1, n1, n2));
    System.out.println(KthAncestor(root1, n2, k));
    Transfrom(root1);
   } 
}
