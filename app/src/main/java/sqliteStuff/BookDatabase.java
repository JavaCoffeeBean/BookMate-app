package sqliteStuff;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = BookEntry.class, version = 1)
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
}
