package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        String[] input = readInput("Day3/input.txt");
        int output = 0;
        for (String s :
             input) {
            String[] halves = {s.substring(0, s.length()/2), s.substring(s.length()/2)};
            for (int i = 0; i < halves[0].length(); i++) {
                if (halves[1].contains(Character.toString(halves[0].charAt(i)))) {
                    output += letToNum(halves[0].charAt(i));
                    break;
                }
            }
        }
        System.out.println(output);
    }

    private static int letToNum (char c) {
        int value = c - 'a' + 1;
        if(Character.isUpperCase(c)){
            return value + 31 + 27;
        }
        return value;
    }

    private static String[] readInput (String filePath) {
        try {
            File inputFile = new File(filePath);
            Scanner s = new Scanner(inputFile);

            List<String> outputList = new ArrayList<>();
            while (s.hasNextLine()) {
                outputList.add(s.nextLine());
            }
            String[] output = outputList.toArray(new String[0]);

            s.close();
            return output;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
