package prj5;

/**
 * A DLinkedList composed of songs.  This class holds the methods
 * used to sort the songs by title, artist, release year, and genre.
 * 
 * @author Ethan Vu (ethanvu7)
 * @version 2015.11.25
 */
public class SongList extends DLinkedList<Song> {
    
    /**
     * Creates a new SongList.
     */
    public SongList() {
        super();
    }
    
    /**
     * Sorts the songs by title (alphabetically), using insertion sort.
     * Songs with the the same title, are sorted by artist.  If some songs
     * have the same title and artist, they are sorted by release year.
     * Songs with the same title, artist, and year, are sorted by genre.
     */
    public void sortTitle() {
        int length = this.getLength();
        for (int i = 1; i < length; i++) {
            for (int j = i; (j > 0) && (this.getEntry(j).getTitle()
                    .compareTo(this.getEntry(j-1).getTitle()) < 0 ||
                    (this.getEntry(j).getTitle().compareTo(
                    this.getEntry(j-1).getTitle()) == 0 &&
                    this.thisSongLessThanLast(j))); j--) {
                this.swap(j, j-1);
            }
        }
    }
    
    /**
     * Sorts the songs by artist (alphabetically), using insertion sort.
     * Songs by the same artist are sorted by title.  If some songs
     * have the same artist and title, they are sorted by release year.
     * Songs with the same title, artist, and year, are sorted by genre. 
     */
    public void sortArtist() {
        int length = this.getLength();
        for (int i = 1; i < length; i++) {
            for (int j = i; (j > 0) && (this.getEntry(j).getArtist().
                    compareTo(this.getEntry(j-1).getArtist()) < 0 ||
                    (this.getEntry(j).getArtist().compareTo(
                            this.getEntry(j-1).getArtist()) == 0 &&
                            this.thisSongLessThanLast(j))); j--) {
                this.swap(j, j-1);
            }
        }
    }
    
    /**
     * Sorts the songs by release year (from earliest to latest),
     * using insertion sort.  Songs released in the same year are
     * sorted by title.  If some songs have the same year and title,
     * they are sorted by release year.  Songs with the same title,
     * artist, and year are sorted by
     * genre.
     */
    public void sortYear() {
        int length = this.getLength();
        for (int i = 1; i < length; i++) {
            for (int j = i; (j > 0) && (this.getEntry(j).getYear() <
                    this.getEntry(j-1).getYear() || (this.getEntry(j).getYear()
                            == this.getEntry(j-1).getYear() &&
                            this.thisSongLessThanLast(j))); j--) {
                this.swap(j, j-1);
            }
        }
    }
    
    /**
     * Sorts the songs by genre, using insertion sort.  Songs of the
     * same genre are sorted by title.  If some songs have the same
     * genre and title, they are sorted by artist. Songs with
     * the same title, artist, and genre are sorted by year.
     */
    public void sortGenre() {
        int length = this.getLength();
        for (int i = 1; i < length; i++) {
            for (int j = i; (j > 0) && (this.getEntry(j).getGenre().
                    compareTo(this.getEntry(j-1).getGenre()) < 0 ||
                    (this.getEntry(j).getGenre().compareTo(
                            this.getEntry(j-1).getGenre()) == 0 &&
                            this.thisSongLessThanLast(j))); j--) {
                this.swap(j, j-1);
            }
        }
    }
    
    /**
     * Checks to see if the song at the position specified in the
     * argument is less than the song in the previous position.  An
     * song is less than another if its title is alphabetically
     * before the other song's, if the titles are equal but the first
     * song's artist is alphabetically before the other song's, if
     * the titles and artists are equal but the first song's release
     * year is numerically before the other song's, or if the
     * titles, artists, and release years are equal but the first
     * song's genre is alphabetically before the other song's.
     * 
     * @param position  The position of the song to check if it's less
     *                  than the song at the position before it.
     * @return If the song at position is less than the song at the
     *         previous position.
     */
    private boolean thisSongLessThanLast(int position) {
        return (this.getEntry(position).getTitle().compareTo(
                this.getEntry(position-1).getTitle()) < 0) ||
                (this.getEntry(position).getTitle().compareTo(
                this.getEntry(position-1).getTitle()) == 0 &&
                this.getEntry(position).getArtist().compareTo(
                this.getEntry(position-1).getArtist()) < 0) ||
                (this.getEntry(position).getTitle().compareTo(
                this.getEntry(position-1).getTitle()) == 0 &&
                this.getEntry(position).getArtist().compareTo(
                this.getEntry(position-1).getArtist()) == 0 &&
                this.getEntry(position).getYear() <
                this.getEntry(position-1).getYear()) ||
                (this.getEntry(position).getTitle().compareTo(
                this.getEntry(position-1).getTitle()) == 0 &&
                this.getEntry(position).getArtist().compareTo(
                this.getEntry(position-1).getArtist()) == 0 &&
                this.getEntry(position).getYear() ==
                this.getEntry(position-1).getYear() &&
                this.getEntry(position).getGenre().compareTo(
                this.getEntry(position-1).getGenre()) < 0);
    }
}