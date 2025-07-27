package Hometasks.hometask2207;

import java.util.Random;

/*
Если я правильно понял задание
Программа строго последовательно проверяет каждый символ строки на соответствие очередному символу маски, пропуская несовпадающие символы, но сохраняя текущую позицию в маске

Цветовая индикация для проверки (надоело считать, в процессе отладки)
Зеленый (GREEN): Первые символы стрелок (> для >>-->, < для <--<<)
Оранжевый (ORANGE): Последние символы стрелок (> для >>-->, < для <--<<)
Синий (BLUE): Символы - в середине стрелок

Два независимых прохода по строке (для каждого типа стрелок)
При нахождении символа маски - добавляется соответствующий цвет
Несовпадающие символы выводятся без цвета
 */

public class ColoredArrowCounter {
    private static final int MAX_LENGTH = 106;
    private static final char[] SYMBOLS = {'>', '<', '-'};

    // ANSI коды цветов
    private static final String GREEN = "\u001B[32m";
    private static final String ORANGE = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        String sequence = generateSequence();
        System.out.println("Исходная последовательность (" + sequence.length() + " символов):");
        System.out.println(sequence);

        // Подсчет и подсветка стрелок
        String[] coloredResults = countAndColorArrows(sequence);

        System.out.println("\nРезультаты с подсветкой:");
        System.out.println(coloredResults[0]); // >>-->
        System.out.println(coloredResults[1]); // <--<<

        System.out.println("\nИтоговые количества:");
        System.out.println("Стрелок >>-->: " + coloredResults[2]);
        System.out.println("Стрелок <--<<: " + coloredResults[3]);
        System.out.println("Всего стрелок: " + (Integer.parseInt(coloredResults[2]) + Integer.parseInt(coloredResults[3])));
    }

    private static String generateSequence() {
        Random random = new Random();
        int length = random.nextInt(MAX_LENGTH) + 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(SYMBOLS[random.nextInt(SYMBOLS.length)]);
        }
        return sb.toString();
    }

    private static String[] countAndColorArrows(String s) {
        StringBuilder rightArrowSeq = new StringBuilder();
        StringBuilder leftArrowSeq = new StringBuilder();
        int rightCount = 0;
        int leftCount = 0;

        // Подсветка >>-->
        int patternIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (patternIndex < 5 && c == ">>-->".charAt(patternIndex)) {
                String color = switch(patternIndex) {
                    case 0, 1 -> GREEN;  // >
                    case 2, 3 -> BLUE;   // -
                    case 4 -> ORANGE;    // >
                    default -> RESET;
                };
                rightArrowSeq.append(color).append(c).append(RESET);
                patternIndex++;
                if (patternIndex == 5) {
                    rightCount++;
                    patternIndex = 0;
                }
            } else {
                rightArrowSeq.append(c);
            }
        }

        // Подсветка <--<<
        patternIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (patternIndex < 5 && c == "<--<<".charAt(patternIndex)) {
                String color = switch(patternIndex) {
                    case 0 -> GREEN;     // <
                    case 1, 2 -> BLUE;   // -
                    case 3, 4 -> ORANGE; // <
                    default -> RESET;
                };
                leftArrowSeq.append(color).append(c).append(RESET);
                patternIndex++;
                if (patternIndex == 5) {
                    leftCount++;
                    patternIndex = 0;
                }
            } else {
                leftArrowSeq.append(c);
            }
        }

        return new String[] {
                ">>-->: " + rightArrowSeq.toString(),
                "<--<<: " + leftArrowSeq.toString(),
                String.valueOf(rightCount),
                String.valueOf(leftCount)
        };
    }
}
