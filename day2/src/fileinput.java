import java.io.*;
public class fileinput {
    public static void main(String[] args) {
        try {
            //PrintWriter pw = new PrintWriter(new FileWriter("data.txt", true));
            PrintWriter pw  = new PrintWriter("data.txt");
            pw.println("My name is Muhammad Arhum");
            pw.println("I am learning Java programming.");
            pw.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
