package prj5;
import student.TestCase;
/**
 * This is a test class for the Song class
 * which tests the methods in Song class.
 * 
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 11.14.2015
 */
public class SongTest extends TestCase
{

    //fields
    private Song song1;
    private Song song2;
    
    //methods
    /**
     * repeated before every test runs
     */
    public void setUp()
    {
        song1 = new Song("Hello", "Adelle", 2015, "pop");
        song2 = new Song("Concerto", "Mozart", 1760, "classical");
    }
    /**
     * should return the title of a given Song object
     */
    public void testGetTitle()
    {
        assertEquals("Hello", song1.getTitle());
    }
    /**
     * should return the artist of a given Song object
     */
    public void testGetArtist()
    {
        assertEquals("Adelle", song1.getArtist());
    }
    /**
     * should return the year of a Song
     */
    public void testGetYear()
    {
        assertEquals(2015, song1.getYear());
    }
    /**
     * should return the genre of a Song
     */
    public void testGetGenre()
    {
        assertEquals("pop", song1.getGenre());
    }
    /**
     * song1's title comes after song2's title.
     */
    public void testCTitleTo()
    {
        assertEquals(5, song1.compareTitleTo(song2.getTitle()));
        assertEquals(-5, song2.compareTitleTo(song1.getTitle()));
        assertEquals(0, song1.compareTitleTo(song1.getTitle()));
    }
    /**
     * song1's artist comes before song2's artist.
     */
    public void testCArtistTo()
    {
        assertEquals(-12, song1.compareArtistTo(song2.getArtist()));
        assertEquals(12, song2.compareArtistTo(song1.getArtist()));
        assertEquals(0, song1.compareArtistTo(song1.getArtist()));
    }
    /**
     * song1's genre comes after song2's genre
     */
    public void testCGenreTo()
    {
        assertEquals(13, song1.compareGenreTo(song2.getGenre()));
        assertEquals(-13, song2.compareGenreTo(song1.getGenre()));
        assertEquals(0, song1.compareGenreTo(song1.getGenre()));
    }
    /**
     * song1's year comes after song2's year
     */
    public void testCYearTo()
    {
        assertEquals(1, song1.compareYearTo(song2.getYear()));
        assertEquals(-1, song2.compareYearTo(song1.getYear()));
        assertEquals(0, song1.compareYearTo(song1.getYear()));
    }
}
