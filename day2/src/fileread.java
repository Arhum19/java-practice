import  java.io.*;
public class fileread {
    public static void main(String[] args) {
        try{
        BufferedReader bf = new BufferedReader(new FileReader("data.txt"));
        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
        bf.close();
    }catch (Exception e){
            System.out.println("Errror" + e.getMessage());
        }
}
}
