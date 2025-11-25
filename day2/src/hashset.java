import java.util.Collections;
import java.util.HashSet;

public class hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, "Apple", "Banana", "Orange", "Apple");
        for (String fruit : set) {
            System.out.println(fruit);

        }
    }
}