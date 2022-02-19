package jjankowski.renovation.vo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Summary {
    int totalAreaOfWallPaperNeeded;
    List<Room> cubicShapeRoomsDesc;
    List<Room> repeatingRooms;

    public Summary(int totalAreaOfWallPaperNeeded, List<Room> cubicShapeRooms, List<Room> repeatingRooms) {
        this.totalAreaOfWallPaperNeeded = totalAreaOfWallPaperNeeded;
        this.cubicShapeRoomsDesc = orderDesc(cubicShapeRooms);
        this.repeatingRooms = repeatingRooms;
    }

    public int getTotalAreaOfWallPaperNeeded() {
        return totalAreaOfWallPaperNeeded;
    }

    public List<Room> getCubicShapeRoomsDesc() {
        return cubicShapeRoomsDesc;
    }

    public List<Room> getRepeatingRooms() {
        return repeatingRooms;
    }

    private List<Room> orderDesc(List<Room> cubicShapeRooms) {
        cubicShapeRooms.sort(Comparator.comparing(Room::getSurface).reversed());
        return cubicShapeRooms;
    }

    @Override
    public String toString() {
        return "Renovation Summary :\n\n " +
                "Total area of wallpaper needed = " + totalAreaOfWallPaperNeeded +
                " (square foot),\n\n " +
                "Rooms that have cubic shape in descending order of total surface :\n " + cubicShapeRoomsDesc.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",\n ")) +
                ",\n\n Repeating rooms:\n " + repeatingRooms.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",\n "));
    }
}
