package hw1;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

final class InventorySet {
  private final Map<Video, RecordObj> _data = new HashMap<>();

  InventorySet() { }

  /** 
   * Return the number of Records. 
   */
  public int size() {
    return _data.size();
  }

  /** 
   * Return a copy of the record for a given Video; if not present, return null. 
   */
  public RecordObj get(Video v) {
    if (!_data.containsKey(v)) {
      return null;
    }
    return _data.get(v).copy();
  }

  /** 
   * Return a copy of the records as a collection. 
   * Neither the underlying collection, nor the actual records are returned. 
   */
  public Collection<RecordObj> toCollection() {
    Collection<RecordObj> records = new ArrayList<>();
    for (RecordObj r : _data.values()) {
      records.add(r.copy());
    }
    return records;
  }

  public void addNumOwned(Video video, int change) {
    if (video == null || change == 0) {
      throw new IllegalArgumentException("Video is null or change is zero");
    }

    if (_data.containsKey(video)) {
      RecordObj record = _data.get(video);
      int newNumOwned = record.numOwned() + change;
      if (newNumOwned <= record.numOut()) {
        throw new IllegalArgumentException("Attempting to remove more copies than are owned or are checked out.");
      }
      if (newNumOwned > 0) {
        _data.put(video, new RecordObj(video, newNumOwned, record.numOut(), record.numRentals()));
      } else {
        _data.remove(video);
      }
    } else {
      if (change < 0) {
        throw new IllegalArgumentException("Attempting to remove a video that isn't present.");
      }
      _data.put(video, new RecordObj(video, change, 0, 0));
    }
  }

  public void checkOut(Video video) {
    if (!_data.containsKey(video)) {
      throw new IllegalArgumentException("Video has no record.");
    }
    RecordObj record = _data.get(video);
    if (record.numOut() == record.numOwned()) {
      throw new IllegalArgumentException("All copies of the video are checked out.");
    }
    _data.put(video, new RecordObj(video, record.numOwned(), record.numOut() + 1, record.numRentals() + 1));
  }

  public void checkIn(Video video) {
    if (!_data.containsKey(video)) {
      throw new IllegalArgumentException("Video has no record.");
    }
    RecordObj record = _data.get(video);
    if (record.numOut() <= 0) {
      throw new IllegalArgumentException("The video is not checked out.");
    }
    _data.put(video, new RecordObj(video, record.numOwned(), record.numOut() - 1, record.numRentals()));
  }

  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append("Database:\n");
    for (RecordObj r : _data.values()) {
      buffer.append("  ");
      buffer.append(r);
      buffer.append("\n");
    }
    return buffer.toString();
  }
}
