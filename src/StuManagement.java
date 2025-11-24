import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Student {
    private int age;
    private String name;
    private String education;
    private String gender;
    private char grade;

    Student(int age, String name, char grade, String education, String gender) {
        this.age = age;
        this.name = name;
        this.education = education;
        this.grade = grade;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void info() {
        System.out.println("----- Student Info -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Education: " + education);
        System.out.println("Gender: " + gender);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }
}

public class StuManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("\nStudent Info System:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students by name");
            System.out.println("3. Exit");

            int choice = getValidIntInput("Enter your choice (1-3): ", 1, 3);

            if (choice == 1) {
                addStudent(students);
            } else if (choice == 2) {
                viewStudent(students);
            } else if (choice == 3) {
                System.out.println("Exiting Student Info System.");
                scanner.close();
                break;
            }
        }
    }

    private static void addStudent(ArrayList<Student> students) {
        System.out.println("Enter Student Name: ");
        String name = getNonEmptyString();

        int age = getValidIntInput("Enter Student Age (5-100): ", 5, 100);

        System.out.println("Enter Student Education: ");
        String education = getNonEmptyString();

        System.out.println("Enter Student Gender (Male/Female/Other): ");
        String gender = getNonEmptyString();

        System.out.println("Enter Student Grade (A-F): ");
        char grade = getValidGrade();

        students.add(new Student(age, name, grade, education, gender));
        System.out.println("Student added successfully!");
    }

    private static void viewStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("Available students:");
        for (Student st : students) {
            System.out.println("- " + st.getName());
        }
        System.out.println("Enter name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Student st : students) {
            if (st.getName().equalsIgnoreCase(searchName)) {
                st.info();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the name: " + searchName);
        }
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static String getNonEmptyString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again: ");
        }
    }

    private static char getValidGrade() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'F') {
                return input.charAt(0);
            }
            System.out.println("Invalid grade. Please enter a letter between A and F: ");
        }
    }
}
