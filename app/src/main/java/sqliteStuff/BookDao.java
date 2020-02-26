package sqliteStuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tabian.com.actionbar.Book;
import tabian.com.actionbar.Book2;

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




    @Insert
    void insert2(Book2 bookEntry);

    @Update
    void update2(Book2 bookEntry);

    @Delete
    void delete2(Book2 bookEntry);

    @Query("DELETE FROM book_table2")
    void deleteAllBookentries2();

    @Query("SELECT * FROM book_table2 ORDER BY priority DESC")
    LiveData<List<Book2>> getAllBookEntries2();
}
