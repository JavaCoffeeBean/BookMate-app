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

    private byte[] cover;

    private String isbn;

    private int priority;

    public BookEntry(String title, String author, byte[] cover, int priority) {
        this.title = title;
        this.author = author;
        this.cover = cover;
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

    public byte[] getCover() {
        return cover;
    }


    public int getPriority() {
        return priority;
    }
}
