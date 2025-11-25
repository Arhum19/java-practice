import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(Map.of(
                "Sara", 23,
                "Ali", 42,
                "Talha", 45
        ));
        System.out.println("Sara marks are: " + map.get("Sara"));
        map.put("Ayesha", 30);
        System.out.println("\nAfter adding Ayesha:\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}