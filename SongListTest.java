package prj5;

import student.TestCase;

/**
 * Tests the SongList class.
 * 
 * @author Ethan Vu (ethanvu7)
 * @version 2015.11.26
 */
public class SongListTest extends TestCase {

    private SongList list;
    private Song hereComesYourMan;
    private Song familyIsFamily;
    private Song washer;
    private Song riseAbove;
    
    /**
     * Sets up the TestCase.
     */
    public void setUp() {
        list = new SongList();
        hereComesYourMan = new Song("Here Comes Your Man", "Pixies", 1989,
                "Alternative");
        washer = new Song("Washer", "Slint", 1991, "Post-Rock");
        familyIsFamily = new Song("Family Is Family", "Kacey Musgraves",
                2015, "Country");
        riseAbove = new Song("Rise Above", "Black Flag", 1981, "Punk");
        list.add(hereComesYourMan);
        list.add(washer);
        list.add(familyIsFamily);
        list.add(riseAbove);
    }

    /**
     * Tests the sortTitle method for when every song has a different
     * title and some songs must be switched around.
     */
    public void testSortTitleDiffTitle() {
        list.sortTitle();
        assertEquals(4, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(riseAbove, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
    }
    
    /**
     * Tests the sortTitle method for when every song has a different
     * title, but the list is already sorted.
     */
    public void testSortTitleDiffTitleNoSort() {
        list.clear();
        list.add(familyIsFamily);
        list.add(hereComesYourMan);
        list.add(riseAbove);
        list.add(washer);
        list.sortTitle();
        assertEquals(4, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(riseAbove, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same
     * title, but every song has a different artist and those songs
     * need to be switched.
     */
    public void testSortTitleSameTitleDiffArtistSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Dacey Musgraves", 2015, "Country");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily2, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same
     * title, but every song has a different artist and those songs
     * don't need to be switched.
     */
    public void testSortTitleSameTitleDiffArtistNoSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Racey Musgraves", 2015, "Country");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(familyIsFamily2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same title
     * and the same artist, but each song has different release years and
     * those songs need to be switched.
     */
    public void testSortTitleSameTitleSameArtistDiffYearSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Kacey Musgraves", 2014, "Country");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily2, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same title
     * and the same artist, but each song has different release years and
     * those songs don't need to be switched.
     */
    public void testSortTitleSameTitleSameArtistDiffYearNoSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Kacey Musgraves", 2016, "Country");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(familyIsFamily2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same title,
     * same artist, and same release years, but different genres and those
     * songs need to be switched.
     */
    public void testSortTitleSameTitleSameArtistSameYearDiffGenreSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Kacey Musgraves", 2015, "Alternative");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily2, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same title,
     * same artist, and same release years, but different genres and those
     * songs don't need to be switched.
     */
    public void testSortTitleSameTitleSameArtistSameYearDiffGenreNoSwitch() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Kacey Musgraves", 2015, "R&B");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(familyIsFamily2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortTitle method for when some songs have the same title,
     * same artist, same release year, and same genre.
     */
    public void testSortTitleSameTitleSameArtistSameYearSameGenre() {
        Song familyIsFamily2 = new Song("Family Is Family",
                "Kacey Musgraves", 2015, "Country");
        list.add(familyIsFamily2);
        list.sortTitle();
        assertEquals(5, list.getLength());
        assertEquals(familyIsFamily, list.getEntry(0));
        assertEquals(familyIsFamily2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when every song has a different
     * artist and the list is unsorted.
     */
    public void testSortArtistDiffArtist() {
        list.sortArtist();
        assertEquals(4, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
    }
    
    /**
     * Tests the sortArtist method for when every song has a different
     * artist and the list is already sorted.
     */
    public void testSortArtistDiffArtistNoSort() {
        list.clear();
        list.add(riseAbove);
        list.add(familyIsFamily);
        list.add(hereComesYourMan);
        list.add(washer);
        list.sortArtist();
        assertEquals(4, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist, but those songs has a different title and those songs
     * need to be switched.
     */
    public void testSortArtistSameArtistDiffTitleSwitch() {
        Song myWar = new Song("My War", "Black Flag", 1984, "Punk");
        list.add(myWar);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(myWar, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist, but those songs has a different title and those songs
     * don't need to be switched.
     */
    public void testSortArtistSameArtistDiffTitleNoSwitch() {
        Song tvParty = new Song("TV Party", "Black Flag", 1984, "Punk");
        list.add(tvParty);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(tvParty, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist and title, but those songs has a different release year
     * and the songs need to be switched.
     */
    public void testSortArtistSameArtistSameTitleDiffYearSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1980,
                "Punk");
        list.add(riseAbove2);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove2, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist and title, but those songs has a different release year
     * and the songs don't need to be switched.
     */
    public void testSortArtistSameArtistSameTitleDiffYearNoSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1987,
                "Punk");
        list.add(riseAbove2);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist, title, and release year, but those songs have a different
     * genre and the songs need to be switched.
     */
    public void testSortArtistSameArtistSameTitleSameYearDiffGenreSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1981, 
                "Alternative");
        list.add(riseAbove2);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove2, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist, title, and release year, but those songs have a different
     * genre and the songs don't need to be switched.
     */
    public void testSortArtistSameArtistSameTitleSameYearDiffGenreNoSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1981, 
                "Soul");
        list.add(riseAbove2);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }    
    
    /**
     * Tests the sortArtist method for when some songs have the same
     * artist, title, release year, and genre.
     */
    public void testSortArtistSameArtistSameTitleSameYearSameGenre() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1984, "Punk");
        list.add(riseAbove2);
        list.sortArtist();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(hereComesYourMan, list.getEntry(3));
        assertEquals(washer, list.getEntry(4));
    }
    
    /**
     * Tests the sortYear method for when every song has a different
     * release year and the list is unsorted.
     */
    public void testSortYearDiffYear() {
        list.sortYear();
        assertEquals(4, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(washer, list.getEntry(2));
        assertEquals(familyIsFamily, list.getEntry(3));
    }
    
    /**
     * Tests the sortYear method for when every song has a different
     * release year and the list is already sorted.
     */
    public void testSortYearDiffYearNoSort() {
        list.clear();
        list.add(riseAbove);
        list.add(hereComesYourMan);
        list.add(washer);
        list.add(familyIsFamily);
        list.sortYear();
        assertEquals(4, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(washer, list.getEntry(2));
        assertEquals(familyIsFamily, list.getEntry(3));
    }
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, but those songs have different titles and
     * they need to be switched.
     */
    public void testSortYearSameYearDiffTitleSwitch() {
        Song carelessWhisper = new Song("Careless Whisper", "George Michaels",
                1981, "Pop");
        list.add(carelessWhisper);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(carelessWhisper, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, but those songs have different titles but
     * they don't need to be switched.
     */
    public void testSortYearSameYearDiffTitleNoSwitch() {
        Song tvParty = new Song("TV Party", "Black Flag", 1981,
                "Punk");
        list.add(tvParty);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(tvParty, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }    
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, same titles, but different artists and the
     * songs need to be switched.
     */
    public void testSortYearSameYearSameTitleDiffArtistSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Alck Flag",
                1981, "Pop");
        list.add(riseAbove2);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove2, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }

    /**
     * Tests the sortYear method for when some songs have the same
     * release year, same titles, but different artists and the
     * songs don't need to be switched.
     */
    public void testSortYearSameYearSameTitleDiffArtistNoSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Calck Flag",
                1981, "Pop");
        list.add(riseAbove2);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, same titles, and same artist, but those songs
     * have different genres and the songs need to be switched.
     */
    public void testSortYearSameYearSameTitleSameArtistDiffGenreSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag",
                1981, "Pop");
        list.add(riseAbove2);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove2, list.getEntry(0));
        assertEquals(riseAbove, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, same titles, and same artist, but those songs
     * have different genres and the songs don't need to be switched.
     */
    public void testSortYearSameYearSameTitleSameArtistDiffGenreNoSwitch() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag",
                1981, "Soul");
        list.add(riseAbove2);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }
    
    /**
     * Tests the sortYear method for when some songs have the same
     * release year, same titles, same artists, and the same genre.
     */
    public void testSortYearSameYearSameTitleSameArtistSameGenre() {
        Song riseAbove2 = new Song("Rise Above", "Black Flag", 1981,
                "Punk");
        list.add(riseAbove2);
        list.sortYear();
        assertEquals(5, list.getLength());
        assertEquals(riseAbove, list.getEntry(0));
        assertEquals(riseAbove2, list.getEntry(1));
        assertEquals(hereComesYourMan, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(familyIsFamily, list.getEntry(4));
    }    
    
    /**
     * Tests the sortGenre method for when each song has a different
     * genre and the list is unsorted.
     */
    public void testSortGenreDiffGenre() {
        list.sortGenre();
        assertEquals(4, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(washer, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
    }
    
    /**
     * Tests the sortGenre method for when each song has a different
     * genre and the list is sorted.
     */
    public void testSortGenreDiffGenreNoSort() {
        list.clear();
        list.add(hereComesYourMan);
        list.add(familyIsFamily);
        list.add(washer);
        list.add(riseAbove);
        list.sortGenre();
        assertEquals(4, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(familyIsFamily, list.getEntry(1));
        assertEquals(washer, list.getEntry(2));
        assertEquals(riseAbove, list.getEntry(3));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, but each song has different titles and those songs
     * need to be switched.
     */
    public void testSortGenreSameGenreDiffTitleSwitch() {
        Song comeAsYouAre = new Song("Come as You Are", "Nirvana", 1991,
                "Alternative");
        list.add(comeAsYouAre);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(comeAsYouAre, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, but each song has different titles and those songs
     * don't need to be switched.
     */
    public void testSortGenreSameGenreDiffTitleNoSwitch() {
        Song polly = new Song("Polly", "Nirvana", 1991,
                "Alternative");
        list.add(polly);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(polly, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, same title, but each song has different artists and
     * those songs need to be switched.
     */
    public void testSortGenreSameGenreSameTitleDiffArtistSwitch() {
        Song hereComesYourMan2 = new Song("Here Comes Your Man",
                "Joseph Gordon-Levitt", 2009, "Alternative");
        list.add(hereComesYourMan2);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan2, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, same title, but each song has different artists and
     * those songs don't need to be switched.
     */
    public void testSortGenreSameGenreSameTitleDiffArtistNoSwitch() {
        Song hereComesYourMan2 = new Song("Here Comes Your Man",
                "Swans", 2009, "Alternative");
        list.add(hereComesYourMan2);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(hereComesYourMan2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, same title, same artists, but each song has different
     * release years and those songs need to be switched.
     */
    public void testSortGenreSameGenreSameTitleSameArtistDiffYearSwitch() {
        Song hereComesYourMan2 = new Song("Here Comes Your Man", "Pixies",
                1988, "Alternative");
        list.add(hereComesYourMan2);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan2, list.getEntry(0));
        assertEquals(hereComesYourMan, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, same title, same artists, but each song has different
     * release years and those songs don't need to be switched.
     */
    public void testSortGenreSameGenreSameTitleSameArtistDiffYearNoSwitch() {
        Song hereComesYourMan2 = new Song("Here Comes Your Man", "Pixies",
                1999, "Alternative");
        list.add(hereComesYourMan2);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(hereComesYourMan2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
    
    /**
     * Tests the sortGenre method for when each song has the same
     * genre, same title, same artist, and same release year.
     */
    public void testSortGenreSameGenreSameTitleSameArtistSameYear() {
        Song hereComesYourMan2 = new Song("Here Comes Your Man", "Pixies",
                1989, "Alternative");
        list.add(hereComesYourMan2);
        list.sortGenre();
        assertEquals(5, list.getLength());
        assertEquals(hereComesYourMan, list.getEntry(0));
        assertEquals(hereComesYourMan2, list.getEntry(1));
        assertEquals(familyIsFamily, list.getEntry(2));
        assertEquals(washer, list.getEntry(3));
        assertEquals(riseAbove, list.getEntry(4));
    }
}