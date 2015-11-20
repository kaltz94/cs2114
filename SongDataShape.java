package prj5;

public class SongDataShape
{

    // parsed array String[][]
    // [i][] represents each student answer
    // [][j] represents what kind of answer
    // first three of [][j] should be type.
    // go through [i][] can count [j]
    // For example,
    // for (int i = (song); i < (song)+2; i++)
    //     for (int j = 0; j < stringArraySize; i++)
    // int countYes = 0;
    // int countNo = 0;
    // if [i][j] == yes, countYes++
    // if [i][j] == no, countNo++
    // if else (empty), do nothing
    // when needed percentage (probably not), just divide
    // countYes or countNo by countYes + countNo
    // if HEARD = even i's
    // if LIKES = odd i's
    // (song) depends on the iteration index of the song
    // -> index at another array String[] of songs
    
    // x and y's of the shapes should depend on position
    // position should depend on the list and its indexes
    
    private DLinkedList<Song> list;
    private int countYes;
    private int countNo;
    private String[][] dataArray;
    private String[] songArray;
    
    public SongDataShape(DLinkedList<Song> list)
    {
        this.list = list;
        countYes = 0;
        countNo = 0;
        //dataArray = call from Parser and DataReader
        //songArray = call from Parser and DataReader
    }
    
    
    
}
