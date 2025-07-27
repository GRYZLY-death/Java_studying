package Hometasks.hometask2207;

import java.util.Arrays;
import java.util.Scanner;

public class WordSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words;
        boolean isValid;

        do {
            System.out.print("Введите два слова (латинские буквы, через пробел): ");
            String input = scanner.nextLine().trim();
            words = input.split("\\s+");

            isValid = words.length == 2 &&
                    words[0].matches("[a-zA-Z]+") &&
                    words[1].matches("[a-zA-Z]+");

            if (!isValid) {
                System.out.println("Ошибка! Введите ровно два слова, используя только латинские буквы.");
                System.out.println("Пример: 'Sample Text'");
            }
        } while (!isValid);

        processAndPrintWords(words);
    }

    private static void processAndPrintWords(String[] words) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] letters = word.toLowerCase().toCharArray();
            Arrays.sort(letters);
            result.append(new String(letters)).append(" ");
        }

        System.out.println("Результат: " + result.toString().trim());
    }
}
