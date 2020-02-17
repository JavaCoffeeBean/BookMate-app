package tabian.com.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import sqliteStuff.BookViewModel;


public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private TextView txtResult;
    public static final int ADD_BOOK_REQUEST =1;
    public static final String SCAN_TEXT = "tabian.com.actionbar";
    private static final String TAG = "MainActivity";

    private TextView book_title;
    private TextView book_author;
    private ImageView book_cover;
    private BookViewModel bookViewModel;

    private Tab1Fragment tab1Fragment;

    ScanResult scanResult = new ScanResult();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        tab1Fragment = new Tab1Fragment();

        //init
        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);

        scannerView.setResultHandler(ScanActivity.this);
        scannerView.startCamera();


    }

    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        //Here we can receive raw result
        String scann = rawResult.toString();

        txtResult.setText(rawResult.getText());



        /*MainActivity.mainIntent = new Intent(MainActivity.mainContext, ScanResult.class );
        MainActivity.mainIntent.putExtra(SCAN_TEXT, scann);*/

        Intent intent = new Intent(ScanActivity.this, ScanResult.class);
        intent.putExtra(SCAN_TEXT, scann);
        startActivityForResult(intent, ADD_BOOK_REQUEST);
        /*startActivityForResult(MainActivity.mainIntent, ADD_BOOK_REQUEST );*/


        /*scannerView.startCamera();*/



    }

    @Override
    protected void onResume() {
        super.onResume();

        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);

        scannerView.setResultHandler(ScanActivity.this);
        scannerView.startCamera();
    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_BOOK_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(ScanResult.EXTRA_TITLE);
            String author = data.getStringExtra(ScanResult.EXTRA_AUTHOR);
            byte[] cover = data.getByteArrayExtra(ScanResult.EXTRA_COVER);
            int priority = data.getIntExtra(ScanResult.EXTRA_PRIORITY, 1);

            Book book = new Book(title, author, cover, R.drawable.trash, R.drawable.add_circle_red, priority);
            bookViewModel.insert(book);

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();
        }
    }*/
}
