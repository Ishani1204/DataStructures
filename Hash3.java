import java.util.*;
public class Hash3{

    public static void main(String args[]){
        //creation
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(1);

        System.out.println(set);
        
        //contains()
        if(set.contains(2)){
            System.out.println("Set contains 2");
        }
        if(set.contains(3)){
            System.out.println("Set contains 3");
        }
        
        //remove()
        set.remove(2);

        //size()
        System.out.println(set.size());
        //returns 3 as answer because dupliacte values doesn't adds up to hash set

        //isEmpty()
        System.out.println(set.isEmpty());

        //HashSet iteration using Iterator()
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            
        }

        //using for each loop
        for(String val : cities){
            System.out.println(val);
        }
    }
}