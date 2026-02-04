import java.util.*;
public class Hash1{
    public static void main(String args[]){
        //HashMap creation
        HashMap <String, Integer> hm = new HashMap <>();
        //insertion - O(1)
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("USA", 180);

        System.out.println(hm);

        //get - O(1)
        hm.get("India"); //return value of the key
        hm.get("Indonesia"); //return null bcz no such key is there
        int population = hm.get("India");
        System.out.println(population);

        //containsKey - O(1)
        System.out.println(hm.containsKey("India")); //return true
        System.out.println(hm.containsKey("Indonesia")); //return null

        //remove - O(1)
        System.out.println(hm.remove("China")); //returns the value associated with key "China" i.e 100
        System.out.println();

        //size - O(1)
        System.out.println(hm.size());

        //Is Empty
        hm.clear(); //removes all pairs
        System.out.println(hm.isEmpty());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Indonesia", 6);
        map.put("Nepal", 5);

        //iterate
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for(String k : keys){
            System.out.println("keys="+k+ ",value="+map.get(k));
        }
    }
}