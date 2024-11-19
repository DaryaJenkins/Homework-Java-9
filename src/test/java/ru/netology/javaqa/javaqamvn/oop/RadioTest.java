package ru.netology.javaqa.javaqamvn.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource({
            "0,1", "1,2", "8,9", "9,0"
    })
    public void switchToNextStation(int initialStation, int expected) {
        radio.setCurrentStation(initialStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9", "1,0", "8,7", "9,8"
    })
    public void switchToPreviousStation(int initialStation, int expected) {
        radio.setCurrentStation(initialStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "1,1", "8,8", "9,9", "10,0"
    })
    public void testBoundariesStations(int setStation, int expected) {
        radio.setCurrentStation(setStation);
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1", "1,2", "99,100", "100,100"
    })
    public void testIncreaseVolume(int initialVolume, int expected) {
        radio.setCurrentVolume(initialVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "1,0", "99,98", "100,99"
    })
    public void testDecreaseVolume(int initialVolume, int expected) {
        radio.setCurrentVolume(initialVolume);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}