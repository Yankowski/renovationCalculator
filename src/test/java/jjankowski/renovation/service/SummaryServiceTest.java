package jjankowski.renovation.vo.service;

import jjankowski.renovation.vo.Room;
import jjankowski.renovation.vo.Summary;
import jjankowski.renovation.service.SummaryService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryServiceTest {

    @Test
    void shouldCreateSummaryWithCubicShapeRoomsDesc() {
        // given
        List<Room> rooms = List.of(
                new Room(1, 2, 3),
                new Room(1, 1, 5),
                new Room(9, 9, 9),
                new Room(8, 3, 2),
                new Room(1, 1, 5),
                new Room(1, 1, 1),
                new Room(3, 3, 3),
                new Room(8, 3, 2)
        );
        // when
        Summary summary = SummaryService.createSummary(rooms);

        // then
        assertThat(summary.getCubicShapeRoomsDesc()).isEqualTo(
                List.of(
                        new Room(9, 9, 9),
                        new Room(3, 3, 3),
                        new Room(1, 1, 1)
                ));
        assertThat(summary.getRepeatingRooms()).hasSameElementsAs(
                List.of(
                        new Room(8, 3, 2),
                        new Room(1, 1, 5)
                ));
        assertThat(summary.getTotalAreaOfWallPaperNeeded()).isEqualTo(903);
    }

}