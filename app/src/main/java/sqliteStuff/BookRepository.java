package sqliteStuff;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import kingsley.com.bookmate.Book;
import kingsley.com.bookmate.Book2;

public class BookRepository {
    private BookDao bookDao;
    private LiveData<List<Book>> allBooks;
    private LiveData<List<Book2>> allBooks2;


    public BookRepository(Application application) {
        BookDatabase database = BookDatabase.getInstance(application);
        bookDao = database.bookDao();
        allBooks = bookDao.getAllBookEntries();
        allBooks2 = bookDao.getAllBookEntries2();
    }

    public void insert(Book bookEntry) {
        new InsertNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void update(Book bookEntry) {
        new UpdateNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void delete(Book bookEntry) {
        new DeleteNoteAsyncTask(bookDao).execute(bookEntry);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(bookDao).execute();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }






    public void insert2(Book2 bookEntry) {
        new InsertNoteAsyncTask2(bookDao).execute(bookEntry);
    }

    public void update2(Book2 bookEntry) {
        new UpdateNoteAsyncTask2(bookDao).execute(bookEntry);
    }

    public void delete2(Book2 bookEntry) {
        new DeleteNoteAsyncTask2(bookDao).execute(bookEntry);
    }

    public void deleteAllNotes2() {
        new DeleteAllNotesAsyncTask(bookDao).execute();
    }

    public LiveData<List<Book2>> getAllBooks2() {
        return allBooks2;
    }







    private static class InsertNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private InsertNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... bookEntries) {
            bookDao.insert(bookEntries[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private UpdateNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... bookEntries) {
            bookDao.update(bookEntries[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private DeleteNoteAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... bookEntries) {
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












    private static class InsertNoteAsyncTask2 extends AsyncTask<Book2, Void, Void> {
        private BookDao bookDao;

        private InsertNoteAsyncTask2(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book2... bookEntries) {
            bookDao.insert2(bookEntries[0]);
            return null;
        }
    }




    private static class UpdateNoteAsyncTask2 extends AsyncTask<Book2, Void, Void> {
        private BookDao bookDao;

        private UpdateNoteAsyncTask2(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book2... bookEntries) {
            bookDao.update2(bookEntries[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask2 extends AsyncTask<Book2, Void, Void> {
        private BookDao bookDao;

        private DeleteNoteAsyncTask2(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book2... bookEntries) {
            bookDao.delete2(bookEntries[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask2 extends AsyncTask<Void, Void, Void> {
        private BookDao bookDao;

        private DeleteAllNotesAsyncTask2(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAllBookentries2();
            return null;
        }
    }
}