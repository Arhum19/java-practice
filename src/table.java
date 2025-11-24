import  java.util.Scanner;
public class table {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number to Print Table");
            int a = s.nextInt();
            System.out.println("Table of " + a + " is:");
            for (int i = 1; i <= 10; i++) {
                System.out.println(a + " x " + i + " = " + (a * i));
            }
            System.out.println("Do you want to print another table? (yes/no): ");
            String again = s.next();
            if (again.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}

