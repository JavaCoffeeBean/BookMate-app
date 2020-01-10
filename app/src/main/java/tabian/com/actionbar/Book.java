package tabian.com.actionbar;

import android.widget.ImageButton;
import android.widget.ImageView;

public class Book {

    private String Bookname;
    private String Bookauthor;
    private int Bookcover;
    private int Delete;
    private int Addreturned;
    private int Addnotreturned;

    public Book() {

    }

    public Book(String bookname, String bookauthor, int bookcover, int delete, int addnotreturned) {
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

    public int getBookcover() {
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

    public void setBookcover(int bookcover) {
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
