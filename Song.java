package prj5;
/**
 * A song should contain a title, artist, genre, and year.
 * This class contains the getter methods and compareTo methods
 * which will be used in other classes to sort songs.
 * 
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 11.14.2015
 */
public class Song
{
    //fields
    private String title;
    private String artist;
    private int year;
    private String genre;
    
    //methods
    /**
     * Create a new Song.
     * Set the fields to parameters.
     *  
     * @param title a String
     * @param artist a String
     * @param year a String
     * @param genre a String
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }
    /**
     * a getter method for title
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * a getter for artist
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * a getter for year
     * @return year
     */
    public int getYear()
    {
        return year;
    }
    /**
     * a getter for genre
     * @return genre
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Compare this title with otherTitle.
     * If same, return 0; if it comes before, 
     * return a negative integer; else, return 
     * a positive integer.
     * 
     * @param otherTitle a String
     * @return an integer
     */
    public int compareTitleTo(String otherTitle)
    {
        return title.compareTo(otherTitle);
    }
    /**
     * Compares the song's artist with the given
     * string. If same return 0; if this artist comes
     * before otherArtist alphabetically, return a negative
     * integer; if it comes after, return a positive integer.
     * 
     * @param otherArtist a String
     * @return an integer 
     */
    public int compareArtistTo(String otherArtist)
    {
        return artist.compareTo(otherArtist);
    }
    /**
     * Compares this genre with otherGenre. 
     * If same, return 0; if it comes before, 
     * return a negative integer; else, return 
     * a positive integer.
     * 
     * @param otherGenre a String
     * @return an integer
     */
    public int compareGenreTo(String otherGenre)
    {
        return genre.compareTo(otherGenre);
    }
    public int compareYearTo(int otherYear)
    {
        if (year == otherYear)
        {
            return 0;
        }
        else if (year < otherYear)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    
}
