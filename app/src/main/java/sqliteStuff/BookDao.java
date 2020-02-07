package sqliteStuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tabian.com.actionbar.Book;

@Dao
public interface BookDao {

    @Insert
    void insert(Book bookEntry);

    @Update
    void update(Book bookEntry);

    @Delete
    void delete(Book bookEntry);

    @Query("DELETE FROM book_table")
    void deleteAllBookentries();

    @Query("SELECT * FROM book_table ORDER BY priority DESC")
    LiveData<List<Book>> getAllBookEntries();
}
