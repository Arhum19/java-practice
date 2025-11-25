import java.util.ArrayList;
import java.util.Collections;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        Collections.addAll(fruits, "Apple", "Banana", "Orange", "Mango");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        fruits.remove("Banana");
        System.out.println("\nAfter removing Banana:\n");
        for (String fruit : fruits) {
            System.out.println(fruit);

        }
    }
}
