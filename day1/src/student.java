public class student {
    int age;
    String name;
    char grade;

    student(int age, String name, char grade){
        this.age = age;
        this.name = name;
        this.grade = grade;
    }
    void displayInfo(){
        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }

    public static  void main(String[] args){
        student student1 = new student(20, "Arhum", 'A');
        student1.displayInfo();
    }
}
