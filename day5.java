import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class day5 {
   public static void main(String[] args) {
        Path path = Paths.get("day5-data.txt").toAbsolutePath();
        File file = path.toFile();
        System.out.println("Looking for: " + file.getAbsolutePath());

        try {
            Scanner sc = new Scanner(file);

            Long total = 0L;
            Boolean blank = true;
            ArrayList<String> ranges = new ArrayList<String>();
            ArrayList<Long> nums = new ArrayList<Long>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().strip();
                if (line.equals("")) {
                    blank = false;
                }
                if (blank) {
                    ranges.add(line);
                } else if (!line.equals("") && !blank) {
                    nums.add(Long.parseLong(line));
                }    
            }

            for (int i = 0; i < nums.size(); i++) {
                for (int j = 0; j < ranges.size(); j++) {
                    long min = Long.parseLong(ranges.get(j).split("-")[0]);
                    long max = Long.parseLong(ranges.get(j).split("-")[1]);
                    if (nums.get(i) >= min && nums.get(i) <= max) {
                        total++;
                        break;
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