package jjankowski.renovation.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Room {
    private int length;
    private int width;
    private int height;
    private int surface;
    private boolean isCubicShape;

    public Room(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.surface = calculateSurface(length, width, height);
        this.isCubicShape = isCubicShape(length, width, height);
    }

    public static Room fromStringArray(String[] parsedElements) {
        if (parsedElements.length == 3) {
            return new Room(Integer.parseInt(parsedElements[0]), Integer.parseInt(parsedElements[1]), Integer.parseInt(parsedElements[2]));
        } else {
            throw new IllegalArgumentException("Invalid input array");
        }
    }

    public int getSurface() {return surface;}

    public boolean isCubicShape() {
        return isCubicShape;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int calculateSurface(int length, int width, int height) {
        return (2 * length * width) + (2 * width * height) + (2 * height * length) + smallestSideSurface();
    }

    private int smallestSideSurface() {
        List<Integer> sums = new ArrayList<>(List.of(length, width, height));
        sums.sort(Comparator.naturalOrder());
        return sums.get(0) * sums.get(1);
    }

    private boolean isCubicShape(int length, int width, int height) {
        return length == width && width == height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (length != room.length) return false;
        if (width != room.width) return false;
        return height == room.height;
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "Room " +
                "length = " + length +
                ", width = " + width +
                ", height = " + height +
                ", surface = " + surface +
                " (square foot), is in cubing shape = " + isCubicShape;
    }
}
