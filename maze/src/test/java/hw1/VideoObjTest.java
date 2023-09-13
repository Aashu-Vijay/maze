package hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VideoObjTest {

    @Test
    void testConstructorValid() {
        VideoObj video = new VideoObj("Inception", 2010, "Christopher Nolan");
        assertEquals("Inception", video.title());
        assertEquals(2010, video.year());
        assertEquals("Christopher Nolan", video.director());
    }

    @Test
    void testConstructorTrimming() {
        VideoObj video = new VideoObj(" Inception ", 2010, " Christopher Nolan ");
        assertEquals("Inception", video.title());
        assertEquals("Christopher Nolan", video.director());
    }

    @Test
    void testInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new VideoObj(null, 2010, "Christopher Nolan"));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj("Inception", 1500, "Christopher Nolan"));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj("Inception", 2010, ""));
        assertThrows(IllegalArgumentException.class, () -> new VideoObj("", 2010, "Christopher Nolan"));
    }

    @Test
    void testEquals() {
        VideoObj video1 = new VideoObj("Inception", 2010, "Christopher Nolan");
        VideoObj video2 = new VideoObj("Inception", 2010, "Christopher Nolan");
        VideoObj video3 = new VideoObj("Interstellar", 2014, "Christopher Nolan");

        assertTrue(video1.equals(video2));
        assertFalse(video1.equals(video3));
        assertFalse(video2.equals(video3));
    }

    @Test
    void testHashCode() {
        VideoObj video1 = new VideoObj("Inception", 2010, "Christopher Nolan");
        VideoObj video2 = new VideoObj("Inception", 2010, "Christopher Nolan");
        
        assertEquals(video1.hashCode(), video2.hashCode());
    }

    @Test
    void testCompareTo() {
        VideoObj video1 = new VideoObj("Inception", 2010, "Christopher Nolan");
        VideoObj video2 = new VideoObj("Inception", 2010, "Christopher Nolan");
        VideoObj video3 = new VideoObj("Interstellar", 2014, "Christopher Nolan");

        assertEquals(0, video1.compareTo(video2));
        assertTrue(video1.compareTo(video3) < 0);
        assertTrue(video3.compareTo(video2) > 0);
    }

    @Test
    void testToString() {
        VideoObj video = new VideoObj("Inception", 2010, "Christopher Nolan");
        String expectedString = "Inception (2010) : Christopher Nolan";
        
        assertEquals(expectedString, video.toString());
    }
}
