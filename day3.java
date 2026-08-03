// javac day1.java
// java day1

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

public class day3 {
   public static void main(String[] args) {
        Path path = Paths.get("day3-data.txt").toAbsolutePath();
        File file = path.toFile();
        System.out.println("Looking for: " + file.getAbsolutePath());

        try {
            Scanner sc = new Scanner(file);

            BigInteger total = BigInteger.ZERO;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().strip();
                System.out.println(line);
                
                BigInteger bank = new BigInteger(line);

                int index = -1;
                List<BigInteger> max = new ArrayList<>(Arrays.asList(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO));

                System.out.println(max.get(0));
                System.out.println(bank);

                for (int i = 0; i < 12; i++) {
                    for (int j = index + 1; j < bank.toString().length() -11 + i; j++) {
                        if (new BigInteger(String.valueOf(bank.toString().charAt(j))).compareTo(new BigInteger(String.valueOf(max.get(i).toString().charAt(0)))) > 0) {
                            max.set(i, new BigInteger(String.valueOf(bank.toString().charAt(j))));
                            index = j;
                        }
                    }
                }

                String joltage = "";
                for (int i = 0; i< 12; i++) {
                    joltage += String.valueOf(max.get(i));
                }
                total = total.add(new BigInteger(joltage));
            }


            System.out.println(total);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file at " + path);
        }
   }
}