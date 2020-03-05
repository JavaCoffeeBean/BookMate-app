package sqliteStuff;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import kingsley.com.bookmate.Book;
import kingsley.com.bookmate.Book2;

public class BookViewModel extends AndroidViewModel {

    private BookRepository repository;
    private LiveData<List<Book>> allBooks;
    private LiveData<List<Book2>> allBooks2;


    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooks = repository.getAllBooks();
        allBooks2 = repository.getAllBooks2();
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




    public void insert2(Book2 bookEntry) {
        repository.insert2(bookEntry);
    }

    public void update2(Book2 bookEntry) {
        repository.update2(bookEntry);
    }

    public void delete2(Book2 bookEntry) {
        repository.delete2(bookEntry);
    }

    public void deleteAllNotes2() {
        repository.deleteAllNotes2();
    }

    public LiveData<List<Book2>> getAllBooks2() {
        return allBooks2;
    }
}




