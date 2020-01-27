package sqliteStuff;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private BookRepository repository;
    private LiveData<List<BookEntry>> allBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooks = repository.getAllBooks();
    }

    public void insert(BookEntry bookEntry) {
        repository.insert(bookEntry);
    }

    public void update(BookEntry bookEntry) {
        repository.update(bookEntry);
    }

    public void delete(BookEntry bookEntry) {
        repository.delete(bookEntry);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<BookEntry>> getAllBooks() {
        return allBooks;
    }
}




