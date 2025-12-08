public class Tries {
   static class Node {
    Node children[] = new Node[26];
    boolean eow =  false;

    Node(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}
public static Node root = new Node(); //Root node that remains empty alwayspublic static Node root = new Node(); //Root node that remains empty always

//insertion = O(L) : L is the length of longest word
public static void  insert(String word){
    Node curr = root;
    for(int level=0; level<word.length(); level++){
        int idx = word.charAt(level) - 'a'; //eg: 't'-'a'
        if(curr.children[idx] == null){
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
    }

    curr.eow = true;
}

//searching = = O(L) : L is the length of longest word
public static boolean search(String key){
    Node curr = root;
    for(int level=0; level<key.length(); level++){
        int idx = key.charAt(level) - 'a'; //eg: 't'-'a'
        if(curr.children[idx] == null){
            return false;
        }
        curr = curr.children[idx];
    }

    return curr.eow = true;
}

//Word Break Problem = O(L)
public static boolean wordBreak(String key){
    if(key.length() == 0){
        return true;
    }
    for(int i=0; i<=key.length(); i++){
        if(search(key.substring(0,i)) && 
        wordBreak(key.substring(i))){
            return true;
        }
    }
    return false;
}

//startsWith 
public static boolean startsWith(String prefix){
    Node curr = root;
    for(int i=0; i<prefix.length(); i++){
        int idx = prefix.charAt(i) - 'a';
        if(curr.children[idx] == null){
            return false;
        }
        curr = curr.children[idx];
    }
    return true;
}

//Longest words with all prefixes
public static String ans = " ";
public static void longestWord(Node root, StringBuilder temp){
    if(root == null){
        return;
    }

    for(int i=0; i<26; i++){
//if i want ki lexicographic way mai aswer comes opposite that instead of apple apply should come then...
// for(int i =25; i>=0; i--) : just reverse the loop to jo lexicographically bada alphabet hoga wo consider hoga
        if(root.children[i] != null && root.children[i].eow == true){
            char ch = (char)(i+'a');
            temp.append(ch);
            if(temp.length() > ans.length()){
                ans = temp.toString();
            }
            longestWord(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1); //backtrack
        }
    }
}

//Count unique substrings
public static int countNodes(Node root){
    if(root == null){
        return 0;
    }

    int count = 0;
    for(int i=0; i<26; i++){
        if(root.children[i] != null){
            count += countNodes(root.children[i]);
        }
    }

    return count+1;
}

//Prefix Problem - O(L) = L is the levels in my trie = longest word only
static class node {
    node children[] = new node[26];
    boolean eow =  false;
    int freq;

    public node(){
        for(int i=0; i<children.length; i++){
            children[i] = null;
        }
        freq = 1;
    }
}

public static node Root = new node();
public static void  Insert(String word){
    node curr = Root;
    for(int i=0; i<word.length(); i++){
        int idx = word.charAt(i) - 'a'; //eg: 't'-'a'
        if(curr.children[idx] == null){
            curr.children[idx] = new node();
        } else {
            curr.children[idx].freq++;
        }
        curr = curr.children[idx];
    }

    curr.eow = true;
}

public static void findPrefix(node Root, String ans){
    if(Root == null){
        return;
    }

    if(Root.freq == 1){
        System.out.println(ans);
        return;
    }

    for(int i=0; i<Root.children.length; i++){
        if(Root.children[i] != null){
            findPrefix(Root.children[i], ans+(char)(i+'a'));
        }
    }
}

public static void main(String[] args){
    String words[] = {"the", "a", "there", "their", "a", "thee"};
    for(int i=0; i<words.length; i++){
        insert(words[i]);
    }

    System.out.println(search("thee"));
    System.out.println(search("thor"));

//Word Break Problem Prequisites
    String arr[] = {"i","sam", "like", "samsung", "mobile", "ice"};
    for(int i=0; i<arr.length; i++){
        insert(arr[i]);
    }
    String key = "ilikesamsung";
    System.out.println(wordBreak(key));

//StartWith Problem Prerequisites
   String word[] = {"apple", "app", "mango", "man", "wopman"};
   String prefix1 = "app";
   String prefix2 = "moon";

   for(int i=0; i<word.length; i++){
        insert(word[i]);
      }
      System.out.println(startsWith(prefix1));
      System.out.println(startsWith(prefix2));

//Longest word with all prefixes
    String Word[] = {"a", "banana", "app", "appl", "apply", "apple"};

    for(int i=0; i<Word.length; i++){
        insert(Word[i]);
       }
       longestWord(root, new StringBuilder(""));
       System.out.println(ans);

//Coun unique substring prerequisites
    String str = "ababa";
    for(int i=0; i<str.length(); i++){
        String suffix = str.substring(i);
        insert(suffix);
       }

       System.out.println(countNodes(root));

//Prefix problem prequisites
    String Arr[] = {"zebra", "dog", "duck", "dove"};
    for(int i=0; i<Arr.length; i++){
        Insert(Arr[i]);
       }
       Root.freq = -1;
       findPrefix(Root, "");
    } 
}
