package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        String[] input = readInput("Day2/input.txt");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

    }

    private static String[] readInput (String filePath) {
        try {
            File inputFile = new File(filePath);
            Scanner s = new Scanner(inputFile);

            List<String> outputList = new ArrayList<String>();
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
