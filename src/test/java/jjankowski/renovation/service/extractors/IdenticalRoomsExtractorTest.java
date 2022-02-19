package jjankowski.renovation.vo.service;

import jjankowski.renovation.vo.Room;
import jjankowski.renovation.service.extractors.IdenticalRoomsExtractor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IdenticalRoomsExtractorTest {

    @ParameterizedTest
    @MethodSource("rooms")
    void shouldReturnIdenticalRoomsList(List<Room> rooms, List<Room> expectedRooms) {
        // when
        List<Room> result = IdenticalRoomsExtractor.getIdenticalRooms(rooms);

        // then
        assertThat(result).hasSameElementsAs(expectedRooms);
    }

    private static Stream<Arguments> rooms() {
        return Stream.of(
                Arguments.of(List.of(
                        new Room(1, 2, 3),
                        new Room(1, 1, 5),
                        new Room(2, 4, 7),
                        new Room(8, 3, 2),
                        new Room(1, 1, 5),
                        new Room(1, 1, 5),
                        new Room(8, 3, 2),
                        new Room(8, 3, 2)
                ), List.of(new Room(8, 3, 2),
                        new Room(1, 1, 5))),

                Arguments.of(List.of(
                        new Room(1, 1, 5),
                        new Room(2, 4, 7),
                        new Room(1, 2, 3),
                        new Room(1, 1, 5),
                        new Room(8, 3, 2)
                ), List.of(new Room(1, 1, 5))),

                Arguments.of(List.of(
                        new Room(1, 2, 3),
                        new Room(1, 1, 5),
                        new Room(2, 4, 7),
                        new Room(8, 3, 2)
                ), Collections.emptyList()),
                Arguments.of(Collections.emptyList(), Collections.emptyList())
        );
    }

}