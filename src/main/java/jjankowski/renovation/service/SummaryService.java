package jjankowski.renovation.service;

import jjankowski.renovation.service.calculators.TotalWallPaperSurfaceCalculator;
import jjankowski.renovation.service.extractors.CubicShapeRoomsExtractor;
import jjankowski.renovation.service.extractors.IdenticalRoomsExtractor;
import jjankowski.renovation.vo.Room;
import jjankowski.renovation.vo.Summary;

import java.util.List;

public class SummaryService {

    public static Summary createSummary(List<Room> roomList) {
        return new Summary(
                TotalWallPaperSurfaceCalculator.calculateTotalSurface(roomList),
                CubicShapeRoomsExtractor.filterCubicRooms(roomList),
                IdenticalRoomsExtractor.getIdenticalRooms(roomList)
        );
    }
}
