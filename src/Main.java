import java.util.Scanner;
public  class Main {
    public static  void main(String[] args){
        String name;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = s.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}