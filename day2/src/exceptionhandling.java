import  java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class ExceptionDemo{
    public static  void Register(int age) throws  InvalidAgeException{
        if(age < 5 || age > 100){
            throw  new InvalidAgeException("Age must be between 5 and 100 to register.");
        } else {
            System.out.println("Registration successful!");
        }

    }
}

public  class exceptionhandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your age to register: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid age.");
                sc.next(); // clear the invalid input
                continue;
            }
            int age = sc.nextInt();
            try {
                ExceptionDemo.Register(age);
                System.out.println("Thank you for registering!");
                break;
            } catch (InvalidAgeException e) {
                System.out.println("Registration failed: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                break;
            }

        }
        sc.close();
    }

    }
