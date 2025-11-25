import java.util.Scanner;
public  class Main {
    public static  void main(String[] args){
        String name;
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = s.nextLine();
        System.out.println("Enter your age: ");
        n = s.nextInt();
        System.out.println("Hello, " + name + "! You are " + n + " years old.");
    }
}