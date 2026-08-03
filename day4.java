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

public class day4 {
   public static void main(String[] args) {
        Path path = Paths.get("day4-data.txt").toAbsolutePath();
        File file = path.toFile();
        System.out.println("Looking for: " + file.getAbsolutePath());

        try {
            Scanner sc = new Scanner(file);

            Long total = 0L;

            ArrayList<String> grid = new ArrayList<String>();
            ArrayList<ArrayList<String>> remove = new ArrayList<ArrayList<String>>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                grid.add(line);
            }

            for (int i = 0; i < grid.size(); i++) {
                String currentrow = grid.get(i);
                for (int j = 0; j < currentrow.length(); j++) {
                    int proximity = 0;
                    char current = currentrow.charAt(j);
                    if (current == '@') {
                        if (j != 0) {
                            if (currentrow.charAt(j - 1) == '@') {
                                proximity++;
                            }
                        }
                        if (j != currentrow.length() - 1) {
                            if (currentrow.charAt(j + 1) == '@') {
                                proximity++;
                            }
                        }
                        if (i != 0) {
                            if (grid.get(i - 1).charAt(j) == '@') {
                                proximity++;
                            }
                        }
                        if (i != grid.size() - 1) {
                            if (grid.get(i + 1).charAt(j) == '@') {
                                proximity++;
                            }
                        }
                        if (i != 0 && j != 0) {
                            if (grid.get(i - 1).charAt(j - 1) == '@') {
                                proximity++;
                            }
                        }
                        if (i != grid.size() - 1 && j != 0) {
                            if (grid.get(i + 1).charAt(j - 1) == '@') {
                                proximity++;
                            }
                        }
                        if (i != grid.size() - 1 && j != currentrow.length() - 1) {
                            if (grid.get(i + 1).charAt(j + 1) == '@') {
                                proximity++;
                            }
                        }
                        if (i != 0 && j != currentrow.length() - 1) {
                            if (grid.get(i - 1).charAt(j + 1) == '@') {
                                proximity++;
                            }
                        }
                        if (proximity < 4) {
                            total++;
                            ArrayList<String> listpair = new ArrayList<String>(2);
                            listpair.add(Integer.toString(i));
                            listpair.add(Integer.toString(j));
                            remove.add(listpair);
                        }
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