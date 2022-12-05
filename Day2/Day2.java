package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A X - Rock     = 1
// B Y - Paper    = 2
// C Z - Scissors = 3

//       Loss     = 0
//       Draw     = 3
//       Win      = 6

public class Day2 {
    public static void main(String[] args) {
        part2();
    }

    private static void part1 () {
        String[] input = readInput("Day2/input.txt");

        int totalScore = 0;
        char rawOpponent;
        char rawMe;
        int opponent;
        int me;

        for (String s : input) {
            rawOpponent = s.charAt(0);
            rawMe = s.charAt(2);

            if (rawOpponent == 'A') {
                opponent = 1;
            } else if (rawOpponent == 'B') {
                opponent = 2;
            } else {
                opponent = 3;
            }

            if (rawMe == 'X') {
                me = 1;
            } else if (rawMe == 'Y') {
                me = 2;
            } else {
                me = 3;
            }

            if (opponent - me == 0) {
                totalScore += 3 + me;
            } else if (opponent - me == -1 || opponent - me == 2) {
                totalScore += 6 + me;
            } else {
                totalScore += me;
            }
        }
        System.out.println(totalScore);
    }

    private static void part2 () {
        String[] input = readInput("Day2/input.txt");

        int totalScore = 0;
        char rawOpponent;
        char rawResult;
        int opponent;
        int result;

        for (String s : input) {
            rawOpponent = s.charAt(0);
            rawResult = s.charAt(2);

            if (rawOpponent == 'A') {
                opponent = 1;
            } else if (rawOpponent == 'B') {
                opponent = 2;
            } else {
                opponent = 3;
            }

            if (rawResult == 'X') {
                totalScore += (opponent + 1) % 3 + 1;
            } else if (rawResult == 'Y') {
                totalScore += opponent + 3;
            } else {
                totalScore += opponent % 3 + 1 + 6;
            }
        }
        System.out.println(totalScore);
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
