import java.util.*;
public class Hash2{
    static class HashMap<K, V> {

        private Integer getOrDefault(int i, int i0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        //generic : this K, V is generic because here the datatype of the key is not fixed
        //so we assign the generic datatype.
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n basically nodes
        private int N;
        private LinkedList<Node> buckets[]; //N = bucket.length

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N; //abs converts the negative value to positive
        }

        private int SearchLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di =0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            //nodes -> add in bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){ //O(lambda) - O(1)
            int bi = hashFunction(key);
            int di = SearchLL(key, bi); //di = data index and searchLL search ki kya wo node exist krta h ya nhi
            
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                //2.0 is the just assumed threshold value, basically value of k taken as example
                 rehash();
            }
        }

        public boolean containsKey(K key){
            int bi= hashFunction(key);
            int di= SearchLL(key, bi);

            if(di != -1){
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = SearchLL(key, bi); //di = data index and searchLL search ki kya wo node exist krta h ya nhi
            
            if(di != -1){
                Node node = buckets[bi].remove(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = SearchLL(key, bi); //di = data index and searchLL search ki kya wo node exist krta h ya nhi
            
            if(di != -1){
                Node node = buckets[bi].get(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n==0;
        }
    }
    //Valid Anagram
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(i, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1){
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) -1);
            }
        } else {
            return false;
        } 
    }
    return map.isEmpty();
}

//Itinerary for tickets - O(n)
public static String getStart(HashMap<String, String> tickets){
    HashMap<String, String> revMap = new HashMap<>();

    for(String key : tickets.keySet()) {
        revMap.put(tickets.get(key), key);
    }

    for(String key : tickets.keySet()){
        if(!revMap.containsKey(key)){
            return key; //starting point
        }
    }
    return null;
}
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.print(key);
        }

        //LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        System.out.println(lhm);

        //Tree Map
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("USA", 50);
        System.out.println(tm);

        //Majority Element
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            // if(map.containsKey(arr[i])) {
            //     map.put(arr[i], map.get(arr[i])+ 1);
            // } else {
            //     map.put(arr[i], 1);
            // }

            //More optimized
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> keySet = (Set<Integer>) map.keySet();
        for(Integer key : keySet) {
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }

        String s = "race";
        String t = "care";

        //linked HashSet
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida"); 

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");

    //Count distict elements - O(n)
    int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<num.length; i++){
        set.add(num[i]);
        }

        System.out.println("ans = " + set.size());

    //Largest Subarray Sum 0 - O(n)
    int Arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
    HashMap<Integer, Integer> Map = new HashMap<>();

    //sum, idx
    int sum = 0; 
    int len = 0;

    for(int j=0; j<Arr.length; j++){
        sum += arr[j];
        if(map.containsKey(sum)){
            len = Math.max(len, j-map.get(sum)); //map.get(sum) = i basically in the hashmap
        } else {
            map.put(sum, j);
            }
        }
        System.out.println("Largest subarray with sum as 0 => " + len);

        //Subarray sum equal to K - O(n)
        int Num[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> SA = new HashMap<>();
        //sum, count
        map.put(0, 1);

        int Sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++){
            Sum += arr[j];
            if(map.containsKey(Sum-k)){
                ans += map.get(Sum-k);
            }
            map.put(Sum, map.getOrDefault(Sum, 0)+1);
        }

        System.out.println(ans);

    //Find itinerary for tickets
    HashMap<String, String> tickets = new HashMap<>();
    tickets.put("Chennai", "Bengaluru");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");

    String Start = getStart(tickets);
    System.out.println(Start);
    for(String key : tickets.keySet()){
        System.out.println(" -> " + tickets.get(Start));
        Start = tickets.get(Start);
        }
        System.out.println();

    //Union and Intersection of sets - O(m+n)
    int arr1[] = {7, 3, 9};
    int arr2[] = {6, 3, 9, 2, 9, 4};
    HashSet<Integer> Set = new HashSet<>();
    //union
        for(int i=0; i<arr1.length; i++){
        set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
    System.out.println("Union = " + set.size());

    //Intersection
    set.clear();
        for(int i=0; i<arr1.length; i++){
        set.add(arr1[i]);
        }

        int count = 0 ;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
    System.out.println("Intersection = " + count);
    }
}