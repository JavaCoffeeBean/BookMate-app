package kingsley.com.bookmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookInformation2 extends AppCompatActivity {
    static String Btitle;
    static String Bauthor;
    static byte[] Bcover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info2);

        /*Intent intent = getIntent();
        String TItle = intent.getStringExtra(Tab1Fragment.EXTRA_TITLE);
        String  AUthor = intent.getStringExtra(Tab1Fragment.EXTRA_AUTHOR);
        byte[] COver = intent.getByteArrayExtra(Tab1Fragment.EXTRA_COVER);
*/
        TextView Btitle1 = findViewById(R.id.book_title);
        TextView Bauthor1 = findViewById(R.id.author);
        ImageView Bcover1 = findViewById(R.id.book_Cover);
        ImageButton Bback = findViewById(R.id.bookinfo_back);

        Btitle1.setText(Btitle);
        Bauthor1.setText(Bauthor);
        Bcover1.setImageBitmap(Helper.getImage(Bcover));

        Bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity2Intent2 = new Intent(BookInformation2.this, MainActivity.class);
                startActivity(activity2Intent2);
            }
        });



    }
}
