// javac day1.java
// java day1

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.lang.Math;

public class day2 {
   public static void main(String[] args) {
        Path path = Paths.get("day2-data.txt").toAbsolutePath();
        File file = path.toFile();
        System.out.println("Looking for: " + file.getAbsolutePath());

        try {
            Scanner sc = new Scanner(file);

            long total = 0;


            String[] text = sc.nextLine().split(",");

            for (int i = 0; i < text.length; i++) {
                String line = text[i].strip();
                System.out.println(line);

                String[] parts = line.split("-");
                String start = parts[0];
                String end = parts[1];
                System.out.println(start + " " + end);
                for (long j = Long.parseLong(start); j <=  Long.parseLong(end); j++) {
                    long num = (long) j;
                    int half = Math.floorDiv(Long.toString(num).length(), 2);
                    String first = Long.toString(num).substring(0, half);
                    String second = Long.toString(num).substring(half, Long.toString(num).length());
                    if (first.equals(second)) {
                        total += j;
                    }
                }
            }
            System.out.println(total);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file at " + path);
        }
   }
}