package prj5;

import java.awt.Color;
import java.util.Iterator;
import java.util.ListIterator;

import CS2114.Button;
import CS2114.Shape;
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
public class GUISurveyWindow
{

    private GUISongDataShape one;
    private GUISongDataShape two;
    private GUISongDataShape three;
    private GUISongDataShape four;
    private GUISongDataShape five;
    private GUISongDataShape six;
    private GUISongDataShape seven;
    private GUISongDataShape eight;
    private GUISongDataShape nine;

    private GUILegend legend;

    private Window window;

    private SongList list;

    private ListIterator<Song> iterator;
    
    private String[][] dataArray;

    public GUISurveyWindow(SongList list, String[][] data)
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
        prev.onClick(this, "clickedPrev");
        sortArtist.onClick(this, "clickedSortArtist");
        sortTitle.onClick(this, "clickedSortTitle");
        sortYear.onClick(this, "clickedSortYear");
        sortGenre.onClick(this, "clickedSortGenre");
        next.onClick(this, "clickedNext");
        repHobby.onClick(this, "clickedRepHobby");
        repMajor.onClick(this, "clickedRepMajor");
        repRegion.onClick(this, "clickedRepRegion");

        quit.onClick(this, "clickedQuit");

        this.list = list;
        dataArray = data;

        iterator = (ListIterator<Song>) list.iterator();

    }

    public void clickedPrev(Button button)
    {


        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.BLUE);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);


    }

    public void clickedNext(Button button)
    {
        int counter = 0;
        System.out.println(list.getLength());
        while(iterator.hasNext() && counter < 9)
        {
            iterator.next();
            counter++;
        }

        System.out.println(iterator.nextIndex());

        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.PINK);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedQuit(Button button)
    {
        System.exit(0);
    }

    public void clickedSortArtist(Button button)
    {
        list.sortArtist();

        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.BLUE);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.PINK);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedSortTitle(Button button)
    {
        list.sortTitle();

        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.GRAY);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedSortYear(Button button)
    {
        list.sortYear();

        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.BLACK);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedSortGenre(Button button)
    {
        list.sortGenre();

        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.BLUE);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.BLUE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedRepHobby(Button button)
    {
        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.GREEN);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedRepMajor(Button button)
    {
        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.ORANGE);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.ORANGE);
        window.addShape(shape);
        window.addShape(shape2);
    }

    public void clickedRepRegion(Button button)
    {
        window.removeAllShapes();
        Shape shape = new Shape(50, 50, 50, 10, Color.BLUE);
        Shape shape2 = new Shape(100, 50, 100, 10, Color.GREEN);
        window.addShape(shape);
        window.addShape(shape2);
    }

    // if i do update by each bar graph, it will be still n^2
    // since i will first loop through 9 songs, then loop through
    // inside 4


}
