package Hometasks.hometask1707;

public class Television {
    private String brand;
    private int screenSize;
    private int currentChannel;
    private int volume;
    private boolean isOn;

    public Television(String brand, int screenSize) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.currentChannel = 1;
        this.volume = 50;
        this.isOn = false;
    }

    public Television() {
        this("Unknown", 32);
    }

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