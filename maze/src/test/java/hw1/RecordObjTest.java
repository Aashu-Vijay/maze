package hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class RecordObjTest {

    @Test
    void testConstructor() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);

        assertEquals(testVideo, record.video);
        assertEquals(5, record.numOwned());
        assertEquals(3, record.numOut());
        assertEquals(4, record.numRentals());
    }

    @Test
    void testInvalidConstructorArguments() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");

        assertThrows(IllegalArgumentException.class, () -> new RecordObj(null, 5, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> new RecordObj(testVideo, -5, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> new RecordObj(testVideo, 5, 7, 4));
        assertThrows(IllegalArgumentException.class, () -> new RecordObj(testVideo, 5, 3, 2));
    }

    @Test
    void testNumOwned() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);
        assertEquals(5, record.numOwned());
    }

    @Test
    void testNumOut() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);
        assertEquals(3, record.numOut());
    }

    @Test
    void testNumRentals() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);
        assertEquals(4, record.numRentals());
    }

    @Test
    void testCopy() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);

        RecordObj copy = record.copy();
        assertEquals(record.video, copy.video);
        assertEquals(record.numOwned(), copy.numOwned());
        assertEquals(record.numOut(), copy.numOut());
        assertEquals(record.numRentals(), copy.numRentals());
    }

    @Test
    void testToString() {
        Video testVideo = new VideoObj("Test Movie", 2022, "John Doe");
        RecordObj record = new RecordObj(testVideo, 5, 3, 4);

        String expectedString = "Test Movie (2022) : John Doe [5,3,4]";
        assertEquals(expectedString, record.toString());
    }
}
