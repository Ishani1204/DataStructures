import java.util.PriorityQueue;
public class PQ {
//PQ in objects
    static class Student implements Comparable<Student>{
       String name;
       int rank;

       public Student(String name, int rank){
        this.name = name;
        this.rank = rank;
       }

       @Override
       public int compareTo(Student s2){
        return this.rank-s2.rank;
       }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);  //ADD : O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        //Add in Queue : 3 4 1 7
        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //PEEK : O(1)
            pq.remove();  //REMOVE : O(log n)
        }
        //After the removal from queue the elements will come out as : 1 3 4 7

        PriorityQueue<Student> s = new PriorityQueue<>(); 
        s.add(new Student("A", 4));
        s.add(new Student("B", 5));
        s.add(new Student("C", 2));
        s.add(new Student("D", 12));
        while(!pq.isEmpty()){
            System.out.println(s.peek().name + " -> "+ s.peek().rank); //PEEK : O(1)
            pq.remove();  //REMOVE : O(log n)
        }
    }
}
