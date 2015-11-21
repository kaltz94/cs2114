package prj5;

import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
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
        
        // Default glyph
        TextShape title = new TextShape(267, 100, "Salad Days");
        TextShape secondHeading = new TextShape(250, 120, "By Mac DeMarco");
        Shape divider = new Shape(300, 140, 5, 40, Color.BLACK);
        Shape firstHeardBar = new Shape(200, 140, 100, 10, Color.RED);
        Shape secondHeardBar = new Shape(250, 150, 50, 10, Color.ORANGE);
        Shape thirdHeardBar = new Shape(225, 160, 75, 10, Color.GREEN);
        Shape fourthHeardBar = new Shape(275, 170, 25, 10, Color.BLUE);
        Shape firstLikeBar = new Shape(305, 140, 100, 10, Color.RED);
        Shape secondLikeBar = new Shape(305, 150, 50, 10, Color.ORANGE);
        Shape thirdLikeBar = new Shape(305, 160, 75, 10, Color.GREEN);
        Shape fourthLikeBar = new Shape(305, 170, 25, 10, Color.BLUE);
        window.addShape(title);
        window.addShape(secondHeading);
        window.addShape(divider);
        window.addShape(firstHeardBar);
        window.addShape(secondHeardBar);
        window.addShape(thirdHeardBar);
        window.addShape(fourthHeardBar);
        window.addShape(firstLikeBar);
        window.addShape(secondLikeBar);
        window.addShape(thirdLikeBar);
        window.addShape(fourthLikeBar);
        
        // Dummy legend
        TextShape legendTitle = new TextShape(500, 105, "Hobby Legend");
        legendTitle.setBackgroundColor(Color.WHITE);
        TextShape firstType = new TextShape(480, 125, "Read");
        firstType.setBackgroundColor(Color.RED);
        TextShape secondType = new TextShape(480, 145, "Art");
        secondType.setBackgroundColor(Color.ORANGE);
        TextShape thirdType = new TextShape(480, 165, "Sports");
        thirdType.setBackgroundColor(Color.GREEN);
        TextShape fourthType = new TextShape(480, 185, "Music");
        fourthType.setBackgroundColor(Color.BLUE);
        TextShape songTitle = new TextShape(510, 205, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        TextShape heard = new TextShape(500, 235, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        TextShape likes = new TextShape(555, 235, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        Shape legendDivider = new Shape(545, 220, 5, 40);
        legendDivider.setBackgroundColor(Color.BLACK);
        legendDivider.setForegroundColor(Color.BLACK);
        Shape border = new Shape(475, 100, 150, 175);
        border.setForegroundColor(Color.BLACK);
        border.setBackgroundColor(Color.WHITE);
        

        window.addShape(legendTitle);
        window.addShape(firstType);
        window.addShape(secondType);
        window.addShape(thirdType);
        window.addShape(fourthType);
        window.addShape(songTitle);
        window.addShape(heard);
        window.addShape(likes);
        window.addShape(legendDivider);
        window.addShape(border);
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
