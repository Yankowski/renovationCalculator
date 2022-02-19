package jjankowski.renovation.service.calculators;

import jjankowski.renovation.vo.Room;

import java.util.List;

public class TotalWallPaperSurfaceCalculator {

    public static int calculateTotalSurface(List<Room> rooms) {
        return List.copyOf(rooms).stream().mapToInt(Room::getSurface).sum();
    }
}
