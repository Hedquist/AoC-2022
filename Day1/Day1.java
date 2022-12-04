package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("Day1/input.txt");
            Scanner s = new Scanner(inputFile);
            int temp = 0;
            int[] maxArray = new int[3];
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (!data.equals("")) {
                    temp += Integer.parseInt(data);
                } else {
                    for (int i = 0; i < maxArray.length; i++) {
                        if (temp > maxArray[i] && maxArray[i] <= Arrays.stream(maxArray).min().getAsInt()) {
                            maxArray[i] = temp;
                            break;
                        }
                    }
                    temp = 0;
                }
            }
            System.out.println(Arrays.stream(maxArray).sum());
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
