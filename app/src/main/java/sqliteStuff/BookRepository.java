package sqliteStuff;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {
    private BookDao bookDao;
    private LiveData<List<BookEntry>> allBooks;

    public BookRepository(Application application) {
        BookDatabase database = BookDatabase.getInstance(application);
        bookDao = database.bookDao();
        allBooks = bookDao.getAllBookEntries();
    }

    public void insert(BookEntry bookEntry) {
        new InsertNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void update(BookEntry bookEntry) {
        new UpdateNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void delete(BookEntry bookEntry) {
        new DeleteNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(bookDao).execute();
    }

    public LiveData<List<BookEntry>> getAllBooks() {
        return allBooks;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<BookEntry, Void, Void> {
        private BookDao bookDao;

        private InsertNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(BookEntry... bookEntries) {
            bookDao.insert(bookEntries[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<BookEntry, Void, Void> {
        private BookDao bookDao;

        private UpdateNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(BookEntry... bookEntries) {
            bookDao.update(bookEntries[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<BookEntry, Void, Void> {
        private BookDao bookDao;

        private DeleteNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(BookEntry... bookEntries) {
            bookDao.delete(bookEntries[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private BookDao bookDao;

        private DeleteAllNotesAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAllBookentries();
            return null;
        }
    }
}