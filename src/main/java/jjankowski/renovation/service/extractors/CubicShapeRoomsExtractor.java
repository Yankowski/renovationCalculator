package jjankowski.renovation.service.extractors;

import jjankowski.renovation.vo.Room;

import java.util.List;
import java.util.stream.Collectors;

public class CubicShapeRoomsExtractor {

    public static List<Room> filterCubicRooms(List<Room> rooms) {
        return List.copyOf(rooms).stream().filter(Room::isCubicShape).collect(Collectors.toList());
    }
}
