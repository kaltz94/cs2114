package prj5;
import student.TestCase;
/**
 * 
 */

/**
 * 
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 
 */
public class SongTest extends TestCase
{

    //fields
    private Song song1;
    private Song song2;
    //methods
    public void setUp()
    {
        song1 = new Song("Hello", "Adelle", 2015, "pop");
        song2 = new Song("Concerto", "Mozart", 1760, "classical");
    }
    public void testGetTitle()
    {
        assertEquals("Hello", song1.getTitle());
    }
    public void testGetArtist()
    {
        assertEquals("Adelle", song1.getArtist());
    }
    public void testGetYear()
    {
        assertEquals(2015, song1.getYear());
    }
    public void testGetGenre()
    {
        assertEquals("pop", song1.getGenre());
    }
    public void testCTitleTo()
    {
        assertEquals(5, song1.compareTitleTo(song2.getTitle()));
        assertEquals(-5, song2.compareTitleTo(song1.getTitle()));
        assertEquals(0, song1.compareTitleTo(song1.getTitle()));
    }
    public void testCArtistTo()
    {
        assertEquals(-12, song1.compareArtistTo(song2.getArtist()));
        assertEquals(12, song2.compareArtistTo(song1.getArtist()));
        assertEquals(0, song1.compareArtistTo(song1.getArtist()));
    }
    public void testCGenreTo()
    {
        assertEquals(13, song1.compareGenreTo(song2.getGenre()));
        assertEquals(-13, song2.compareGenreTo(song1.getGenre()));
        assertEquals(0, song1.compareGenreTo(song1.getGenre()));
    }
    public void testCYearTo()
    {
        assertEquals(1, song1.compareYearTo(song2.getYear()));
        assertEquals(-1, song2.compareYearTo(song1.getYear()));
        assertEquals(0, song1.compareYearTo(song1.getYear()));
    }
}
