package kingsley.com.bookmate;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookInformationActivity extends AppCompatActivity {
    static String Btitle;
    static String Bauthor;
    static byte[] Bcover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info);

        /*Intent intent = getIntent();
        String TItle = intent.getStringExtra(Tab1Fragment.EXTRA_TITLE);
        String  AUthor = intent.getStringExtra(Tab1Fragment.EXTRA_AUTHOR);
        byte[] COver = intent.getByteArrayExtra(Tab1Fragment.EXTRA_COVER);
*/
        TextView Btitle1 = findViewById(R.id.book_title);
        TextView Bauthor1 = findViewById(R.id.author);
        ImageView Bcover1 = findViewById(R.id.book_Cover);

        Btitle1.setText(Btitle);
        Bauthor1.setText(Bauthor);
        Bcover1.setImageBitmap(Helper.getImage(Bcover));



    }

}
