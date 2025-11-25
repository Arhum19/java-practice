import java.util.Scanner;
public class number {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number: ");
            int a = s.nextInt();
            if (a % 2 == 0) {
                System.out.println(a + " is even.");
            } else {
                System.out.println(a + " is odd.");
            }
            System.out.println("Do you want to enter another number? (yes/no): ");
            String again = s.next();
            if (again.equalsIgnoreCase("no")) {
                break;
            }
            s.close();
        }
    }
}

