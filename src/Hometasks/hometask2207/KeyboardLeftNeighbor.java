package Hometasks.hometask2207;

import java.util.HashMap;
import java.util.Scanner;

public class KeyboardLeftNeighbor {
    public static void main(String[] args) {
        // Инициализация словаря с соответствиями букв
        HashMap<Character, Character> leftNeighbor = new HashMap<>();

        // Заполнение словаря (QWERTY-раскладка + особые случаи)
        leftNeighbor.put('q', 'm');
        leftNeighbor.put('w', 'q');
        leftNeighbor.put('e', 'w');
        leftNeighbor.put('r', 'e');
        leftNeighbor.put('t', 'r');
        leftNeighbor.put('y', 't');
        leftNeighbor.put('u', 'y');
        leftNeighbor.put('i', 'u');
        leftNeighbor.put('o', 'i');
        leftNeighbor.put('p', 'o');
        leftNeighbor.put('a', 'p');
        leftNeighbor.put('s', 'a');
        leftNeighbor.put('d', 's');
        leftNeighbor.put('f', 'd');
        leftNeighbor.put('g', 'f');
        leftNeighbor.put('h', 'g');
        leftNeighbor.put('j', 'h');
        leftNeighbor.put('k', 'j');
        leftNeighbor.put('l', 'z');
        leftNeighbor.put('z', 'l');
        leftNeighbor.put('x', 'z');
        leftNeighbor.put('c', 'x');
        leftNeighbor.put('v', 'c');
        leftNeighbor.put('b', 'v');
        leftNeighbor.put('n', 'b');
        leftNeighbor.put('m', 'q');

        Scanner scanner = new Scanner(System.in);
        char inputChar;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите одну латинскую букву: ");
            String input = scanner.nextLine();

            // Проверка длины ввода
            if (input.length() != 1) {
                System.out.println("Ошибка: нужно ввести ровно один символ");
                continue;
            }

            inputChar = input.charAt(0);

            // Проверка, что символ является буквой
            if (!Character.isLetter(inputChar)) {
                System.out.println("Ошибка: введен не буквенный символ");
                continue;
            }

            // Преобразование в строчную букву
            inputChar = Character.toLowerCase(inputChar);

            // Проверка, что буква латинская
            if (!leftNeighbor.containsKey(inputChar)) {
                System.out.println("Ошибка: введена не латинская буква");
                continue;
            }

            validInput = true;

            // Получение и вывод результата
            char result = leftNeighbor.get(inputChar);
            System.out.println("Слева от '" + inputChar + "' находится буква '" + result + "'");
        }

        scanner.close();
    }
}
