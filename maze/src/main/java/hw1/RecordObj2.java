package hw1;

final class RecordObj2 {
    /** The video. */
    Video video;

    /** The number of copies of the video that are in the inventory. */
    int numOwned;

    /** The number of copies of the video that are currently checked out. */
    int numOut;

    /** The total number of times this video has ever been checked out. */
    int numRentals;

    /**
     * Initialize all object attributes.
     */
    RecordObj2(Video video, int numOwned, int numOut, int numRentals) {
        if(video == null || numOwned <= 0 || numOut > numOwned || numRentals < numOut) {
            throw new IllegalArgumentException("Invalid initial values provided for RecordObj");
        }
        
        this.video = video;
        this.numOwned = numOwned;
        this.numOut = numOut;
        this.numRentals = numRentals;
    }

    /**
     * @return number of owned video
     */
    int numOwned() {
        return numOwned;
    }

    /**
     * @return number of out video
     */
    int numOut() {
        return numOut;
    }

    /**
     * @return number of rented video
     */
    int numRentals() {
        return numRentals;
    }

    /**
     * @return a shallow copy of this record.
     */
    public RecordObj copy() {
        return new RecordObj(this.video, this.numOwned, this.numOut, this.numRentals);
    }

    /**
     * Return a string representation of the object.
     */
    @Override
    public String toString() {
        return video + " [" + numOwned + "," + numOut + "," + numRentals + "]";
    }
}
