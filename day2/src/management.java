// java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class management {
    private static final String DATA_FILE = "students.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = loadStudentsFromFile(DATA_FILE);

        while (true) {
            System.out.println("\nStudent Info System:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choice = getValidIntInput("Enter your choice (1-5): ", 1, 5);

            if (choice == 1) {
                addStudent(students);
                saveStudentsToFile(students, DATA_FILE);
            } else if (choice == 2) {
                viewStudent(students);
            } else if (choice == 3) {
                updateStudent(students);
                saveStudentsToFile(students, DATA_FILE);
            } else if (choice == 4) {
                deleteStudent(students);
                saveStudentsToFile(students, DATA_FILE);
            } else {
                System.out.println("Exiting Student Info System. Goodbye!");
                saveStudentsToFile(students, DATA_FILE);
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

    private static void updateStudent(ArrayList<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("No students available to update.");
            return;
        }
        System.out.println("Available students:");
        for (Student st : students) {
            System.out.println("- " + st.getName());
        }
        System.out.println("Enter a Student name to update: ");
        String nameToUpdate = getNonEmptyString();

        Student target = null;
        for (Student st : students) {
            if (st.getName().equalsIgnoreCase(nameToUpdate)) {
                target = st;
                break;
            }
        }

        if (target == null) {
            System.out.println("No student found with the name: " + nameToUpdate);
            return;
        }

        System.out.println("Student found. Enter what you want to update");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Education");
        System.out.println("4. Gender");
        System.out.println("5. Grade");
        int updateChoice = getValidIntInput("Enter your choice (1-5): ", 1, 5);
        switch (updateChoice) {
            case 1:
                System.out.println("Enter new name: ");
                String newName = getNonEmptyString();
                target.setName(newName);
                break;
            case 2:
                int newAge = getValidIntInput("Enter new age (5-100): ", 5, 100);
                target.setAge(newAge);
                break;
            case 3:
                System.out.println("Enter new education: ");
                String newEducation = getNonEmptyString();
                target.setEducation(newEducation);
                break;
            case 4:
                System.out.println("Enter new gender (Male/Female/Other): ");
                String newGender = getNonEmptyString();
                target.setGender(newGender);
                break;
            case 5:
                System.out.println("Enter new grade (A-F): ");
                char newGrade = getValidGrade();
                target.setGrade(newGrade);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available to delete.");
            return;
        }
        System.out.println("Enter Student name to delete: ");
        String nameToDelete = getNonEmptyString();
        Iterator<Student> it = students.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            Student st = it.next();
            if (st.getName().equalsIgnoreCase(nameToDelete)) {
                it.remove();
                removed = true;
                System.out.println("Student " + nameToDelete + " deleted successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("No student found with the name: " + nameToDelete);
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

    private static ArrayList<Student> loadStudentsFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        if (!Files.exists(Paths.get(filename))) return students;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Optional<Student> s = Student.fromCSV(line);
                s.ifPresent(students::add);
            }
        } catch (IOException e) {
            System.out.println("Failed to load students: " + e.getMessage());
        }
        return students;
    }

    private static void saveStudentsToFile(ArrayList<Student> students, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save students: " + e.getMessage());
        }
    }
}
