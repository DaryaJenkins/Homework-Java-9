package ru.netology.javaqa.javaqamvn.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "0,1", "1,2", "8,9", "9,0"
    })
    public void switchToNextStationDefault(int initialStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(initialStation);
        radio.nextStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1", "1,2", "2,0"
    })
    public void switchToNextStationCustom(int initialStation, int expected) {
        Radio radio = new Radio(3);
        radio.setCurrentStation(initialStation);
        radio.nextStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0,9", "1,0", "8,7", "9,8"
    })
    public void switchToPreviousStationDefault(int initialStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(initialStation);
        radio.prevStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "10,9", "9,8", "1,0", "0,10"
    })
    public void switchToPreviousStationCustom(int initialStation, int expected) {
        Radio radio = new Radio(11);
        radio.setCurrentStation(initialStation);
        radio.prevStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "1,1", "8,8", "9,9", "10,0"
    })
    public void testBoundariesDefault(int setStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(setStation);
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "1,1", "6,6", "7,0"
    })
    public void testBoundariesCustom(int setStation, int expected) {
        Radio radio = new Radio(7);
        radio.setCurrentStation(setStation);
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "1,0"
    })
    public void testIfSizeIsZero(int setStation, int expected) {
        Radio radio = new Radio(0);
        radio.setCurrentStation(setStation);
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1", "1,2", "99,100", "100,100"
    })
    public void testIncreaseVolume(int initialVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(initialVolume);
        radio.increaseVolume();
        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "1,0", "99,98", "100,99"
    })
    public void testDecreaseVolume(int initialVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(initialVolume);
        radio.decreaseVolume();
        Assertions.assertEquals(expected, radio.getCurrentVolume());
    }
}