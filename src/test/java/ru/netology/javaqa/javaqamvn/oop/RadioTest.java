package ru.netology.javaqa.javaqamvn.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void switchToNextStation() {
        radio.setCurrentStation(9);
        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void switchToPreviousStation() {
        radio.setCurrentStation(0);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "1,1", "8,8", "9,9", "10,0"
    })
    public void testBoundariesStations(int setCurrentStation, int expected) {
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }
}