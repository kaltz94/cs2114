package prj5;

public class Input
{

    public static void main(String[] args)
    {
        String inputFile = "MusicSurveyData.csv";
        if (args[0] != null)
        {
            inputFile = args[0];
            
        }
        Parser x = new Parser(inputFile);
        
    }
}
