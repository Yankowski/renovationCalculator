package jjankowski.renovation.vo.service;

import jjankowski.renovation.vo.Room;
import jjankowski.renovation.service.extractors.CubicShapeRoomsExtractor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CubicShapeRoomsExtractorTest {

    @ParameterizedTest
    @MethodSource("rooms")
    void filterCubicRooms(List<Room> rooms, List<Room> expectedRooms) {
        // when
        List<Room> result = CubicShapeRoomsExtractor.filterCubicRooms(rooms);

        //then
        assertThat(result).hasSameElementsAs(expectedRooms);
    }

    private static Stream<Arguments> rooms() {
        return Stream.of(
                Arguments.of(List.of(
                        new Room(1, 2, 3),
                        new Room(1, 1, 1),
                        new Room(1, 1, 1),
                        new Room(8, 3, 2),
                        new Room(1, 1, 5),
                        new Room(1, 1, 5),
                        new Room(8, 3, 2),
                        new Room(8, 3, 2)
                ), List.of(
                        new Room(1, 1, 1),
                        new Room(1, 1, 1))
                ),
                Arguments.of(List.of(
                        new Room(1, 1, 5),
                        new Room(2, 4, 7),
                        new Room(1, 2, 3),
                        new Room(1, 1, 5),
                        new Room(8, 3, 2)
                ), Collections.emptyList()),

                Arguments.of(List.of(
                        new Room(1, 2, 3),
                        new Room(1, 1, 1),
                        new Room(2, 4, 7),
                        new Room(8, 8, 8)
                ),  List.of(
                        new Room(1, 1, 1),
                        new Room(8, 8, 8))
                ),
                Arguments.of(Collections.emptyList(), Collections.emptyList())
        );
    }
}