// javac day1.java
// java day1

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class day1 {
   public static void main(String[] args) {
        Path path = Paths.get("day1-data.txt").toAbsolutePath();
        File file = path.toFile();
        System.out.println("Looking for: " + file.getAbsolutePath());

        try {
            int num = 50;
            int total = 0;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
               String line = sc.nextLine();

               System.out.println(line);
               String direction = String.valueOf(line.charAt(0));
               String amount = line.substring(1);
               System.out.println("Direction: " + direction + ", Amount: " + amount);

               if (direction.equals("L")) { 
                  num -= Integer.parseInt(amount);
               } else if (direction.equals("R")) {
                  num += Integer.parseInt(amount);
               }
                
               num = num % 100;
               if (num == 0) {
                  total += 1;
               }
               System.out.println(total);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file at " + path);
        }
   }
}