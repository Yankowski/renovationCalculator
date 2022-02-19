package jjankowski.renovation.data;

import jjankowski.renovation.vo.Room;

import java.util.List;

public interface IRoomsProvider {
    public List<Room> load();
}
