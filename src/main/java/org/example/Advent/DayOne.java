package org.example.Advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayOne {
    public static void startDayOne() {
        String filePath = "src/main/resources/thenums.txt";
        try {
            int totalSum = sumNumbersInFile(filePath);
            System.out.println("Answer to day one is: " + totalSum);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    private static int sumNumbersInFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                sum += processLine(line);
            }
            return sum;
        }
    }

    private static int processLine(String line) {
        String digits = line.replaceAll("[^\\d]", "");
        if (!digits.isEmpty()) {
            int number = Integer.parseInt(digits);
            return calculateModifiedNumber(number);
        }
        return 0;
    }

    private static int calculateModifiedNumber(int number) {
        String s = Integer.toString(number);
        int firstDigit = s.charAt(0) - '0';
        int lastDigit = s.charAt(s.length() - 1) - '0';
        return Integer.parseInt("" + firstDigit + lastDigit);
    }
}
