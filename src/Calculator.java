import  java.util.Scanner;
class Calculatorlogic {
    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public double divide(int a, int b){
        if(b == 0){
            throw  new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }
}
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculatorlogic calculator = new Calculatorlogic();
        while (true) {
            System.out.println("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.println("Enter second number: ");
            int num2 = scanner.nextInt();

            System.out.println("Enter operation (+, -, *, /): ");
            String op = scanner.next();

            switch (op) {
                case "+":
                    System.out.println("Result: " + calculator.add(num1, num2));
                    break;
                case "-":
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                    break;
                case "*":
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                    break;
                case "/":
                    try {
                        System.out.println("Result: " + calculator.divide(num1, num2));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid operation.");
                    continue;
            }
            System.out.println("Do you want to perform another calculation? (yes/no): ");
            String again = scanner.next();
            if (again.equalsIgnoreCase("no")) {
                break;

            }
        }
        scanner.close();
    }
}
