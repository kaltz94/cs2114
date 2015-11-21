package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Survey window initiates, updates, and modifies the display as
 * the front end.
 *  
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 2015.11.14
 *
 */
public class SurveyWindow
{
    
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
        Button sortYear = new Button("sort by Release Year");
        Button sortGenre = new Button("sort by Genre");
        Button next = new Button("next ->");
        Button repHobby = new Button("represent by Hobby");
        Button repMajor = new Button("represent by Major");
        Button repRegion = new Button("represent by Region");
        Button quit = new Button("quit");
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortYear, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(repHobby, WindowSide.SOUTH);
        window.addButton(repMajor, WindowSide.SOUTH);
        window.addButton(repRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
                
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
