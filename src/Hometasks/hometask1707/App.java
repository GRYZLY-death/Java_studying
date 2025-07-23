package Hometasks.hometask1707;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Создание телевизоров
        Television tv1 = new Television("Samsung", 55);
        Television tv2 = new Television("LG", 43);
        Television tv3 = new Television();

        // Демонстрация работы с tv1
        System.out.println("\n=== Телевизор 1 ===");
        tv1.powerOn();
        System.out.println("Бренд: " + tv1.getBrand());
        System.out.println("Размер: " + tv1.getScreenSize() + "\"");
        tv1.setCurrentChannel(5);
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.channelUp();
        tv1.displayInfo();
        System.out.println("Текущий статус: " + (tv1.isOn() ? "Вкл" : "Выкл"));
        tv1.volumeDown();
        tv1.powerOff();

        // Демонстрация работы с tv2
        System.out.println("\n=== Телевизор 2 ===");
        tv2.powerOn();
        tv2.setVolume(75);
        System.out.println("Текущая громкость: " + tv2.getVolume());
        tv2.setCurrentChannel(10);
        System.out.println("Текущий канал: " + tv2.getCurrentChannel());
        tv2.channelDown();
        tv2.displayInfo();

        // Демонстрация работы с tv3
        System.out.println("\n=== Телевизор 3 ===");
        System.out.println("Исходные данные:");
        System.out.println("Бренд: " + tv3.getBrand());
        System.out.println("Размер: " + tv3.getScreenSize());
        tv3.setBrand("Sony");
        tv3.setScreenSize(65);
        tv3.powerOn();
        tv3.displayInfo();

        // Улучшенный ввод параметров телевизора
        System.out.println("\n=== Пользовательский телевизор ===");

        // Ввод бренда
        System.out.print("Введите бренд: ");
        String userBrand = scanner.nextLine();

        // Ввод размера экрана с строгой проверкой на числа
        int userSize = 0;
        while (true) {
            System.out.print("Введите размер экрана (0-200 дюймов): ");
            String input = scanner.nextLine();

            try {
                userSize = Integer.parseInt(input);
                if (userSize >= 0 && userSize <= 200) {
                    break;
                } else {
                    System.out.println("Ошибка! Допустимый диапазон: 0-200 дюймов.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите только цифры.");
            }
        }

        Television userTv = new Television(userBrand, userSize);
        userTv.powerOn();
        System.out.println("\nСоздан телевизор:");
        System.out.println("Бренд: " + userTv.getBrand());
        System.out.println("Размер экрана: " + userTv.getScreenSize() + " дюймов");
        userTv.displayInfo();

        // Телевизор со случайными параметрами
        System.out.println("\n=== Случайный телевизор ===");
        String[] brands = {"Panasonic", "Toshiba", "Philips", "Xiaomi"};
        Television randomTv = new Television(
                brands[random.nextInt(brands.length)],
                20 + random.nextInt(60)
        );
        randomTv.powerOn();
        randomTv.setCurrentChannel(1 + random.nextInt(100));
        randomTv.setVolume(random.nextInt(101));
        randomTv.displayInfo();

        scanner.close();
    }
}