package prj5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input
{
    public Input(String fileName) throws IOException
    {
        SurveyWindow window = new SurveyWindow(processList());//list of songs
    }

    public static void main(String[] args) throws IOException
    {
        String inputFile = "MusicSurveyData.csv";
        Input input = new Input(inputFile); 

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
    public String[][] readData(String fileName) throws IOException
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
    public DLinkedList<Song> processList() throws IOException
    {
        DLinkedList<Song> list = new DLinkedList<Song>();
        String[][] parsedData = readData("MusicSurveyData.csv");
        String[][] parsedList = readData("SongList.csv");

        for (int i = 0; i < 58; i++) // total of 59 songs
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

}