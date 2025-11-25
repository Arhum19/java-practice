import  java.util.*;

class Personcomp implements Comparable<Personcomp>{
    String name;
    int age;

    Personcomp(String name, int age){
        this.name = name;
        this.age = age;
    }
    public  int compareTo(Personcomp other){
        return this.age - other.age;
    }
    public  String toString(){
        return this.name + " (" + this.age + ")";
    }
}
class Namecomp implements  Comparator<Personcomp>{
    public int compare(Personcomp a, Personcomp b){
        return a.name.compareTo(b.name);
    }
}

public class iterators {
    public static void main(String[] args) {
        ArrayList<Personcomp> people = new ArrayList<>();
        people.add(new Personcomp("Zara", 30));
        people.add(new Personcomp("Alo", 25));
        people.add(new Personcomp("Warda", 35));

        Collections.sort(people); // uses Personcomp.compareTo (age)
        System.out.println("People sorted by age:");
        for (Personcomp person : people) {
            System.out.println(person);
        }

        Collections.sort(people, new Namecomp()); // uses Comparator (name)
        System.out.println("\nSorted by names:");
        for (Personcomp person : people) {
            System.out.println(person);
        }
    }
}

