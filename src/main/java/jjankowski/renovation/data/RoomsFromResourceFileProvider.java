package jjankowski.renovation.data;

import jjankowski.renovation.vo.Room;

import java.util.List;

public class RoomsFromResourceFileProvider implements IRoomsProvider {

    private final String FILENAME;
    private final FileReader fileReader;

    public RoomsFromResourceFileProvider(String fileName) {
        this.FILENAME = fileName;
        this.fileReader = new FileReader();
    }

    @Override
    public List<Room> load() {
        return fileReader.loadFromFile(FILENAME);
    }
}
