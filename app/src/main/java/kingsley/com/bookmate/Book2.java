package kingsley.com.bookmate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table2")
public class Book2 {
    @PrimaryKey(autoGenerate = true)
    private int Id;

    private String Bookname;
    private String Bookauthor;
    private byte[] Bookcover;
    private int Delete;
    private int Addreturned;
    private int Addnotreturned;
    private int Priority;

    public Book2() {

    }

    public Book2(String bookname, String bookauthor, byte[] bookcover, int delete, int addreturned, int priority) {
        this.Bookname = bookname;
        this.Bookauthor = bookauthor;
        this.Bookcover = bookcover;
        this.Delete = delete;
        this.Addreturned = addreturned;
        this.Priority = priority;
    }

    //getter


    public String getBookname() {
        return Bookname;
    }

    public String getBookauthor() {
        return Bookauthor;
    }

    public byte[] getBookcover() {
        return Bookcover;
    }

    public int getDelete() {
        return Delete;
    }

    public int getAddnotreturned() {
        return Addnotreturned;
    }

    public int getId() {
        return Id;
    }

    public int getAddreturned() {
        return Addreturned;
    }

    public int getPriority() {
        return Priority;
    }

    //setter


    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public void setBookauthor(String bookauthor) {
        Bookauthor = bookauthor;
    }

    public void setBookcover(byte[] bookcover) {
        Bookcover = bookcover;
    }

    public void setDelete(int delete) {
        Delete = delete;
    }

    public void setAddnotreturned(int addnotreturned) {
        Addnotreturned = addnotreturned;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAddreturned(int addreturned) {
        Addreturned = addreturned;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }
}
