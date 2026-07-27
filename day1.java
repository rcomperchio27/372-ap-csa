// javac day1.java
// java day1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {
   public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new File("day1-test-java.txt").getAbsolutePath());
        // File file = new File("day1-test.txt");
        // Scanner sc = new Scanner(file);

        // while (sc.hasNextLine()) {
        //     String line = sc.nextLine();
        //     System.out.println(line);
        // }
        // sc.close();
   }
}