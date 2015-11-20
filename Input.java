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
    
    public String[][] readData(String fileName) throws IOException
    {
        BufferedReader dataBR = new BufferedReader(new FileReader(new File(fileName)));
        dataBR.readLine();
        String dataRow = dataBR.readLine();
        int line = 0;
        String[][] store = new String[210][123];
        
        while (dataRow != null) 
        {
            String[] row = dataRow.split(",");
            System.out.println(row.length);
            if (row.length < 123)
            {
                for (int i = 0; i < row.length - 1; i++)
                {
                    store[line][i] = row[i];
                }
            }
            dataRow = dataBR.readLine();
            line++;
            
            
        }
        
        dataBR.close();
        
        return store;
    }
    
    
    public DLinkedList<Song> processList() throws IOException
    {
        DLinkedList<Song> list = new DLinkedList<Song>();
        String[][] parsedData = readData("MusicSurveyData.csv");
        String[][] parsedList = readData("SongList.csv");
        
        for (int i = 0; i < 58; i++)
        {
            String title = parsedList[i][0];
            String artist = parsedList[i][1];
            int year = Integer.parseInt(parsedList[i][2]);
            String genre = parsedList[i][3];
            System.out.println(year);
            //list.enqueue(new Song(title, artist, year, genre, string[], string[], string[]));
        }
        
        return list;
    }
    
    
    
    /*
    public MusicList<Song> readFile(String fileName1, String fileName2)
    {
        MusicList<Song> list = new MusicList<Song>();
        Parser parsedData = new Parser(fileName1);
        Parser parsedSong = new Parser(fileName2);
        String[][] parsedTextData = parsedData.parseText();
        String[][] parsedTextSong = parsedSong.parseText();
        System.out.println(parsedTextData[0][122]);
        System.out.println(parsedTextSong[0][2]);
        
        String answer = parsedTextData[0][122];
        System.out.println(answer);
        
        for (int i = 0; i < 59; i++)
        {
            String title = parsedTextSong[i][0];
            String artist = parsedTextSong[i][1];
            int year = Integer.parseInt(parsedTextSong[i][2]);
            String genre = parsedTextSong[i][3];
            //list.enqueue(new Song(title, artist, year, genre, string[], string[], string[]));
        }

        return list;
    }
    */


    public String[] calcHobbyHeard(int index, String[][] parsedTextData)
    {
        int countMath = 0;
        int countCS = 0;
        int countOther = 0;
        int countEnge = 0;
        int i = 0;
        index = index + 5 + index;
        System.out.println(parsedTextData[0][120]);
        while(i != parsedTextData.length - 1)
        {
            if (parsedTextData[i][index] == "Yes")
            {
            }
        }

        /*
        for (int i = 0; i < parsedTextData.length - 1; i++)
        {
            if (parsedTextData[i][2] == "Yes")
            {
                if (parsedTextData[i][2] == "Math or CMDA")
                {
                    countMath++;
                }
                if (parsedTextData[i][2] == "Computer Science")
                {
                    countCS++;
                }
                if (parsedTextData[i][2] == "Other")
                {
                    countOther++;
                }
                if (parsedTextData[i][2] == "Other Engineering")
                {
                    countEnge++;
                }
            }
        }
         */
        int sum = countMath + countCS + countOther + countEnge;
        if (countMath != 0)
        {
            countMath = (countMath / sum) * 100;
        }
        if (countCS != 0)
        {
            countCS = (countCS / sum) * 100;
        }
        if (countOther != 0)
        {
            countOther = (countOther / sum) * 100;
        }
        if (countEnge != 0)
        {
            countEnge = (countEnge / sum) * 100;
        }
        String[] hobbyHeard = new String[4];
        hobbyHeard[0] = "" + countMath;
        hobbyHeard[1] = "" + countCS;
        hobbyHeard[2] = "" + countOther;
        hobbyHeard[3] = "" + countEnge;
        return hobbyHeard;
    }


    /*
    public MusicList<Song> sortArtist(MusicList<Song> list)
    {

    }

    public MusicList<Song> sortTitle(MusicList<Song> list)
    {

    }

    public MusicList<Song> sortYear(MusicList<Song> list)
    {

    }

    public MusicList<Song> sortGenre(MusicList<Song> list)
    {

    }

    public MusicList<Song> repMajor(MusicList<Song> list)
    {

    }

    public MusicList<Song> repRegion(MusicList<Song> list)
    {

    }

    public MusicList<Song> repHobby(MusicList<Song> list)
    {

    }
     */
}
