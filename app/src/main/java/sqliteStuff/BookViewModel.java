package sqliteStuff;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import tabian.com.actionbar.Book;

public class BookViewModel extends AndroidViewModel {

    private BookRepository repository;
    private LiveData<List<Book>> allBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooks = repository.getAllBooks();
    }

    public void insert(Book bookEntry) {
        repository.insert(bookEntry);
    }

    public void update(Book bookEntry) {
        repository.update(bookEntry);
    }

    public void delete(Book bookEntry) {
        repository.delete(bookEntry);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }
}




