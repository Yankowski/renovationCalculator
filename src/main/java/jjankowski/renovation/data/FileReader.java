package jjankowski.renovation.data;

import jjankowski.renovation.vo.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    public static final String DATA_PARSER = "x";

    public List<Room> loadFromFile(String filename) {
        try {
            return getRooms(filename);
        } catch (IOException e) {
            LOGGER.error(String.format("Could not read file: %s", filename), e);
            return Collections.emptyList();
        }
    }

    private List<Room> getRooms(String fileName) throws IOException {
        LOGGER.info(String.format("Loading data from file: %s", fileName));
        List<Room> rooms = new ArrayList<>();
        BufferedReader reader = getReader(fileName);
        String line = reader.readLine();
        while (line != null) {
            rooms.add(Room.fromStringArray(line.split(DATA_PARSER)));
            line = reader.readLine();
        }
        reader.close();
        return rooms;
    }

    private BufferedReader getReader(String filename) {
        return new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(this.getClass().getResourceAsStream(String.format("/%s", filename)))
        ));
    }
}
