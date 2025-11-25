import java.util.HashMap;
import java.util.Map;
public class wordcout {
    public static void main(String[] args) {
        String str = "My name is Muhammad Arhum";
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : str.split(" ")){
            word = word.toLowerCase();
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
