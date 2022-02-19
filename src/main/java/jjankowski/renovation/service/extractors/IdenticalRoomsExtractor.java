package jjankowski.renovation.service.extractors;

import jjankowski.renovation.vo.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IdenticalRoomsExtractor {

    public static List<Room> getIdenticalRooms(List<Room> rooms) {
        HashMap<Room, Integer> allRooms = new HashMap<>();
        List.copyOf(rooms).forEach(room -> allRooms.put(room, allRooms.getOrDefault(room, 1) + 1));
        return allRooms
                .entrySet()
                .stream()
                .filter(roomCount -> roomCount.getValue() > 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
