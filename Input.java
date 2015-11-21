package prj5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Input two files, MusicSurveyData.csv and SongList.csv, and
 * output into a specified format using standard out. Parses
 * the input data into a 2D String array.
 * 
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 2015.11.18
 *
 */
public class Input
{
    /**
     * creates a new Input object
     * @param fileName of input data
     * @throws IOException
     */
    public Input(String fileName) throws IOException
    {
        GUISurveyWindow window = new GUISurveyWindow(processList(fileName));
    }

    /**
     */
    public static void main(String[] args) throws IOException
    {
        String inputData = "MusicSurveyDataTest1.csv";
        String inputList = "SongListTest1.csv";
        /*
        if (args[0] != null)
        {
            inputData = args[0];
        }
        if (args[1] != null)
        {
            inputList = args[1];
        }
        */
        DLinkedList list = sortByGenre(sortByTitle(processList(inputList)));
        
        for (int i = 0; i < list.getLength(); i++)
        {
            Song song = (Song) list.getEntry(i);
            System.out.println("Song Title: " + song.getTitle());
            System.out.println("Song Artist: " + song.getArtist());
            System.out.println("Song Genre: " + song.getGenre());
            System.out.println("Song Year: " + song.getYear());
            System.out.println("Heard");
            System.out.print("reading:" + song.calcHobbyHeard(i, readData(inputData))[0]);
            System.out.print(" art:" + song.calcHobbyHeard(i, readData(inputData))[1]);
            System.out.print(" sports:" + song.calcHobbyHeard(i, readData(inputData))[2]);
            System.out.println(" music:" + song.calcHobbyHeard(i, readData(inputData))[3]);
            System.out.println("Likes");
            System.out.print("reading:" + song.calcHobbyLikes(i, readData(inputData))[0]);
            System.out.print(" art:" + song.calcHobbyLikes(i, readData(inputData))[1]);
            System.out.print(" sports:" + song.calcHobbyLikes(i, readData(inputData))[2]);
            System.out.println(" music:" + song.calcHobbyLikes(i, readData(inputData))[3]);
            
        }
        
        Input input = new Input(inputList); 

    }

    /**
     * Takes in a csv file, read every line, split it by comma, and
     * put into a 2D String array. First read each line of the csv file, 
     * replace all commas with ",###" in the csv file to take blank spaces 
     * into account for calculating length, split by ",###", put into 
     * a 2D string array [linenumber][split string array].
     * 
     * Resulting array will have a format like below:
     * 
     * [Nr][Date][Major][Region][Hobby][Yes][No][No]...
     * [Nr][Date][Major][Region][Hobby][Yes][Yes][Yes]...
     * 
     * @param fileName of the csv file to be scanned
     * @return the 2D array representation of the survey data
     * @throws IOException
     */
    public static String[][] readData(String fileName) throws IOException
    {
        BufferedReader dataBR = new BufferedReader(new FileReader(new File(fileName)));
        dataBR.readLine(); // skips first line. First lines are both files are just descriptions.
        String dataRow = dataBR.readLine();
        int line = 0;
        String[][] store = new String[209][124];

        while (dataRow != null) 
        {
            if (line < 209) // last line (209) of MusicSurveyData.csv contains description as well.
            {
                dataRow = dataRow.replaceAll(",", ",###"); // blank data (,,) will now have (,###,) so that
                String[] row = dataRow.split(","); // when split by comma, blank data still counts as a space
                if (row.length < 124) // preventing array out of bounds
                {
                    for (int i = 0; i < row.length; i++)
                    {
                        row[i] = row[i].replaceAll("###", ""); // now remove ### and let blank data blank
                        store[line][i] = row[i];
                    }
                }

                dataRow = dataBR.readLine(); // goes to next line
            }
            line++;
        }

        dataBR.close(); // close the buffered reader

        return store;
    }


    /**
     * Using a 2D array of MusicData and a 2D array of MusicList,
     * create a song for each index of MusicList
     * 1) with the title, artist, release year, genre read from MusicList array;
     * 2) with the String array of percentage of "Yes" to heard of this song for each major
     * 3) with the String array of percentage of "Yes" to likes of this song for each major
     * ...
     * 7) with the String array of precentage of "Yes" to likes of this song for each hobby
     * 
     * Then, add each song to the list and return the list.
     *  
     * @return list of songs
     * @throws IOException
     */
    public static DLinkedList<Song> processList(String fileName) throws IOException
    {
        DLinkedList<Song> list = new DLinkedList<Song>();
        String[][] parsedList = readData(fileName);
        //String[][] parsedData = readData("MusicSurveyData.csv");
        
        int counter = 0;
        for (int i = 0; i < parsedList.length; i++)
        {
            if (parsedList[i][0] != null)
            {
                counter++;
            }
        }
        
        for (int i = 0; i < counter; i++)
        {
            String title = parsedList[i][0];
            String artist = parsedList[i][1];
            int year = Integer.parseInt(parsedList[i][2]);
            String genre = parsedList[i][3];
            Song song = new Song(title, artist, year, genre);
            list.addBeginning(song);
        }

        return list;
    }

    public static DLinkedList<Song> sortByTitle(DLinkedList<Song> list)
    {
        if (!list.isEmpty())
        {
            DLinkedList<Song> sorted = list;
            int inPointer = 0;
            int compare = 0;
            int curPointer = 1;


            while (curPointer != list.getLength())
            {
                inPointer = 0;
                while (inPointer != curPointer)
                {
                    compare = sorted.getEntry(curPointer).compareTitleTo(sorted.getEntry(inPointer).getTitle());
                    if (compare < 0)
                    {
                        sorted.swap(inPointer, curPointer);
                    }
                    inPointer++;
                }

                curPointer++;
            }

        }

        return list;

    }
    
    public static DLinkedList<Song> sortByGenre(DLinkedList<Song> list)
    {
        if (!list.isEmpty())
        {
            DLinkedList<Song> sorted = list;
            int inPointer = 0;
            int compare = 0;
            int curPointer = 1;


            while (curPointer != list.getLength())
            {
                inPointer = 0;
                while (inPointer != curPointer)
                {
                    compare = sorted.getEntry(curPointer).compareGenreTo(sorted.getEntry(inPointer).getGenre());
                    if (compare < 0)
                    {
                        sorted.swap(inPointer, curPointer);
                    }
                    inPointer++;
                }

                curPointer++;
            }

        }

        return list;

    }

}
