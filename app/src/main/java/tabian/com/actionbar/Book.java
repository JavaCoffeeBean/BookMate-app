package tabian.com.actionbar;

import android.widget.ImageView;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String Bookname;
    private String Bookauthor;
    private ImageView Bookcover;
    private int Delete;
    private int Addreturned;
    private int Addnotreturned;

    public Book() {

    }

    public Book(String bookname, String bookauthor, ImageView bookcover, int delete, int addnotreturned) {
        Bookname = bookname;
        Bookauthor = bookauthor;
        Bookcover = bookcover;
        Delete = delete;
        Addnotreturned = addnotreturned;
    }

    //getter


    public String getBookname() {
        return Bookname;
    }

    public String getBookauthor() {
        return Bookauthor;
    }

    public ImageView getBookcover() {
        return Bookcover;
    }

    public int getDelete() {
        return Delete;
    }

    public int getAddreturned() {
        return Addreturned;
    }

    public int getAddnotreturned() {
        return Addnotreturned;
    }

    //setter


    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public void setBookauthor(String bookauthor) {
        Bookauthor = bookauthor;
    }

    public void setBookcover(ImageView bookcover) {
        Bookcover = bookcover;
    }

    public void setDelete(int delete) {
        Delete = delete;
    }

    public void setAddreturned(int addreturned) {
        Addreturned = addreturned;
    }

    public void setAddnotreturned(int addnotreturned) {
        Addnotreturned = addnotreturned;
    }
}
