package sqliteStuff;

import android.graphics.drawable.Drawable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class BookEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String author;

    private Drawable cover;

    private String isbn;

    private int priority;

    public BookEntry(String title, String author, Drawable cover, String isbn, int priority) {
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.isbn = isbn;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Drawable getCover() {
        return cover;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPriority() {
        return priority;
    }
}