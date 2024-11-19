package ru.netology.javaqa.javaqamvn.oop;

public class Radio {
    private int currentVolume;
    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;
    private int maxVolume = 100;
    private int minVolume = 0;

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