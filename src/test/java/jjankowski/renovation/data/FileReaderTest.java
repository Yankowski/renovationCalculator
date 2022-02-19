package jjankowski.renovation.data;

import jjankowski.renovation.vo.Room;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FileReaderTest {

    String FILE_PATH = "input1test.txt";

    @Test
    void shouldBeAbleToLoadRoomsFromCorrectResourceFile() {
        // given
        FileReader fileReader = new FileReader();

        // when
        List<Room> rooms = fileReader.loadFromFile(FILE_PATH);

        assertThat(rooms).hasSameElementsAs(List.of(
                new Room(3, 11, 24),
                new Room(13, 5, 19),
                new Room(1, 9, 27),
                new Room(24, 8, 21)
        ));

    }

    @Test
    void shouldThrowNullPointerExceptionIfFileNotFound() {
        // given
        FileReader fileReader = new FileReader();

        // expect
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> fileReader.loadFromFile(UUID.randomUUID().toString()));
    }

    @Test
    void shouldThrowExceptionIfInputIsInJapanese() {
        // given
        FileReader fileReader = new FileReader();

        // expect
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> fileReader.loadFromFile("inputInJapanese.txt"));
    }

    @Test
    void shouldCreateEmptyListIfInputIffileIsEmpty() {
        // given
        FileReader fileReader = new FileReader();

        // when
        List<Room> rooms = fileReader.loadFromFile("emptyinput.txt");

        // then
        assertThat(rooms).hasSameElementsAs(Collections.emptyList());
    }
}