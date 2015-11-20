package prj5;
/**
 * 
 */

/**
 * A song should contain a title, artist, genre, and year.
 * This class contains the getter methods and compareTo methods
 * which will be used in other classes to sort songs.
 * 
 * @author Dayoung Park <dayop13>, Sarah Lee <slee2017>, Ethan Vu <ethanvu7>
 * @version 11.14.2015
 */
public class Song
{
    //fields
    private String title;
    private String artist;
    private int year;
    private String genre;
    
    //methods
    /**
     * Create a new Song.
     * Set the fields to parameters.
     *  
     * @param title a String
     * @param artist a String
     * @param year a String
     * @param genre a String
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }
    /**
     * a getter method for title
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * a getter for artist
     * @return artist
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * a getter for year
     * @return year
     */
    public int getYear()
    {
        return year;
    }
    /**
     * a getter for genre
     * @return genre
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Compare two titles and 
     * @param otherTitle
     * @return 0 if equal
     * -1 if before and 1 if after
     */
    public int compareTitleTo(String otherTitle)
    {
        return title.compareTo(otherTitle);
    }
    /**
     * 
     */
    public int compareArtistTo(String otherArtist)
    {
        return artist.compareTo(otherArtist);
    }
    /**
     * 
     */
    public int compareGenreTo(String otherGenre)
    {
        return genre.compareTo(otherGenre);
    }
    public int compareYearTo(int otherYear)
    {
        if (year == otherYear)
        {
            return 0;
        }
        else if (year < otherYear)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    
    public String[] calcMajorHeard(int index, String[][] parsedTextData)
    {
        int countMath = 0;
        int countCS = 0;
        int countOther = 0;
        int countEnge = 0;
        index = index + 5 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][2].equals("Math or CMDA"))
                {
                    countMath++;
                }
                else if (parsedTextData[i][2].equals("Computer Science"))
                {
                    countCS++;
                }
                else if (parsedTextData[i][2].equals("Other"))
                {
                    countOther++;
                }
                else if (parsedTextData[i][2].equals("Other Engineering"))
                {
                    countEnge++;
                }
            }
        }
        int sum = countMath + countCS + countOther + countEnge;
        //System.out.println(sum);
        countMath = calcPercent(countMath, sum);
        countCS = calcPercent(countCS, sum);
        countOther = calcPercent(countOther, sum);
        countEnge = calcPercent(countEnge, sum);

        String[] majorHeard = new String[4];
        majorHeard[0] = "" + countMath;
        majorHeard[1] = "" + countCS;
        majorHeard[2] = "" + countOther;
        majorHeard[3] = "" + countEnge;
        return majorHeard;
    }

    public String[] calcMajorLikes(int index, String[][] parsedTextData)
    {
        int countMath = 0;
        int countCS = 0;
        int countOther = 0;
        int countEnge = 0;
        index = index + 6 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][2].equals("Math or CMDA"))
                {
                    countMath++;
                }
                if (parsedTextData[i][2].equals("Computer Science"))
                {
                    countCS++;
                }
                if (parsedTextData[i][2].equals("Other"))
                {
                    countOther++;
                }
                if (parsedTextData[i][2].equals("Other Engineering"))
                {
                    countEnge++;
                }
            }
        }
        int sum = countMath + countCS + countOther + countEnge;
        //System.out.println(sum);
        countMath = calcPercent(countMath, sum);
        countCS = calcPercent(countCS, sum);
        countOther = calcPercent(countOther, sum);
        countEnge = calcPercent(countEnge, sum);

        String[] majorLikes = new String[4];
        majorLikes[0] = "" + countMath;
        majorLikes[1] = "" + countCS;
        majorLikes[2] = "" + countOther;
        majorLikes[3] = "" + countEnge;
        return majorLikes;
    }

    public String[] calcRegionHeard(int index, String[][] parsedTextData)
    {
        int countSE = 0;
        int countNE = 0;
        int countOther = 0;
        int countOut = 0;
        index = index + 5 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][3].equals("Southeast"))
                {
                    countSE++;
                }
                if (parsedTextData[i][3].equals("Northeast"))
                {
                    countNE++;
                }
                if (parsedTextData[i][3].equals("United States (other than Southeast or Northwest)"))
                {
                    countOther++;
                }
                if (parsedTextData[i][3].equals("Outside of United States"))
                {
                    countOut++;
                }
            }
        }
        int sum = countSE + countNE + countOther + countOut;
        //System.out.println(sum);
        countSE = calcPercent(countSE, sum);
        countNE = calcPercent(countNE, sum);
        countOther = calcPercent(countOther, sum);
        countOut = calcPercent(countOut, sum);

        String[] regionHeard = new String[4];
        regionHeard[0] = "" + countSE;
        regionHeard[1] = "" + countNE;
        regionHeard[2] = "" + countOther;
        regionHeard[3] = "" + countOut;
        return regionHeard;
    }

    public String[] calcRegionLikes(int index, String[][] parsedTextData)
    {
        int countSE = 0;
        int countNE = 0;
        int countOther = 0;
        int countOut = 0;
        index = index + 6 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][3].equals("Southeast"))
                {
                    countSE++;
                }
                if (parsedTextData[i][3].equals("Northeast"))
                {
                    countNE++;
                }
                if (parsedTextData[i][3].equals("United States (other than Southeast or Northwest)"))
                {
                    countOther++;
                }
                if (parsedTextData[i][3].equals("Outside of United States"))
                {
                    countOut++;
                }
            }
        }
        int sum = countSE + countNE + countOther + countOut;
        //System.out.println(sum);
        countSE = calcPercent(countSE, sum);
        countNE = calcPercent(countNE, sum);
        countOther = calcPercent(countOther, sum);
        countOut = calcPercent(countOut, sum);

        String[] regionLikes = new String[4];
        regionLikes[0] = "" + countSE;
        regionLikes[1] = "" + countNE;
        regionLikes[2] = "" + countOther;
        regionLikes[3] = "" + countOut;
        return regionLikes;
    }
    
    public String[] calcHobbyHeard(int index, String[][] parsedTextData)
    {
        int countRead = 0;
        int countArt = 0;
        int countSport = 0;
        int countMusic = 0;
        index = index + 5 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][3].equals("read"))
                {
                    countRead++;
                }
                if (parsedTextData[i][3].equals("art"))
                {
                    countArt++;
                }
                if (parsedTextData[i][3].equals("sport"))
                {
                    countSport++;
                }
                if (parsedTextData[i][3].equals("music"))
                {
                    countMusic++;
                }
            }
        }
        int sum = countRead + countArt + countSport + countMusic;
        //System.out.println(sum);
        countRead = calcPercent(countRead, sum);
        countArt = calcPercent(countArt, sum);
        countSport = calcPercent(countSport, sum);
        countMusic = calcPercent(countMusic, sum);

        String[] hobbyHeard = new String[4];
        hobbyHeard[0] = "" + countRead;
        hobbyHeard[1] = "" + countArt;
        hobbyHeard[2] = "" + countSport;
        hobbyHeard[3] = "" + countMusic;
        return hobbyHeard;
    }
    
    public String[] calcHobbyLikes(int index, String[][] parsedTextData)
    {
        int countRead = 0;
        int countArt = 0;
        int countSport = 0;
        int countMusic = 0;
        index = index + 6 + index;
        //System.out.println(parsedTextData[0][5]);
        //System.out.println(parsedTextData[0][2]);
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][3].equals("read"))
                {
                    countRead++;
                }
                if (parsedTextData[i][3].equals("art"))
                {
                    countArt++;
                }
                if (parsedTextData[i][3].equals("sport"))
                {
                    countSport++;
                }
                if (parsedTextData[i][3].equals("music"))
                {
                    countMusic++;
                }
            }
        }
        int sum = countRead + countArt + countSport + countMusic;
        //System.out.println(sum);
        countRead = calcPercent(countRead, sum);
        countArt = calcPercent(countArt, sum);
        countSport = calcPercent(countSport, sum);
        countMusic = calcPercent(countMusic, sum);

        String[] hobbyLikes = new String[4];
        hobbyLikes[0] = "" + countRead;
        hobbyLikes[1] = "" + countArt;
        hobbyLikes[2] = "" + countSport;
        hobbyLikes[3] = "" + countMusic;
        return hobbyLikes;
    }

    private int calcPercent(int count, int sum)
    {
        int percentage = 0;
        if (count != 0 && sum != 0)
        {
            double percent = (double)count * 100 / (double)sum;
            percent = Math.round(percent);
            percentage = (int)percent;
        }
        return percentage;
    }
    
}
