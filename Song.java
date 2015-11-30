package prj5;

/**
 * A song should contain a title, artist, genre, and year.
 * This class contains the getter methods and compareTo methods
 * which will be used in other classes to sort songs. Objects
 * will call calc() methods to count percentages of "yes"'s 
 * for requested representation type: Major, Region, and Hobby.
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
    
    private String[] majorHeard;
    private String[] majorLikes;
    private String[] hobbyHeard;
    private String[] hobbyLikes;
    private String[] regionHeard;
    private String[] regionLikes;

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
        majorHeard = null;
        majorLikes = null;
        hobbyHeard = null;
        hobbyLikes = null;
        regionHeard = null;
        regionLikes = null;
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
     * 
     */
    public String[] getMajorHeard()
    {
        return majorHeard;
    }
    
    public String[] getMajorLikes()
    {
        return majorLikes;
    }
    
    public String[] getHobbyHeard()
    {
        return hobbyHeard;
    }
    
    public String[] getHobbyLikes()
    {
        return hobbyLikes;
    }
    
    public String[] getRegionHeard()
    {
        return regionHeard;
    }

    public String[] getRegionLikes()
    {
        return regionLikes;
    }
    
    /**
     * Compare two titles and return an integer
     * value based on the alphabetical ordering
     * of the two.
     * @param otherTitle to be compared
     * @return 0 if equal
     *        -dif if this is before other 
     *        +dif if after
     */
    public int compareTitleTo(String otherTitle)
    {
        return title.compareTo(otherTitle);
    }

    /**
     * compare two artists and return an integer
     * value based on the alphabetical ordering
     * of the two.
     * @param otherArtist to be compared
     * @return 0 if equal
     *        -dif if this is before other
     *        +dif if this is after other
     */
    public int compareArtistTo(String otherArtist)
    {
        return artist.compareTo(otherArtist);
    }
    /**
     * compare two genres and return
     * an integer value based on the alphabetical
     * ordering of the two.
     * @param otherGenre to be compared
     * @return 0 if equal
     *        -dif if this is before other
     *        +dif if after
     */
    public int compareGenreTo(String otherGenre)
    {
        return genre.compareTo(otherGenre);
    }

    /**
     * compare two release years and
     * return an integer value based on the
     * numerical ordering of the two.
     * @param otherYear to be compared
     * @return 0 if equal
     *        -1 if this is smaller than other
     *         1 if is larger than other
     *        
     */
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

    /**
     * checks if this is equal to the requested object
     * @param obj to be compared
     * @return true if this is 
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            Song song = (Song) obj;
            if (this.title.equals(song.title) &&
                    this.artist.equals(song.artist) &&
                    this.genre.equals(song.genre) &&
                    this.year == song.year)
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Calculate the percentage of the people per major 
     * who heard about this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each major type:
     * Math or CMDA, Computer Science, Other, or
     * Other Engineering.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         majortype1, majortype2, majortype3, majortype4
     */
    public String[] calcMajorHeard(int index, String[][] parsedTextData)
    {   
        int totalMath = 0; // count how many of each major type responded
        int totalCS = 0;
        int totalOther = 0;
        int totalEnge = 0;
        
        int countMath = 0; // count how many said yes for each major type
        int countCS = 0;
        int countOther = 0;
        int countEnge = 0;

        index = index + 5 + index; 
        // every time the song index is increased, that is, a different
        // song is called, that index corresponds with index + 5 of
        // the question I am referring to. 
        // (eg. Suppose SONG is the second song on the list String[][]. 
        // Then, the index of SONG in list array is [1][].
        // Then, the question we want to refer to count is the
        // "Have you heard about the SONG?" whose index in the 
        // survey data String[i][1 + 5 + 1] for all i's.)

        // HEARD's are index + 5 + index;
        // LIKES's are index + 6 + index; for all calc methods

        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][2].equals("Math or CMDA"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalMath++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countMath++;
                    }
                }          
            }
            else if (parsedTextData[i][2].equals("Computer Science"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalCS++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countCS++;
                    }
                }   
            }
            else if (parsedTextData[i][2].equals("Other"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalOther++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countOther++;
                    }
                }   
            }
            else if (parsedTextData[i][2].equals("Other Engineering"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalEnge++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countEnge++;
                    }
                }   
            }
        }

        countMath = calcPercent(countMath, totalMath); 
        countCS = calcPercent(countCS, totalCS);
        countOther = calcPercent(countOther, totalOther);
        countEnge = calcPercent(countEnge, totalEnge);
        // refer to calcPercent(int, int) below

        String[] majorHeard = new String[4];
        majorHeard[0] = "" + countMath;
        majorHeard[1] = "" + countCS;
        majorHeard[2] = "" + countOther;
        majorHeard[3] = "" + countEnge;
        
        this.majorHeard = majorHeard;
        
        return majorHeard;
    }

    /**
     * Calculate the percentage of the people per major 
     * who like this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each major type:
     * Math or CMDA, Computer Science, Other, or
     * Other Engineering.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         majortype1, majortype2, majortype3, majortype4
     */
    public String[] calcMajorLikes(int index, String[][] parsedTextData)
    {
        int totalMath = 0;
        int totalCS = 0;
        int totalOther = 0;
        int totalEnge = 0;
        
        int countMath = 0;
        int countCS = 0;
        int countOther = 0;
        int countEnge = 0;

        index = index + 6 + index;
        // every time the song index is increased, that is, a different
        // song is called, that index corresponds with index + 6 of
        // the question I am referring to. 

        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][2].equals("Math or CMDA"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalMath++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countMath++;
                    }
                }          
            }
            else if (parsedTextData[i][2].equals("Computer Science"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalCS++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countCS++;
                    }
                }   
            }
            else if (parsedTextData[i][2].equals("Other"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalOther++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countOther++;
                    }
                }   
            }
            else if (parsedTextData[i][2].equals("Other Engineering"))
            {
                if (parsedTextData[i][index] != null)
                {
                    totalEnge++;
                    if (parsedTextData[i][index].equals("Yes"))
                    {
                        countEnge++;
                    }
                }   
            }
        }

        countMath = calcPercent(countMath, totalMath); 
        countCS = calcPercent(countCS, totalCS);
        countOther = calcPercent(countOther, totalOther);
        countEnge = calcPercent(countEnge, totalEnge);

        String[] majorLikes = new String[4];
        majorLikes[0] = "" + countMath;
        majorLikes[1] = "" + countCS;
        majorLikes[2] = "" + countOther;
        majorLikes[3] = "" + countEnge;
        
        this.majorLikes = majorLikes;
        
        return majorLikes;
    }

    /**
     * Calculate the percentage of the people per region 
     * who heard about this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each region type:
     * Southeast, Northeast, US other than two, outside US.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         regiontype1, regiontype2, regiontype3, regiontype4
     */
    public String[] calcRegionHeard(int index, String[][] parsedTextData)
    {
        int totalSE = 0;
        int totalNE = 0;
        int totalOther = 0;
        int totalOut = 0;
        
        int countSE = 0;
        int countNE = 0;
        int countOther = 0;
        int countOut = 0;

        index = index + 5 + index;

        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][4] != null)
            {
                if (parsedTextData[i][4].equals("Southeast"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalSE++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countSE++;
                        }
                    }          
                }
                else if (parsedTextData[i][4].equals("Northeast"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalNE++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countNE++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("United States (other than Southeast or Northwest)"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalOther++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countOther++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("Outside of United States"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalOut++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countOut++;
                        }
                    }   
                }
            }
        }

        countSE = calcPercent(countSE, totalSE); 
        countNE = calcPercent(countNE, totalNE);
        countOther = calcPercent(countOther, totalOther);
        countOut = calcPercent(countOut, totalOut);

        String[] regionHeard = new String[4];
        regionHeard[0] = "" + countSE;
        regionHeard[1] = "" + countNE;
        regionHeard[2] = "" + countOther;
        regionHeard[3] = "" + countOut;
        
        this.regionHeard = regionHeard;

        return regionHeard;
    }

    /**
     * Calculate the percentage of the people per region 
     * who like this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each region type:
     * Southeast, Northeast, US other than two, outside US.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         regiontype1, regiontype2, regiontype3, regiontype4
     */
    public String[] calcRegionLikes(int index, String[][] parsedTextData)
    {
        int countSE = 0;
        int countNE = 0;
        int countOther = 0;
        int countOut = 0;
        
        index = index + 6 + index;
        
        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][index].equals("Yes"))
            {
                if (parsedTextData[i][4].equals("Southeast"))
                {
                    countSE++;
                }
                if (parsedTextData[i][4].equals("Northeast"))
                {
                    countNE++;
                }
                if (parsedTextData[i][4].equals("United States (other than Southeast or Northwest)"))
                {
                    countOther++;
                }
                if (parsedTextData[i][4].equals("Outside of United States"))
                {
                    countOut++;
                }
            }
        }
        int sum = countSE + countNE + countOther + countOut;

        countSE = calcPercent(countSE, sum);
        countNE = calcPercent(countNE, sum);
        countOther = calcPercent(countOther, sum);
        countOut = calcPercent(countOut, sum);

        String[] regionLikes = new String[4];
        regionLikes[0] = "" + countSE;
        regionLikes[1] = "" + countNE;
        regionLikes[2] = "" + countOther;
        regionLikes[3] = "" + countOut;
        
        this.regionLikes = regionLikes;
        
        return regionLikes;
    }

    /**
     * Calculate the percentage of the people per hobby 
     * who heard about this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each hobby type:
     * read, art, sport, and music.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         hobby1, hobby2, hobby3, hobby4
     */
    public String[] calcHobbyHeard(int index, String[][] parsedTextData)
    {
        int totalRead = 0; // count how many of each hobby type responded
        int totalArt = 0;
        int totalSport = 0;
        int totalMusic = 0;

        int countRead = 0; // count how many said yes
        int countArt = 0;
        int countSport = 0;
        int countMusic = 0;
        
        index = index + 5 + index;

        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][4] != null)
            {
                if (parsedTextData[i][4].equals("reading"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalRead++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countRead++;
                        }
                    }          
                }
                else if (parsedTextData[i][4].equals("art"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalArt++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countArt++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("sports"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalSport++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countSport++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("music"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalMusic++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countMusic++;
                        }
                    }   
                }
            }
        }

        countRead = calcPercent(countRead, totalRead); 
        countArt = calcPercent(countArt, totalArt);
        countSport = calcPercent(countSport, totalSport);
        countMusic = calcPercent(countMusic, totalMusic);

        String[] hobbyHeard = new String[4];
        hobbyHeard[0] = "" + countRead;
        hobbyHeard[1] = "" + countArt;
        hobbyHeard[2] = "" + countSport;
        hobbyHeard[3] = "" + countMusic;
        
        this.hobbyHeard = hobbyHeard;
        
        return hobbyHeard;
    }

    /**
     * Calculate the percentage of the people per hobby 
     * who like this song based on the 2D String
     * array of survey data parsed in. Count how many
     * said "yes" to the question for each hobby type:
     * read, art, sport, and music.
     * 
     * @param index of the song in the song list 2D array
     * @param parsedTextData a 2D array of parsed survey data
     * @return String array of percentages of people who said "yes"
     *         in a format:
     *         [10, 0, 50, 40]
     *         hobby1, hobby2, hobby3, hobby4
     */
    public String[] calcHobbyLikes(int index, String[][] parsedTextData)
    {
        int totalRead = 0; // count how many of each hobby type responded
        int totalArt = 0;
        int totalSport = 0;
        int totalMusic = 0;

        int countRead = 0; // count how many said yes
        int countArt = 0;
        int countSport = 0;
        int countMusic = 0;
        
        index = index + 6 + index;

        for (int i = 0; i < parsedTextData.length; i++)
        {
            if (parsedTextData[i][4] != null)
            {
                if (parsedTextData[i][4].equals("reading"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalRead++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countRead++;
                        }
                    }          
                }
                else if (parsedTextData[i][4].equals("art"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalArt++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countArt++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("sports"))
                {
                    if (parsedTextData[i][index] != null && 
                            (parsedTextData[i][index].equals("Yes") || 
                                    parsedTextData[i][index].equals("No")))
                    {
                        totalSport++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countSport++;
                        }
                    }   
                }
                else if (parsedTextData[i][4].equals("music"))
                {
                    if (parsedTextData[i][index] != null)
                    {
                        totalMusic++;
                        if (parsedTextData[i][index].equals("Yes"))
                        {
                            countMusic++;
                        }
                    }   
                }
            }
        }

        countRead = calcPercent(countRead, totalRead); 
        countArt = calcPercent(countArt, totalArt);
        countSport = calcPercent(countSport, totalSport);
        countMusic = calcPercent(countMusic, totalMusic);

        String[] hobbyLikes = new String[4];
        hobbyLikes[0] = "" + countRead;
        hobbyLikes[1] = "" + countArt;
        hobbyLikes[2] = "" + countSport;
        hobbyLikes[3] = "" + countMusic;
        
        this.hobbyLikes = hobbyLikes;
        
        return hobbyLikes;
    }

    /**
     * calculate the percentage count / sum and returns.
     * Take int / int, cast to double, and cast int to
     * the result, and return.
     * @param count to be divided
     * @param sum of all
     * @return the integer value of percentage (16% = 16)
     */
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
