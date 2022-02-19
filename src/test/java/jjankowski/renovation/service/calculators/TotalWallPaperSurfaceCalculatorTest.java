package jjankowski.renovation.service.calculators;

import jjankowski.renovation.vo.Room;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalWallPaperSurfaceCalculatorTest {

    @Test
    void shouldCalculateTotalSurface() {
        // given
        List<Room> roomList = Arrays.asList(
                new Room(1, 2, 3),
                new Room(1, 1, 5),
                new Room(2, 4, 7),
                new Room(8, 3, 2)
        );

        // when
        int result = TotalWallPaperSurfaceCalculator.calculateTotalSurface(roomList);

        // then
        assertEquals(253, result);
    }
}