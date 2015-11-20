package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Survey window initiates, updates, and modifies the display as
 * the front end.
 *  
 * @author slee2017, dayop13, ethanvu7
 * @version 2015.11.14
 *
 */
public class SurveyWindow
{
    
    private Button next;
    // when clicked, refresh the display/shapes
    // and place based on the list/its iterator
    private Button quit;
    // quits on the window
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;
    
    private SongDataShape one;
    private SongDataShape two;
    private SongDataShape three;
    private SongDataShape four;
    private SongDataShape five;
    private SongDataShape six;
    private SongDataShape seven;
    private SongDataShape eight;
    private SongDataShape nine;
    
    private Legend legend;
    
    private Window window;
    
    public SurveyWindow(DLinkedList<Song> list)
    {
        window = new Window("Music Data Visualization");
        Button prev = new Button("<- prev");
        Button sortArtist = new Button("sort by Artist");
        Button sortTitle = new Button("sort by Title");
        Button sortyear = new Button("sort by Release Year");
        Button sortGenre = new Button("sort by Genre");
        Button next = new Button("next ->");
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
                
    }
    
    public void clickedPrev(Button button)
    {
        
    }
    
    public void clickednext(Button button)
    {
        
    }
    
    public void clickedQuit(Button button)
    {
        
    }
    
    public void clickedSortArtist(Button button)
    {
        
    }
    
    public void clickedSortTitle(Button button)
    {
        
    }
    
    public void clickedSortYear(Button button)
    {
        
    }
    
    public void clickedSortGenre(Button button)
    {
        
    }
    
    public void clickedRepHobby(Button button)
    {
        
    }
    
    public void clickedRepMajor(Button button)
    {
        
    }
    
    public void clickedRepRegion(Button button)
    {
        
    }
    

}
