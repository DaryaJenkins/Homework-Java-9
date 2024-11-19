package ru.netology.javaqa.javaqamvn.oop;

public class Radio {
    private int maxStation;
    private int minStation = 0;
    private int currentStation = minStation;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int currentVolume;

    public Radio (int size) {
        if (size < 1) {
            size = 1;
        }
        maxStation = size - 1;
    }

    public Radio () {
        this(10);
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void nextStation() {
        currentStation = (currentStation == maxStation) ? minStation : currentStation + 1;
    }

    public void prevStation() {
        currentStation = (currentStation == minStation) ? maxStation : currentStation - 1;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation > maxStation) {
            return;
        }
        if (newCurrentStation < minStation) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int initialVolume) {
        for (int i = 0; i < initialVolume; i++) {
            increaseVolume();
        }
    }
}