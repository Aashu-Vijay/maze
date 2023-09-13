package hw1;

/**
 * Immutable Data Class for video objects that simulates Java records.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 */
public final class VideoObj2 implements Video {
    private final String title;
    private final int year;
    private final String director;

    /**
     * This constructor ensures that object invariants are enforced.
     * @throws IllegalArgumentException if any object invariant is violated.
     */
    public VideoObj2(String title, int year, String director) {
        if ((title == null) || 
            (director == null) || 
            (year <= 1800) || 
            (year >= 5000) || 
            ("".equals(title.trim())) || 
            ("".equals(director.trim()))) {
            throw new IllegalArgumentException();
        }
        this.title = title.trim();
        this.year = year;
        this.director = director.trim();
    }

    public String director() {
        return director;
    }

    public String title() {
        return title;
    }

    public int year() {
        return year;
    }

    @Override
    public int compareTo(Video that) {
        int titleDiff = title().compareTo(that.title());
        if (titleDiff != 0) {
            return titleDiff;
        }
        int yearDiff = year() - that.year();
        if (yearDiff != 0) {
            return yearDiff;
        }
        int directorDiff = director().compareTo(that.director());
        if (directorDiff != 0) {
            return directorDiff;
        }
        return 0;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") : " + director;
    }
}
