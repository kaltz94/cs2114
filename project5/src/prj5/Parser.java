package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser
{
    private String input;
    
    public Parser(String input)
    {
        this.input = input;
    }
    
    /**
     * Scanner scans the input file and while there is a
     * line in the file (until it reaches the end line),
     * every odd lines push a string of boolean, while
     * even lines push a string of names and heights.
     * @return string array of parsed texts
     */
    public String[] parseText()
    {
        String[] text = new String[210];
        try 
        {
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(new File(input));
            int counter = 1;
            int arrayCounter = 0;
            while(scanner.hasNextLine())
            {
                if (counter == 1 || counter == 210)
                {
                    scanner.nextLine();
                }
                String temp = scanner.nextLine();
                text[arrayCounter++] = temp;
                counter++;
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return text;
        
        
    }
}
