package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO
    return _director;
  }

  public String title() {
    // TODO
    return _title;
  }

  public int year() {
    // TODO
    return _year;
  }

  public boolean equals(Object thatObject) {
    // TODO
	  if (thatObject instanceof VideoObj) {
          VideoObj other = (VideoObj) thatObject;
          return (this._director.equals(other.director()) 
        		  && this._title.equals(other.title()) && this._year == other.year());
	  }
	  return false;
  }

  public int hashCode() {
    // TODO
	  int result = 17;
      int mult = 37;
      result = mult * result + _title.hashCode();
      result = mult * result + _year;
      result = mult * result + _director.hashCode();
      return result;
  }

  public int compareTo(Video that) {
	  VideoObj other = (VideoObj) that;
      if (this._title.compareTo(other._title) != 0) {
    	  
    	  return this._title.compareTo(other._title); 	  
      } else {
    	  if (this._year != other._year) {
    		  return this._year - other._year;
          		} 
    	  else {
                return this._director.compareTo(other._director);
                }
      	}
  }

  public String toString() {
    // TODO
	  return _title + " (" + _year + ") : " + _director;
  }
}
