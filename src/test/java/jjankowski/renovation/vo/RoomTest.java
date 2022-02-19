package jjankowski.renovation.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void shouldCreateObjectFromThreeElementsArray() {
        // when
        Room room = Room.fromStringArray(new String[]{"1","2","3"});

        // then
        assertEquals(1, room.getLength());
        assertEquals(2, room.getWidth());
        assertEquals(3, room.getHeight());
    }

    @Test
    void shouldThrowExceptionWhenArrayIsIncorrect() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Room.fromStringArray(new String[]{"1","2"}));
    }

    @Test
    void shouldThrowExceptionWhenArrayDoNotContainNumbers() {
        // expect
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> Room.fromStringArray(new String[]{"a","f","d"}));
    }

    @Test
    void shouldCalculateSurface() {
        //expect
        assertEquals(24, Room.fromStringArray(new String[]{"1","2","3"}).getSurface());
        assertEquals(23, Room.fromStringArray(new String[]{"1","1","5"}).getSurface());
        assertEquals(108, Room.fromStringArray(new String[]{"2","4","7"}).getSurface());
        assertEquals(98, Room.fromStringArray(new String[]{"8","3","2"}).getSurface());
    }

    @Test
    void shouldIndicateIfRoomIsInCubicShape() {
        //expect
        assertFalse(Room.fromStringArray(new String[]{"1", "2", "3"}).isCubicShape());
        assertFalse(Room.fromStringArray(new String[]{"2", "4", "7"}).isCubicShape());
        assertFalse(Room.fromStringArray(new String[]{"8", "3", "2"}).isCubicShape());
        assertTrue(Room.fromStringArray(new String[]{"2", "2", "2"}).isCubicShape());
        assertTrue(Room.fromStringArray(new String[]{"3", "3", "3"}).isCubicShape());
        assertTrue(Room.fromStringArray(new String[]{"4", "4", "4"}).isCubicShape());
    }
}