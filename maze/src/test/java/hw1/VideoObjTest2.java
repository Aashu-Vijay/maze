package hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VideoObjTest2 {

    @Test
    void testConstructor() {
        VideoObj2 video = new VideoObj2("Test Movie", 2022, "John Doe");

        assertEquals("Test Movie", video.title());
        assertEquals(2022, video.year());
        assertEquals("John Doe", video.director());
    }

    @Test
    void testInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new VideoObj2(null, 2022, "John Doe"));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj2("Test Movie", 1700, "John Doe"));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj2("Test Movie", 2022, ""));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj2("", 2022, "John Doe"));
    }

    @Test
    void testToString() {
        VideoObj2 video = new VideoObj2("Test Movie", 2022, "John Doe");
        String expectedString = "Test Movie (2022) : John Doe";
        assertEquals(expectedString, video.toString());
    }

    @Test
    void testCompareTo() {
        VideoObj2 video1 = new VideoObj2("A Movie", 2022, "A Director");
        VideoObj2 video2 = new VideoObj2("B Movie", 2022, "A Director");
        assertTrue(video1.compareTo(video2) < 0);

        VideoObj2 video3 = new VideoObj2("A Movie", 2021, "A Director");
        assertTrue(video1.compareTo(video3) > 0);

        VideoObj2 video4 = new VideoObj2("A Movie", 2022, "B Director");
        assertTrue(video1.compareTo(video4) < 0);

        VideoObj2 video5 = new VideoObj2("A Movie", 2022, "A Director");
        assertEquals(0, video1.compareTo(video5));
    }
}
