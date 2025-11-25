// java
import java.util.Optional;

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

    public int getAge() { return age; }
    public String getEducation() { return education; }
    public String getGender() { return gender; }
    public char getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEducation(String education) { this.education = education; }
    public void setGender(String gender) { this.gender = gender; }
    public void setGrade(char grade) { this.grade = grade; }

    public void info() {
        System.out.println("----- Student Info -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Education: " + education);
        System.out.println("Gender: " + gender);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }

    // CSV format: name|age|grade|education|gender
    public String toCSV() {
        return escape(name) + "|" + age + "|" + grade + "|" + escape(education) + "|" + escape(gender);
    }

    public static Optional<Student> fromCSV(String line) {
        if (line == null || line.isBlank()) return Optional.empty();
        String[] parts = line.split("\\|", -1);
        if (parts.length != 5) return Optional.empty();
        try {
            String name = unescape(parts[0]);
            int age = Integer.parseInt(parts[1]);
            char grade = parts[2].isEmpty() ? 'F' : parts[2].charAt(0);
            String education = unescape(parts[3]);
            String gender = unescape(parts[4]);
            return Optional.of(new Student(age, name, grade, education, gender));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static String escape(String s) {
        return s == null ? "" : s.replace("|", "\\|");
    }

    private static String unescape(String s) {
        return s == null ? "" : s.replace("\\|", "|");
    }
}
