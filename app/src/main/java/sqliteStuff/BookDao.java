package sqliteStuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(BookEntry bookEntry);

    @Update
    void update(BookEntry bookEntry);

    @Delete
    void delete(BookEntry bookEntry);

    @Query("DELETE FROM book_table")
    void deleteAllBookentries();

    @Query("SELECT * FROM book_table ORDER BY priority DESC")
    LiveData<List<BookEntry>> getAllBookEntries();
}
