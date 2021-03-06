package sqliteStuff;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import kingsley.com.bookmate.Book;
import kingsley.com.bookmate.Book2;

@Database(entities = {Book.class, Book2.class}, version = 2)
public abstract class BookDatabase extends RoomDatabase {

    private static BookDatabase instance;

    public abstract BookDao bookDao();

    public static synchronized BookDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
            BookDatabase.class, "Book_Database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private BookDao bookDao;

        private PopulateDbAsyncTask(BookDatabase db) {
            bookDao = db.bookDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {




           /* bookDao.insert(new BookEntry("Title 1", "Description 1", Bitmap, "pol",5));
            bookDao.insert(new BookEntry("Title 2", "Description 2", 2));
            bookDao.insert(new BookEntry("Title 3", "Description 3", 3));*/
            return null;
        }
    }
}