import java.util.Scanner;
import java.util.Random;

// Класс Телевизор
class Television {
    // Приватные поля класса
    private String brand;
    private int screenSize; // в дюймах
    private int currentChannel;
    private int volume;
    private boolean isOn;

    // Конструкторы
    public Television(String brand, int screenSize) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.currentChannel = 1;
        this.volume = 50;
        this.isOn = false;
    }

    public Television() {
        this("Unknown", 32); // значения по умолчанию
    }

    // Свойства (геттеры и сеттеры)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        if (screenSize > 0) {
            this.screenSize = screenSize;
        }
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int channel) {
        if (isOn && channel > 0) {
            this.currentChannel = channel;
            System.out.println("Канал изменен на " + channel);
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (isOn && volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Громкость установлена на " + volume);
        }
    }

    public boolean isOn() {
        return isOn;
    }

    // Методы
    public void powerOn() {
        isOn = true;
        System.out.println("Телевизор " + brand + " включен");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("Телевизор " + brand + " выключен");
    }

    public void channelUp() {
        if (isOn) {
            currentChannel++;
            System.out.println("Канал увеличен до " + currentChannel);
        }
    }

    public void channelDown() {
        if (isOn && currentChannel > 1) {
            currentChannel--;
            System.out.println("Канал уменьшен до " + currentChannel);
        }
    }

    public void volumeUp() {
        if (isOn && volume < 100) {
            volume++;
            System.out.println("Громкость увеличена до " + volume);
        }
    }

    public void volumeDown() {
        if (isOn && volume > 0) {
            volume--;
            System.out.println("Громкость уменьшена до " + volume);
        }
    }

    public void displayInfo() {
        System.out.println("\nИнформация о телевизоре:");
        System.out.println("Бренд: " + brand);
        System.out.println("Размер экрана: " + screenSize + " дюймов");
        System.out.println("Состояние: " + (isOn ? "Включен" : "Выключен"));
        if (isOn) {
            System.out.println("Текущий канал: " + currentChannel);
            System.out.println("Громкость: " + volume);
        }
    }
}

// Класс приложения
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Создание телевизоров с разными параметрами
        Television tv1 = new Television("Samsung", 55);
        Television tv2 = new Television("LG", 43);
        Television tv3 = new Television(); // с параметрами по умолчанию

        // Демонстрация работы с tv1
        System.out.println("\nРабота с телевизором 1:");
        tv1.powerOn();
        tv1.setCurrentChannel(5);
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.channelUp();
        tv1.displayInfo();
        tv1.powerOff();

        // Демонстрация работы с tv2
        System.out.println("\nРабота с телевизором 2:");
        tv2.powerOn();
        tv2.setVolume(75);
        tv2.setCurrentChannel(10);
        tv2.channelDown();
        tv2.displayInfo();

        // Демонстрация работы с tv3 (с параметрами по умолчанию)
        System.out.println("\nРабота с телевизором 3:");
        tv3.displayInfo();
        tv3.setBrand("Sony");
        tv3.setScreenSize(65);
        tv3.powerOn();
        tv3.displayInfo();

        // Дополнительно: создание телевизора с параметрами с клавиатуры
        System.out.println("\nСоздание телевизора с параметрами с клавиатуры:");
        System.out.print("Введите бренд телевизора: ");
        String userBrand = scanner.nextLine();
        System.out.print("Введите размер экрана (дюймы): ");
        int userScreenSize = scanner.nextInt();

        Television userTv = new Television(userBrand, userScreenSize);
        userTv.powerOn();
        userTv.displayInfo();

        // Дополнительно: создание телевизора со случайными параметрами
        System.out.println("\nСоздание телевизора со случайными параметрами:");
        String[] brands = {"Panasonic", "Toshiba", "Philips", "Sharp", "Xiaomi"};
        String randomBrand = brands[random.nextInt(brands.length)];
        int randomSize = 20 + random.nextInt(60); // от 20 до 80 дюймов

        Television randomTv = new Television(randomBrand, randomSize);
        randomTv.powerOn();
        randomTv.setCurrentChannel(1 + random.nextInt(100)); // канал от 1 до 100
        randomTv.setVolume(random.nextInt(101)); // громкость от 0 до 100
        randomTv.displayInfo();

        scanner.close();
    }
}