  class Person {
    protected  String name;
    public Person(String name){
        this.name = name;
    }
    public void speak(){
        System.out.println("Hello, my name is " + name + ".");
    }
}
 class Students extends Person {
    private int studentId;
    public Students(String name, int studentId){
        super(name);
        this.studentId = studentId;
    }
    @Override
    public void speak(){
        System.out.println("Hello, my name is " + name + " and my student ID is " + studentId + ".");
    }
}

 class Teacher extends Person{
    protected  String subject;
    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }
    @Override
    public void speak(){
        System.out.println("Hello, my name is " + name + " and I teach " + subject + ".");
    }
}
public class inheritancebasic {
    public static void main(String[] args){
        Person person = new Person("Alice");
        person.speak();
        Person obj = new Students("Bob", 12345);
        obj.speak();
        Person obj2 = new Teacher("David", "History");
        obj2.speak();
//        Teacher teacher = new Teacher("Charlie", "Mathematics");
//        teacher.speak();
   }
}